/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.action.city;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.ax.action.MyAction;
import com.ax.exception.ActionException;
import com.ax.exception.DaoException;
import com.ax.service.city.CityService;

/**
 * (一句话功能简述)
 * 城市二级下拉框Action
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
@Namespace("/city")
public class CityAction extends MyAction{
	@Resource
	private CityService cityService;
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * 获取所有省份
	 * 
	 * @author       张洪斌  1079039435@qq.com
	 * @throws IOException 
	 * @throws ActionException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 */
	@Action(value = "provinces", results = { @Result(type = "json") })
	public void getAllProvince() throws ActionException, IOException{
		    String json;
			try {
				json = this.toJson(cityService.getProvinces());
				System.out.println(json);
				this.setResp(ServletActionContext.getResponse());
				this.sendResponse(json);
			} catch (DaoException e1) {
				
				e1.printStackTrace();
			}
			
			}
	
}
