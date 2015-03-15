/*
 * Title:        爱学圈服务器 2015年1月27日
 * Description:  文件上传和下载处理
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月27日
 */
package com.ax.action;

import javax.annotation.Resource;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.utils.ConfigReader;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 进行文件的上传和文件的下载
 * 主要处理的文件格式为图片
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月27日
 */
@Controller
@ParentPackage("json-default")
@Namespace("/file")
public class FileAction extends ActionSupport{

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private ConfigReader configReader;
	private int type;
	/**
	 * 
	 * (一句话功能简述)
	 * 文件上传
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 */
	@Action(value="upload",results={
			@Result(type="json")
	})
	public void upload(){
		
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	
	
	
}
