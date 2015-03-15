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
 * 报名表
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月25日
 */
@Entity
@Table(name="T_APPLY")
public class Apply implements Serializable{
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private int userid;
	private int type;
	private Date applyTime;
	private boolean isfree;
	private int state;
	private int courseidOrActivityid;
	public Apply() {
		super();
		
	}
	
	public Apply(String id, int userid, int type, Date applyTime, boolean isfree, int state, int courseidOrActivityid) {
		super();
		this.id = id;
		this.userid = userid;
		this.type = type;
		this.applyTime = applyTime;
		this.isfree = isfree;
		this.state = state;
		this.courseidOrActivityid = courseidOrActivityid;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "APPLY_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@Column(name="APPLY_USERID")
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name="APPLY_TYPE")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="APPLY_APPLYTIME",length=19,columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	@Column(name="APPLY_ISFREE")
	public boolean isIsfree() {
		return isfree;
	}
	public void setIsfree(boolean isfree) {
		this.isfree = isfree;
	}
	@Column(name="APPLY_STATE")
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Column(name="APPLY_COURSEIDORACTIVITYID")
	public int getCourseidOrActivityid() {
		return courseidOrActivityid;
	}
	public void setCourseidOrActivityid(int courseidOrActivityid) {
		this.courseidOrActivityid = courseidOrActivityid;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((applyTime == null) ? 0 : applyTime.hashCode());
		result = prime * result + courseidOrActivityid;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isfree ? 1231 : 1237);
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
		Apply other = (Apply) obj;
		if (applyTime == null) {
			if (other.applyTime != null)
				return false;
		} else if (!applyTime.equals(other.applyTime))
			return false;
		if (courseidOrActivityid != other.courseidOrActivityid)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isfree != other.isfree)
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
		return "Apply [id=" + id + ", userid=" + userid + ", type=" + type + ", applyTime=" + applyTime + ", isfree="
				+ isfree + ", state=" + state + ", courseidOrActivityid=" + courseidOrActivityid + "]";
	}
	
	
	
}
