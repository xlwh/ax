/*
 * Title:        爱学圈服务器 2015年2月2日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月2日
 */
package com.ax.action.school;

import java.io.IOException;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.ax.action.MyAction;
import com.ax.exception.ActionException;
import com.ax.exception.ActionExceptionHandle;
import com.ax.exception.DaoException;
import com.ax.service.school.SchoolService;

/**
 * (一句话功能简述)
 * 学校相关的业务逻辑的请求和响应的处理
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月2日
 */
@Namespace("/school")
public class SchoolAction extends MyAction{
    
	@Resource
	private SchoolService schoolService;
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 获取学校列表
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 */
	@Action(value="all",results={@Result(type="json")})
	public void getAll(){
		this.setResp(ServletActionContext.getResponse());
		try {
			String json = this.toJson(schoolService.getAll());
			try {
				this.sendResponse(json);
			} catch (ActionException e) {
				ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
				e.printStackTrace();
			} catch (IOException e) {
				ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
				e.printStackTrace();
			}
		} catch (DaoException e) {
			ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
			e.printStackTrace();
		}
	}

}
