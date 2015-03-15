package com.ax.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 教师推荐信息
 * @author zhanghongbin
 *
 */

@Entity
@Table(name = "T_TEACHERRECOMMENDINFO")
public class TeacherRecommendInfo {
	private int id;
	private int userID;
	private String pic;
	private String name;
	private String title;
	private int star;
	private String major;
	private int courseid;

	@Id
	@GeneratedValue
	@Column(name = "TEACHERRECOMMENDINFO_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "TEACHERRECOMMENDINFO_USERID")
	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Column(name = "TEACHERRECOMMENDINFO_PIC", length = 50)
	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Column(name = "TEACHERRECOMMENDINFO_NAME", length = 10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "TEACHERRECOMMENDINFO_TITLE", length = 50)
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "TEACHERRECOMMENDINFO_STAR")
	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	@Column(name = "TEACHERRECOMMENDINFO_MAJOR", length = 10)
	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	@Column(name = "TEACHERRECOMMENDINFO_COURSEID")
	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

}
