/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  认证相关的请求处理
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.app.action.user;

import java.io.File;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.junit.Test;

import com.ax.action.MyAction;
import com.ax.service.user.UserService;
import com.ax.utils.ConfigReader;
import com.ax.utils.FileUtils;

/**
 * (一句话功能简述)
 * 认证相关的请求处理
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
@Namespace("/user")
public class IdentificationAction extends MyAction {

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private File file;
	private String fileContentType;
	private String fileFileName;
	private int type;
	private int uid;
	@Resource
	private ConfigReader configReader;
	@Resource
	private UserService userService;

	@Action(value = "idfc", results = { @Result(type = "json") })
	public void upload(){
		this.setResp(ServletActionContext.getResponse());
		String dir = configReader.getImageDir();
		String name = buildFileName();
		if(file != null){
			try{
				FileUtils.upload(file, dir, name);
				int tp = getType();
				this.setState(200);
			    this.setInfo("success!");
				userService.idfcUser(tp, uid, name);
				}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		this.sendNull();
	}

	/**
	 * 生成文件名
	 */
	@Test
	private String buildFileName() {
		long mill = System.currentTimeMillis(); //获取毫秒时间
		String filename = "" + mill + getFileFileName();
		return filename;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

}
