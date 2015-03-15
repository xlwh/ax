/*
 * Title:        爱学圈服务器 2015年1月23日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月23日
 */
package com.ax.web.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.bean.Teacher;
import com.ax.service.user.TeacherService;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 老师相关的action
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月23日
 */

@Controller
@ParentPackage("json-default")
@Namespace("/web")
public class TeacherAction extends ActionSupport {

	@Resource
	private TeacherService teacherService;
	private static final long serialVersionUID = 1L;
	private String name;
	private int page;
	private int pageSize;
	
	
	private String gender;
	private int age;
	private String edu;
	private String course;
    private String phone;
    private File pic;
    
	@Action(value = "teacher", results = { @Result(type = "json") })
	public void getAll() {
		System.out.println("当前页码：" + page);
		List<Teacher> teachers = null;
		teachers = teacherService.getAll(page, pageSize);
        JSONObject obj = new JSONObject();
		obj.put("total", teacherService.getCount());
		JSONArray array = new JSONArray();
		System.out.println("向服务器获取数据");
		for (Teacher th : teachers) {
			array.add(th);
		}
		obj.put("rows", array);

		try {
			HttpServletResponse resp = ServletActionContext.getResponse();
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().print(obj.toString());
			System.out.println(obj.toString());
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	/**
	 * 
	 * 搜索老师
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 */
	public void queryTeacher() {
		JSONObject obj = new JSONObject();
		obj.put("total", "10");
		JSONArray array = new JSONArray();
		for (int i = 0; i < 10; i++) {
			Teacher th = new Teacher();
			th.setId(i);
			th.setName("杨老师");
			th.setNicName("落雪无痕");
			th.setPhone("18951899340");
			th.setState("已认证");
			//th.setType("私教");
			array.add(th);
		}
		obj.put("rows", array);
		System.out.println("搜索老师");
		System.out.println(obj.toString());
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		try {
			resp.getWriter().print(obj.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Action(value = "saveteacher", results = { @Result(type = "json") })
	public void save() {
		Teacher teacher = new Teacher();
		teacher.setAge(age);
		teacher.setGender(gender);
		teacher.setMajor(course);
		teacher.setPhone(phone);
	}

	@Action(value = "updateteacher", results = { @Result(type = "json") })
	public void update() {
		System.out.println("更新名师信息");
	}

	@Action(value = "deleteteacher", results = { @Result(type = "json") })
	public void delete() {
		System.out.println("删除名师信息");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEdu() {
		return edu;
	}

	public void setEdu(String edu) {
		this.edu = edu;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public File getPic() {
		return pic;
	}

	public void setPic(File pic) {
		this.pic = pic;
	}
	
	

}
