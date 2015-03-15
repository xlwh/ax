/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.action.commonent;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.action.ActionResult;
import com.ax.action.MyAction;
import com.ax.exception.ActionException;
import com.ax.exception.ActionExceptionHandle;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;
import com.ax.service.commonent.CommonentService;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
@Controller
@ParentPackage("json-default")
@Namespace("/user")
public class CommonentAction extends MyAction {
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private CommonentService commonentService;
	//老师的id
	private int uid = -1;
	private int page = -1;
	private int tid = -1;
	private int level = -1;
	private String content;

	/**
	 * 
	 * 获取针对某个老师的评论
	 * 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @throws ActionException
	 * @throws IOException
	 */
	@Action(value = "getcmt", results = { @Result(type = "json") })
	public void getCommonent() throws ActionException, IOException {
		int id = getUid();
		ActionResult action = new ActionResult();
		HttpServletResponse resp = ServletActionContext.getResponse();
		action.setResp(resp);
		if (id == -1 || page == -1) {
			//客户端传参数异常
			action.setInfo("参数异常，请检查参数");
			action.setState(201);
			action.sendNull();
		} else {
			try {
				List<CommonentResult> cmts = commonentService.findByTid(id, page);
				action.sendResponse(action.toJson(cmts));
			} catch (DaoException e) {
				ActionExceptionHandle.handle(e, resp);
				e.printStackTrace();
			}
		}

	}

	/**
	 * 
	 * 对某个老师发表评论
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 */
	@Action(value = "writecmt", results = { @Result(type = "json") })
	public void write() {
		if (getUid() != -1 && getTid() != -1 && getLevel() != -1 && getContent() != null) {
			this.setResp(ServletActionContext.getResponse());
			try {
				commonentService.writeCommonent(uid, tid, level, content);
				this.sendSuccess();
			} catch (DaoException e) {
				ActionExceptionHandle.handle(new NullPointException("请求参数错误"), ServletActionContext.getResponse());
				e.printStackTrace();
			}
		} else {
			ActionExceptionHandle.handle(new NullPointException("请求参数错误"), ServletActionContext.getResponse());
		}
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
