/*
 * Title:        爱学圈服务器 2015年1月23日
 * Description:  教师表
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月23日
 */
package com.ax.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

/**
 * 教师表
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月23日
 */
@Entity
@Table(name = "T_TEACHER")
@Indexed
public class Teacher {
	private int id;
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String nicName;
	private String phone;
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private int type;
	private String state;
	private String pic;
	private String gender;
	private int age;
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String major;
	private String desc;
	private String address;
	private String edu;
	private float exp;
	private int star;
	private List<Rank> rank;

	public Teacher() {
		super();
	}

	public Teacher(int id, String name, String nicName, String phone, int type, String state, String pic,
			String gender, int age, String major, String desc, String address, String edu, float exp, int star,
			List<Rank> rank) {
		super();
		this.id = id;
		this.name = name;
		this.nicName = nicName;
		this.phone = phone;
		this.type = type;
		this.state = state;
		this.pic = pic;
		this.gender = gender;
		this.age = age;
		this.major = major;
		this.desc = desc;
		this.address = address;
		this.edu = edu;
		this.exp = exp;
		this.star = star;
		this.rank = rank;
	}

	@Column(name = "TEACHER_STAR")
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@GeneratedValue
	@Id
	@Column(name = "TEACHER_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TEACHER_NAME", length = 20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TEACHER_NICNAME", length = 20)
	public String getNicName() {
		return nicName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}

	@Column(name = "TEACHER_PHONE", length = 11)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "TEACHER_TYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "TEACHER_STATE", length = 20)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "TEACHER_PIC", length = 50)
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "TEACHER_GENDER", length = 2)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "TEACHER_AGE")
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "TEACHER_MAJOR", length = 20)
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "TEACHER_DESC", length = 1000)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "TEACHER_ADDRESS", length = 150)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "TEACHER_EDU", length = 20)
	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	@Column(name = "TEACHER_EXP")
	public float getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "TEACHER_RANK")
	public List<Rank> getRank() {
		return rank;
	}

	public void setRank(List<Rank> rank) {
		this.rank = rank;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((edu == null) ? 0 : edu.hashCode());
		result = prime * result + Float.floatToIntBits(exp);
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nicName == null) ? 0 : nicName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + star;
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + type;
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
		Teacher other = (Teacher) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (desc == null) {
			if (other.desc != null)
				return false;
		} else if (!desc.equals(other.desc))
			return false;
		if (edu == null) {
			if (other.edu != null)
				return false;
		} else if (!edu.equals(other.edu))
			return false;
		if (Float.floatToIntBits(exp) != Float.floatToIntBits(other.exp))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (major == null) {
			if (other.major != null)
				return false;
		} else if (!major.equals(other.major))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nicName == null) {
			if (other.nicName != null)
				return false;
		} else if (!nicName.equals(other.nicName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (pic == null) {
			if (other.pic != null)
				return false;
		} else if (!pic.equals(other.pic))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (star != other.star)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", nicName=" + nicName + ", phone=" + phone + ", type=" + type
				+ ", state=" + state + ", pic=" + pic + ", gender=" + gender + ", age=" + age + ", major=" + major
				+ ", desc=" + desc + ", address=" + address + ", edu=" + edu + ", exp=" + exp + ", star=" + star
				+ ", rank=" + rank + "]";
	}

}
