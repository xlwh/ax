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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * (一句话功能简述)
 * 课程信息实体bean
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月25日
 */
@Entity
@Table(name = "T_COURSE")
@Indexed
public class Course implements Serializable {
	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	@Field(index = Index.YES, store = Store.YES)
	private String name;
	private int userid;
	private Date start;
	private Date end;
	private String LocationId;
	private float price;
	private float avgPrice;
	private String desc;
	private String address;
	private int type;
	//课程状态0：取消  1：等待开课 2：开课中 3：课程已经结束
	private int state;
	/**课程所属科目**/
	private Subject subject;
	private int schoolid;
	
	public Course() {
		super();

	}

	@Column(name = "T_COURSETYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Id
	@Column(name = "COURSE_ID")
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "COURSE_NAME", length = 40)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "COURSE_USERID")
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COURSE_START")
	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "COURSE_END")
	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	@Column(name = "COURSE_LOCATIONID")
	public String getLocationId() {
		return LocationId;
	}

	public void setLocationId(String locationId) {
		LocationId = locationId;
	}

	@Column(name = "COURSE_PRICE")
	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Column(name = "COURSE_AVGPRICE")
	public float getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(float avgPrice) {
		this.avgPrice = avgPrice;
	}

	@Column(name = "COURSE_DESC", length = 4000)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "COURSE_ADDRESS", length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "COURSE_STATE")
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SUBJECTID", unique = true)
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	@Column(name="COURSE_SCHOOLID")
	public int getSchoolid() {
		return schoolid;
	}

	public void setSchoolid(int schoolid) {
		this.schoolid = schoolid;
	}

	public Course(int id, String name, int userid, Date start, Date end, String locationId, float price,
			float avgPrice, String desc, String address, int type, int state, Subject subject, int schoolid) {
		super();
		this.id = id;
		this.name = name;
		this.userid = userid;
		this.start = start;
		this.end = end;
		LocationId = locationId;
		this.price = price;
		this.avgPrice = avgPrice;
		this.desc = desc;
		this.address = address;
		this.type = type;
		this.state = state;
		this.subject = subject;
		this.schoolid = schoolid;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + ", userid=" + userid + ", start=" + start + ", end=" + end
				+ ", LocationId=" + LocationId + ", price=" + price + ", avgPrice=" + avgPrice + ", desc=" + desc
				+ ", address=" + address + ", type=" + type + ", state=" + state + ", subject=" + subject + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((LocationId == null) ? 0 : LocationId.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + Float.floatToIntBits(avgPrice);
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((end == null) ? 0 : end.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + schoolid;
		result = prime * result + ((start == null) ? 0 : start.hashCode());
		result = prime * result + state;
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
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
		Course other = (Course) obj;
		if (LocationId == null) {
			if (other.LocationId != null)
				return false;
		} else if (!LocationId.equals(other.LocationId))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (Float.floatToIntBits(avgPrice) != Float.floatToIntBits(other.avgPrice))
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (end == null) {
			if (other.end != null)
				return false;
		} else if (!end.equals(other.end))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (schoolid != other.schoolid)
			return false;
		if (start == null) {
			if (other.start != null)
				return false;
		} else if (!start.equals(other.start))
			return false;
		if (state != other.state)
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (type != other.type)
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

}
