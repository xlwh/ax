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
 * 学习圈动态实体bean
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月25日
 */
@Entity
@Table(name="T_SHAREDMESSAGE")
public class SharedMessage implements Serializable{
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private Date CreateTime;
	private String content;
	private String pic;
	private int viewed;
	private int forward;
	public SharedMessage() {
		super();
		
	}
	public SharedMessage(String id, Date createTime, String content, String pic, int viewed, int forward) {
		super();
		this.id = id;
		CreateTime = createTime;
		this.content = content;
		this.pic = pic;
		this.viewed = viewed;
		this.forward = forward;
	}
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "SHAREDMESSAGE_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="SHAREDMESSAGE_CREATETIME")
	public Date getCreateTime() {
		return CreateTime;
	}
	public void setCreateTime(Date createTime) {
		CreateTime = createTime;
	}
	@Column(name="SHAREDMESSAGE_CONTENT",length=4000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="SHAREDMESSAGE_PIC",length=150)
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	@Column(name="SHAREDMESSAGE_VIEWED")
	public int getViewed() {
		return viewed;
	}
	public void setViewed(int viewed) {
		this.viewed = viewed;
	}
	@Column(name="SHAREDMESSAGE_FORWARD")
	public int getForward() {
		return forward;
	}
	public void setForward(int forward) {
		this.forward = forward;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CreateTime == null) ? 0 : CreateTime.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + forward;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + viewed;
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
		SharedMessage other = (SharedMessage) obj;
		if (CreateTime == null) {
			if (other.CreateTime != null)
				return false;
		} else if (!CreateTime.equals(other.CreateTime))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (forward != other.forward)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (viewed != other.viewed)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SharedMessage [id=" + id + ", CreateTime=" + CreateTime + ", content=" + content + ", pic=" + pic
				+ ", viewed=" + viewed + ", forward=" + forward + "]";
	}
	
	
	
	
}
