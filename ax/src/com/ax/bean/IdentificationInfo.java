package com.ax.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 证书认证信息表
 * @author zhang
 *
 */

@Entity
@Table(name="T_IDENTIFICATIONINFO")
public class IdentificationInfo {
	/**认证信息主键***/
	private int id;
	/**证书类型：0：学历认证 1:职业认证 2：其他认证**/
	private int type;
	/**用户ID**/
	private int userID;
	/**证书ID**/
	private int qualificationID;
	/**认证状态：0：认证中  1：认证成功  2：认证失败**/
	private int state;
	private Date createTime;
	
	
	public IdentificationInfo() {
		super();
		
	}
	
	public IdentificationInfo(int id, int type, int userID,
			int qualificationID, int state, Date createTime) {
		super();
		this.id = id;
		this.type = type;
		this.userID = userID;
		this.qualificationID = qualificationID;
		this.state = state;
		this.createTime = createTime;
	}



	@Id
	@GeneratedValue
	@Column(name="IDENTIFACATIONINFO_ID")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="IDENTIFACATIONINFO_TYPE")
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	@Column(name="IDENTIFACATIONINFO_USERID")
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	@Column(name="IDENTIFACATIONINFO_QULIFICATIONID")
	public int getQualificationID() {
		return qualificationID;
	}
	public void setQualificationID(int qualificationID) {
		this.qualificationID = qualificationID;
	}
	@Column(name="IDENTIFACATIONINFO_STATE")
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	@Column(name="IDENTIFACATIONINFO_CREATETIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "IdentificationInfo [id=" + id + ", type=" + type + ", userID="
				+ userID + ", qualificationID=" + qualificationID + ", state="
				+ state + ", createTime=" + createTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + id;
		result = prime * result + qualificationID;
		result = prime * result + state;
		result = prime * result + type;
		result = prime * result + userID;
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
		IdentificationInfo other = (IdentificationInfo) obj;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id != other.id)
			return false;
		if (qualificationID != other.qualificationID)
			return false;
		if (state != other.state)
			return false;
		if (type != other.type)
			return false;
		if (userID != other.userID)
			return false;
		return true;
	}
	
	
	
}
