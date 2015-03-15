/*
 * Title:        爱学圈服务器 2015年3月9日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月9日
 */
package com.ax.action.circle;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.action.MyAction;
import com.ax.bean.CircleMessage;
import com.ax.exception.ActionException;
import com.ax.exception.ActionExceptionHandle;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */

@Controller
@ParentPackage("json-default")
@Namespace("/circle")
public class CircleAction extends MyAction {

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private float lng;
	private float lat;
	private int uid;
	private String content;
	private File[] image; //上传的文件
	private String[] imageFileName; //文件名称
	private String[] imageContentType; //文件类型
	
	@Action(value = "getnearby", results = { @Result(type = "json") })
	public String getNearby() {

		this.setResp(ServletActionContext.getResponse());
		List<CircleMessage> messages = new ArrayList<CircleMessage>();
		for (int i = 0; i < 10; i++) {
			CircleMessage msg = new CircleMessage();
			msg.setLat(10.01f);
			msg.setLng(45.5f);
			msg.setContent("这是测试数据");
			msg.setPraised(1);
			msg.setUid(1);
			msg.setVisited(20);
			messages.add(msg);

			messages.add(msg);
		}
		String json = super.toJson(messages);
		try {
			super.sendResponse(json);
		} catch (ActionException e) {
			e.printStackTrace();
			ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
		} catch (IOException e) {
			e.printStackTrace();
			ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
		}
		return SUCCESS;
	}

	
	@Action(value = "write", results = { @Result(type = "json") })
	public String write() {
		this.setResp(ServletActionContext.getResponse());
		//这里需要接收经度和纬度、多张图片、以及内容来完成发表
		return SUCCESS;
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

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public File[] getImage() {
		return image;
	}

	public void setImage(File[] image) {
		this.image = image;
	}

	public String[] getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String[] imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String[] getImageContentType() {
		return imageContentType;
	}

	public void setImageContentType(String[] imageContentType) {
		this.imageContentType = imageContentType;
	}

}
