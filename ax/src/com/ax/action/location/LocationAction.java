/*
 * Title:        爱学圈服务器 2015年2月2日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月2日
 */
package com.ax.action.location;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.ax.action.MyAction;
import com.ax.exception.ActionException;
import com.ax.exception.ActionExceptionHandle;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;
import com.ax.service.location.LocationService;

/**
 * (一句话功能简述)
 * 位置相关的Action
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月2日
 */
@Namespace("/location")
public class LocationAction extends MyAction {

	@Resource
	private LocationService locationService;
	private double lng = -1;
	private double lat = -1;
	private int type = -1;
	private int r = -1;
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;

	@Action(value = "get", results = { @Result(type = "json") })
	public void get() {
		this.setResp(ServletActionContext.getResponse());

		if (check() == true) {
			if (r == -1) {
				//使用默认的半径来搜索
				try {
					List<LocationResult> result = locationService.getNearBy(getLng(), getLat(), getType());
					try {
						this.sendResponse(this.toJson(result));
					} catch (ActionException e) {
						ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
						e.printStackTrace();
					} catch (IOException e) {
						ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
						e.printStackTrace();
					}
				} catch (NullPointException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				} catch (DaoException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				}
			} else {
				//使用传入的KM数来搜索周边
				try {
					List<LocationResult> result = locationService.getNearBy(getLng(), getLat(), getType(), getR());
					String json = this.toJson(result);
					try {
						this.sendResponse(json);
					} catch (ActionException e) {
						ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
						e.printStackTrace();
					} catch (IOException e) {
						ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
						e.printStackTrace();
					}
				} catch (NullPointException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				} catch (DaoException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				}
			}
		} else {
			//传入参数错误
			ActionExceptionHandle.handle(new ActionException("传入参数错误"), ServletActionContext.getResponse());
		}
	}

	public LocationService getLocationService() {
		return locationService;
	}

	public void setLocationService(LocationService locationService) {
		this.locationService = locationService;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	/**
	 * 检查传入参数的合法性
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @return       检查的结果
	 */
	private boolean check() {
		boolean flag = false;
		if (lng == -1 || lat == -1 || type == -1) {
			flag = false;
		} else {
			flag = true;
		}
		return flag;
	}

}
