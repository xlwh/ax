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

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * (一句话功能简述)
 * 认证表实体类
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月25日
 */
@Entity
@Table(name = "T_IDENFICATION")
public class Identification implements Serializable {

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	/**主键**/
	private int id;
	private int type;
	private int userid;
	private int qualificationId;
	private int state;
	private Qualification qulification;
	private String name;

	public Identification() {
		super();

	}

	public Identification(int id, int type, int userid, int qualificationId, int state, Qualification qulification,
			String name) {
		super();
		this.id = id;
		this.type = type;
		this.userid = userid;
		this.qualificationId = qualificationId;
		this.state = state;
		this.qulification = qulification;
		this.name = name;
	}

	@Column(name = "IDENFICATION_NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue
	@Column(name = "IDENFICATION_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "IDENFICATION_TYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "IDENFICATION_USERID")
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	@Column(name = "IDENFICATION_IQUALIFICATIOND")
	public int getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(int qualificationId) {
		this.qualificationId = qualificationId;
	}

	@Column(name = "IDENFICATION_STATE")
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@OneToOne(cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	@JoinColumn(name = "IDENTIFIC_ID")
	public Qualification getQulification() {
		return qulification;
	}

	public void setQulification(Qualification qulification) {
		this.qulification = qulification;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + qualificationId;
		result = prime * result + ((qulification == null) ? 0 : qulification.hashCode());
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
		Identification other = (Identification) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (qualificationId != other.qualificationId)
			return false;
		if (qulification == null) {
			if (other.qulification != null)
				return false;
		} else if (!qulification.equals(other.qulification))
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
		return "Identification [id=" + id + ", type=" + type + ", userid=" + userid + ", qualificationId="
				+ qualificationId + ", state=" + state + ", qulification=" + qulification + ", name=" + name + "]";
	}

}
