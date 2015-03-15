package com.ax.bean;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Entity
@Table(name = "T_USERS")
@Indexed
public class Users {

	/**主键**/

	private int id;
	/**名字**/
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String name;
	/**昵称**/
	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO)
	private String nicName;
	/**密码**/
	private String password;
	/**头像**/
	private String pic;
	/**性别**/
	private String gender;
	/**电话号码**/
	private String phone;
	/**是否为认证用户**/
	private int isVerify;
	/**一句话**/
	private String title;
	/**自我描述，介绍**/
	private String description;
	/**是否在校**/
	private int isInSchool;
	/**授课经验：只给私教记录，上过一节课加10分**/
	private float experience;
	/**用户类型0：普通用户  1：私教  2：名师  3：既是名师又是私教  **/
	private int type;
	/**在线状态**/
	private int state;
	/**注册时间**/
	private Date createTime;
	private String qq;
	private String weixing;
	private String webo;
	/**学号**/
	private String studentid;

	private String major;
	private String desc;
	private String address;
	private String edu;
	private float exp;
	private int star;
	private List<Rank> rank;
	private int idfc;

	public Users() {
		super();

	}

	public Users(int id, String name, String nicName, String password, String pic, String gender, String phone,
			int isVerify, String title, String description, int isInSchool, float experience, int type, int state,
			Date createTime, String qq, String weixing, String webo, String studentid, String major, String desc,
			String address, String edu, float exp, int star, int idfc, List<Rank> rank) {
		super();
		this.id = id;
		this.name = name;
		this.nicName = nicName;
		this.password = password;
		this.pic = pic;
		this.gender = gender;
		this.phone = phone;
		this.isVerify = isVerify;
		this.title = title;
		this.description = description;
		this.isInSchool = isInSchool;
		this.experience = experience;
		this.type = type;
		this.state = state;
		this.createTime = createTime;
		this.qq = qq;
		this.weixing = weixing;
		this.webo = webo;
		this.studentid = studentid;
		this.major = major;
		this.desc = desc;
		this.address = address;
		this.edu = edu;
		this.exp = exp;
		this.star = star;
		this.rank = rank;
		this.idfc = idfc;
	}

	@Id
	@GeneratedValue
	@Column(name = "USERS_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "USERS_NAME", length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "USERS_NICNAME", length = 20)
	public String getNicName() {
		return nicName;
	}

	public void setNicName(String nicName) {
		this.nicName = nicName;
	}

	@Column(name = "USERS_PASSWORD", length = 16)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "USERS_PIC", length = 50)
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "USERS_GENDER", length = 2)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "USERS_PHONE", length = 11)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "USERS_VERIFY")
	public int getIsVerify() {
		return isVerify;
	}

	public void setIsVerify(int isVerify) {
		this.isVerify = isVerify;
	}

	@Column(name = "USERS_TITLE", length = 25)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "USERS_DESCRIPTION", length = 400)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "USERS_ISINSCHOOL")
	public int getIsInSchool() {
		return isInSchool;
	}

	public void setIsInSchool(int isInSchool) {
		this.isInSchool = isInSchool;
	}

	@Column(name = "USERS_EXPERIENCE")
	public float getExperience() {
		return experience;
	}

	public void setExperience(float experience) {
		this.experience = experience;
	}

	@Column(name = "USERS_TYPE")
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	@Column(name = "USERS_STATE")
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "USERS_CREATETIME", length = 19, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "USERS_QQ", length = 15)
	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	@Column(name = "USERS_WEIXING", length = 20)
	public String getWeixing() {
		return weixing;
	}

	public void setWeixing(String weixing) {
		this.weixing = weixing;
	}

	@Column(name = "USERS_WEBO", length = 30)
	public String getWebo() {
		return webo;
	}

	public void setWebo(String webo) {
		this.webo = webo;
	}

	@Column(name = "USERS_STUDENTID", length = 10)
	public String getStudentid() {
		return studentid;
	}

	public void setStudentid(String studentid) {
		this.studentid = studentid;
	}

	@Column(name = "USERS_MAJOR", length = 20)
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	@Column(name = "USERS_DESC", length = 200)
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "USERS_ADDRESS", length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "USERS_EDU", length = 50)
	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	@Column(name = "USERS_EXP")
	public float getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	@Column(name = "USERS_STAR")
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TEACHER_RANK")
	public List<Rank> getRank() {
		return rank;
	}

	public void setRank(List<Rank> rank) {
		this.rank = rank;
	}
	
	@Column(name="USERS_IDFC")
	public int getIdfc() {
		return idfc;
	}

	public void setIdfc(int idfc) {
		this.idfc = idfc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((desc == null) ? 0 : desc.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((edu == null) ? 0 : edu.hashCode());
		result = prime * result + Float.floatToIntBits(exp);
		result = prime * result + Float.floatToIntBits(experience);
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + id;
		result = prime * result + idfc;
		result = prime * result + isInSchool;
		result = prime * result + isVerify;
		result = prime * result + ((major == null) ? 0 : major.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((nicName == null) ? 0 : nicName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + ((pic == null) ? 0 : pic.hashCode());
		result = prime * result + ((qq == null) ? 0 : qq.hashCode());
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + star;
		result = prime * result + state;
		result = prime * result + ((studentid == null) ? 0 : studentid.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + type;
		result = prime * result + ((webo == null) ? 0 : webo.hashCode());
		result = prime * result + ((weixing == null) ? 0 : weixing.hashCode());
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
		Users other = (Users) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
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
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (edu == null) {
			if (other.edu != null)
				return false;
		} else if (!edu.equals(other.edu))
			return false;
		if (Float.floatToIntBits(exp) != Float.floatToIntBits(other.exp))
			return false;
		if (Float.floatToIntBits(experience) != Float.floatToIntBits(other.experience))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (id != other.id)
			return false;
		if (idfc != other.idfc)
			return false;
		if (isInSchool != other.isInSchool)
			return false;
		if (isVerify != other.isVerify)
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
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
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
		if (qq == null) {
			if (other.qq != null)
				return false;
		} else if (!qq.equals(other.qq))
			return false;
		if (rank == null) {
			if (other.rank != null)
				return false;
		} else if (!rank.equals(other.rank))
			return false;
		if (star != other.star)
			return false;
		if (state != other.state)
			return false;
		if (studentid == null) {
			if (other.studentid != null)
				return false;
		} else if (!studentid.equals(other.studentid))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type != other.type)
			return false;
		if (webo == null) {
			if (other.webo != null)
				return false;
		} else if (!webo.equals(other.webo))
			return false;
		if (weixing == null) {
			if (other.weixing != null)
				return false;
		} else if (!weixing.equals(other.weixing))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", nicName=" + nicName + ", password=" + password + ", pic="
				+ pic + ", gender=" + gender + ", phone=" + phone + ", isVerify=" + isVerify + ", title=" + title
				+ ", description=" + description + ", isInSchool=" + isInSchool + ", experience=" + experience
				+ ", type=" + type + ", state=" + state + ", createTime=" + createTime + ", qq=" + qq + ", weixing="
				+ weixing + ", webo=" + webo + ", studentid=" + studentid + ", major=" + major + ", desc=" + desc
				+ ", address=" + address + ", edu=" + edu + ", exp=" + exp + ", star=" + star + ", rank=" + rank
				+ ", idfc=" + idfc + "]";
	}

}
