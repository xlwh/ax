/*
 * Title:        爱学圈服务器 2015年2月5日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月5日
 */
package com.ax.app.action.user;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.ax.action.MyAction;

/**
 * (一句话功能简述)
 * 多条件检索Action
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月5日
 */
@Namespace("/user")
public class MultiSearchAction extends MyAction {

	private float lng;
	private float lat;
	private int r;
	private String keyword;
	private String subject;
	private boolean idfc;
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 *执行多条件检索
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月5日
	 */
	@Action(value = "msearch", results = { @Result(type = "json") })
	public void search() {
		this.setResp(ServletActionContext.getResponse());
		
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public boolean isIdfc() {
		return idfc;
	}

	public void setIdfc(boolean idfc) {
		this.idfc = idfc;
	}

}
