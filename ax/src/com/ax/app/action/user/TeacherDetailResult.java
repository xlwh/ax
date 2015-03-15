/*
 * Title:        爱学圈服务器 2015年1月26日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月26日
 */
package com.ax.app.action.user;

import java.util.List;

import com.ax.bean.Course;

/**
 * (一句话功能简述)
 * 用户的详细信息结果类型
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月26日
 */
public class TeacherDetailResult {
	/**用户ID**/
	private int id;
	/**姓名**/
	private String name;
	/**头衔**/
	private List<String> rank;
	/**性别**/
	private String gender;
	/**年龄**/
	private int age;
	/**认证情况**/
	private List<String> idfc;
	/**教育程度**/
	private String edu;
	/**用户类型**/
	private int type;
	/**地区**/
	private String address;
	/**简介**/
	private String desc;
	/**头像**/
	private String pic;
	/**星级，等级**/
	private int star;
	/**课程信息**/
	private Course course;
	/**辅导教龄**/
	private float exp;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<String> getIdfc() {
		return idfc;
	}

	public void setIdfc(List<String> idfc) {
		this.idfc = idfc;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getRank() {
		return rank;
	}

	public void setRank(List<String> rank) {
		this.rank = rank;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public float getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}
	
	

}
