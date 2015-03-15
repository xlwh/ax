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

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月25日
 */
@Entity
@Table(name="T_ACTIVITY")
@Indexed
public class Activity implements Serializable{

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	@Field(store=Store.YES)
	private String name;
	private String content;
	private String address;
	private String locationId;
	private Date StartTime;
	private Date endTime;
	private String phone;
	private String email;
	private int userid;
	private int num;
	private int applyed;
	private int applyid;
	private float charge;
	private boolean isfree;
	public Activity() {
		super();
		
	}
	public Activity(int id, String name, String content, String address, String locationId, Date startTime,
			Date endTime, String phone, String email, int userid, int num, int applyed, int applyid, float charge,
			boolean isfree) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.address = address;
		this.locationId = locationId;
		StartTime = startTime;
		this.endTime = endTime;
		this.phone = phone;
		this.email = email;
		this.userid = userid;
		this.num = num;
		this.applyed = applyed;
		this.applyid = applyid;
		this.charge = charge;
		this.isfree = isfree;
	}
	@Id
	@GeneratedValue
	@Column(name="ACTIVITY_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="ACTIVITY_NAME",length=25)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="ACTIVITY_CONTENT",length=4000)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@Column(name="ACTIVITY_ADDRESS",length=150)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="ACTIVITY_LOCATIONID",length=32)
	public String getLocationId() {
		return locationId;
	}
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACTIVITY_STARTTIME",length=19,columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date getStartTime() {
		return StartTime;
	}
	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ACTIVITY_ENDTIME",length=19,columnDefinition="timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	@Column(name="ACTIVITY_PHONE",length=11)
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	@Column(name="ACTIVITY_EMAIL",length=40)
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="ACTIVITY_USERID")
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	@Column(name="ACTIVITY_NUM")
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Column(name="ACTIVITY_APPLYED")
	public int getApplyed() {
		return applyed;
	}
	public void setApplyed(int applyed) {
		this.applyed = applyed;
	}
	@Column(name="ACTIVITY_APPLYID")
	public int getApplyid() {
		return applyid;
	}
	public void setApplyid(int applyid) {
		this.applyid = applyid;
	}
	@Column(name="ACTIVITY_CHARGE")
	public float getCharge() {
		return charge;
	}
	public void setCharge(float charge) {
		this.charge = charge;
	}
	@Column(name="ACTIVITY_ISFREE")
	public boolean isIsfree() {
		return isfree;
	}
	public void setIsfree(boolean isfree) {
		this.isfree = isfree;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((StartTime == null) ? 0 : StartTime.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + applyed;
		result = prime * result + applyid;
		result = prime * result + Float.floatToIntBits(charge);
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + id;
		result = prime * result + (isfree ? 1231 : 1237);
		result = prime * result + ((locationId == null) ? 0 : locationId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + num;
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Activity other = (Activity) obj;
		if (StartTime == null) {
			if (other.StartTime != null)
				return false;
		} else if (!StartTime.equals(other.StartTime))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (applyed != other.applyed)
			return false;
		if (applyid != other.applyid)
			return false;
		if (Float.floatToIntBits(charge) != Float.floatToIntBits(other.charge))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (id != other.id)
			return false;
		if (isfree != other.isfree)
			return false;
		if (locationId == null) {
			if (other.locationId != null)
				return false;
		} else if (!locationId.equals(other.locationId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (num != other.num)
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", content=" + content + ", address=" + address
				+ ", locationId=" + locationId + ", StartTime=" + StartTime + ", endTime=" + endTime + ", phone="
				+ phone + ", email=" + email + ", userid=" + userid + ", num=" + num + ", applyed=" + applyed
				+ ", applyid=" + applyid + ", charge=" + charge + ", isfree=" + isfree + "]";
	}
	
}
