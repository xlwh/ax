/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.app.action.user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.action.ActionResult;
import com.ax.exception.ActionException;
import com.ax.exception.ConvertJosnException;
import com.ax.service.user.UserService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * (一句话功能简述)
 * 用户信息相关的请求处理
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */
@Controller
@ParentPackage("json-default")
@Namespace("/user")
public class UserInfoAction extends ActionSupport {
	@Resource
	private ActionResult actionResult;
	@Resource
	private UserService userService;
	private int id;
	private String qq;
	private String weixin;
	private String weibo;
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * (一句话功能简述)
	 * 用户进行QQ账号的绑定
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	@Action(value = "bindqq", results = { @Result(type = "json") })
	public void bindQq() {
		actionResult.setResp(ServletActionContext.getResponse());
		String ks[] = { "result" };
		Map<String, Object> kvs = new HashMap<String, Object>();
		int res = 0;
		if (getId() > 0 && getQq() != null) {
			if (getQq().length() > 15 || getQq().length() <= 0) {
				actionResult.setState(201);
				actionResult.setInfo("参数错误");
			} else {
				userService.bindingQq(getId(), getQq());
				res = 1;
			}
		} else {
			actionResult.setState(201);
			actionResult.setInfo("参数错误");
		}
		kvs.put("result", res);
		try {
			String str = actionResult.toJson(ks, kvs);
			try {
				actionResult.sendResponse(str);
			} catch (ActionException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ConvertJosnException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * (一句话功能简述)
	 * 用户进行微信账号的绑定
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	@Action(value = "bindwx", results = { @Result(type = "json") })
	public void bindWx() {
		actionResult.setResp(ServletActionContext.getResponse());
		String ks[] = { "result" };
		Map<String, Object> kvs = new HashMap<String, Object>();
		int res = 0;
		if (getId() > 0 && getWeixin() != null) {
			if (getWeixin().length() > 15 || getWeixin().length() <= 0) {
				actionResult.setState(201);
				actionResult.setInfo("参数错误");
			} else {
				userService.bindingWexin(getId(), getWeixin());
				res = 1;
			}
		} else {
			actionResult.setState(201);
			actionResult.setInfo("参数错误");
		}
		kvs.put("result", res);
		try {
			String str = actionResult.toJson(ks, kvs);
			try {
				actionResult.sendResponse(str);
			} catch (ActionException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ConvertJosnException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * (一句话功能简述)
	 * 用户进行微博账号的绑定
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	@Action(value = "bindwb", results = { @Result(type = "json") })
	public void bindWb() {
		actionResult.setResp(ServletActionContext.getResponse());
		String ks[] = { "result" };
		Map<String, Object> kvs = new HashMap<String, Object>();
		int res = 0;
		if (getId() > 0 && getWeibo() != null) {
			if (getWeibo().length() > 15 || getWeibo().length() <= 0) {
				actionResult.setState(201);
				actionResult.setInfo("参数错误");
			} else {
				userService.bindingWebo(getId(), getWeibo());
				res = 1;
			}
		} else {
			actionResult.setState(201);
			actionResult.setInfo("参数错误");
		}
		kvs.put("result", res);
		try {
			String str = actionResult.toJson(ks, kvs);
			try {
				actionResult.sendResponse(str);
			} catch (ActionException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (ConvertJosnException e) {

			e.printStackTrace();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getWeibo() {
		return weibo;
	}

	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}

}
