/*
 * Title:        爱学圈服务器 2015年1月25日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月25日
 */
package com.ax.bean;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * (一句话功能简述)
 * 信息表实体类对象
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月25日
 */
@Entity
@Table(name="T_MESSAGE")
public class Message implements Serializable{

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int userid;
	private int type;
	private String sharedMessage;
	private Date createTime;
	private int state;
	public Message() {
		super();
		
	}
	public Message(String id, int userid, int type, String sharedMessage, Date createTime, int state) {
		super();
		this.id = id;
		this.userid = userid;
		this.type = type;
		this.sharedMessage = sharedMessage;
		this.createTime = createTime;
		this.state = state;
	}
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "MESSAGE_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="MESSAGE_USERID")
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name="MESSAGE_TYPE")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Column(name="MESSAGE_SHAREDMESSAGE",length=400)
	public String getSharedMessage() {
		return sharedMessage;
	}
	public void setSharedMessage(String sharedMessage) {
		this.sharedMessage = sharedMessage;
	}
	@Column(name="MESSAGE_CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="MESSAGE_STATE")
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((sharedMessage == null) ? 0 : sharedMessage.hashCode());
		result = prime * result + state;
		result = prime * result + type;
		result = prime * result + userid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (sharedMessage == null) {
			if (other.sharedMessage != null)
				return false;
		} else if (!sharedMessage.equals(other.sharedMessage))
			return false;
		if (state != other.state)
			return false;
		if (type != other.type)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", userid=" + userid + ", type=" + type + ", sharedMessage=" + sharedMessage
				+ ", createTime=" + createTime + ", state=" + state + "]";
	}
	
	
	
	

}
