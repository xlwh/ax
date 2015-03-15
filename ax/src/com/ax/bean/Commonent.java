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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * (一句话功能简述)
 * 评论表实体bean(课程，活动，教师)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月25日
 */
@Entity
@Table(name = "T_COMMENT")
public class Commonent implements Serializable {

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int userid;
	private int lever;
	private String desc;
	private int type;
	private Date createTime;
	private int state;
	private int teacherid;

	public Commonent() {
		super();

	}

	public Commonent(String id, int userid, int lever, String desc, int type, Date createTime, int state, int teacherid) {
		super();
		this.id = id;
		this.userid = userid;
		this.lever = lever;
		this.desc = desc;
		this.type = type;
		this.createTime = createTime;
		this.state = state;
		this.teacherid = teacherid;
	}

	@Column(name = "COMMONENT_STATE")
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Column(name = "COMMONEMT_TYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COMMONENT_TIME", length = 19, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "COMMONENT_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "COMMONENT_USERID")
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Column(name = "COMMONENT_LEVER")
	public int getLever() {
		return lever;
	}

	public void setLever(int lever) {
		this.lever = lever;
	}

	@Column(name = "COMMONENT_DESC", length = 400)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "COMMONENT_TEACHERID")
	public int getTeacherid() {
		return teacherid;
	}

	public void setTeacherid(int teacherid) {
		this.teacherid = teacherid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + lever;
		result = prime * result + state;
		result = prime * result + teacherid;
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
		Commonent other = (Commonent) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lever != other.lever)
			return false;
		if (state != other.state)
			return false;
		if (teacherid != other.teacherid)
			return false;
		if (type != other.type)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Commonent [id=" + id + ", userid=" + userid + ", lever=" + lever + ", desc=" + desc + ", type=" + type
				+ ", createTime=" + createTime + ", state=" + state + ", teacherid=" + teacherid + "]";
	}

}
