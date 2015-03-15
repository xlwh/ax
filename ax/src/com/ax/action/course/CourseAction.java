/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  课程相关的Action
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.action.course;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;

import com.ax.action.MyAction;
import com.ax.bean.Course;
import com.ax.dao.course.CourseDao;
import com.ax.exception.ActionException;
import com.ax.exception.ActionExceptionHandle;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;
import com.ax.service.course.CourseService;

/**
 * (一句话功能简述)
 * 负责接收请求并对相应的请求做出响应
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
@Namespace("/course")
public class CourseAction extends MyAction {

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	private int uid = -1;
	private int type = -1;
	private String subject;
	private String course;
	private float price;
	private String address;
	@Resource
	private CourseDao courseDao;
	@Resource
	private CourseService courseService;
	private String start;
	private String end;
	private String keyword;
	private int cid = -1;

	/**
	 * (域的意义,目的,功能)
	 */

	/**
	 * 
	 * 发起课程
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 */
	@Action(value = "start", results = { @Result(type = "json") })
	public void startCourse() {
		this.setResp(ServletActionContext.getResponse());
		if (checkParameter() == true) {
			int tp = getType();
			if (tp == 1) {
				//发起名师课程
				Course course = new Course();
				course.setUserid(getUid());
				course.setAddress(getAddress());
				course.setName(getSubject());
				course.setPrice(getPrice());
				course.setType(1);
				course.setState(1);
				try {
					courseDao.save(course);
				} catch (DaoException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				}
			} else {
				//发起私教课程
				Course course = new Course();
				course.setAddress(getAddress());
				course.setUserid(getUid());
				course.setName(getSubject());
				course.setPrice(getPrice());
				course.setType(2);
				course.setState(1);

				try {
					courseDao.save(course);
				} catch (DaoException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				}
			}
		} else {
			//参数错误
			this.setInfo("参数错误");
			this.setState(201);
			this.sendNull();
		}
	}

	/**
	 * 
	 *课程搜索
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 */
	@Action(value = "search", results = { @Result(type = "json") })
	public void search() {
		String wd = getKeyword();
		this.setResp(ServletActionContext.getResponse());
		if (wd != null) {
			try {
				List<Course> result = courseService.search(wd);
				this.sendResponse(this.toJson(result));
			} catch (ParseException e) {
				ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
				e.printStackTrace();
			} catch (Exception e) {
				ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
				e.printStackTrace();
			}
		} else {
			ActionExceptionHandle.handle(new NullPointException("传入的参数错误"), ServletActionContext.getResponse());
		}
	}

	/**
	 * 
	 * 
	 * 课程详情
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 */
	@Action(value = "detail", results = { @Result(type = "json") })
	public void detail() {
		this.setResp(ServletActionContext.getResponse());
		if (getCid() != -1) {
			try {
				Course course = courseService.getById(cid);
				String json = this.toJson(course);
				try {
					this.sendResponse(json);
				} catch (ActionException e) {
					ActionExceptionHandle.handle(new NullPointException("传入参数异常"), ServletActionContext.getResponse());
					e.printStackTrace();
				} catch (IOException e) {
					ActionExceptionHandle.handle(new NullPointException("传入参数异常"), ServletActionContext.getResponse());
					e.printStackTrace();
				}
			} catch (DaoException e) {
				ActionExceptionHandle.handle(new NullPointException("传入参数异常"), ServletActionContext.getResponse());
				e.printStackTrace();
			}
		} else {
			ActionExceptionHandle.handle(new NullPointException("传入参数异常"), ServletActionContext.getResponse());
		}
	}

	/**
	 *报名课程 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 */
	@Action(value = "join", results = { @Result(type = "json") })
	public void join() {
		this.setResp(ServletActionContext.getResponse());
		if (uid != -1 && cid != -1) {
			courseService.joinCourse(uid, cid);
			this.sendSuccess();
		} else {
			ActionExceptionHandle.handle(new NullPointException("传入参数异常"), ServletActionContext.getResponse());
		}
	}
	
	/**
	 *课程发起者结束课程 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 */
	@Action(value = "end", results = { @Result(type = "json") })
	public void end(){
		this.setResp(ServletActionContext.getResponse());
		if(getUid() != -1){
			courseService.end(uid);
			this.sendSuccess();
		}else{
			ActionExceptionHandle.handle(new NullPointException("传入参数异常"), ServletActionContext.getResponse());
		}
	}

	/**
	 * 
	 * 参数检查
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @return
	 */
	public boolean checkParameter() {
		if (getUid() == -1 || getType() == -1 || getSubject() == null || getCourse() == null || getPrice() == -1
				|| getAddress() == null || getStart() == null || getEnd() == null) {
			return false;
		} else {
			return true;
		}
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public CourseDao getCourseDao() {
		return courseDao;
	}

	public void setCourseDao(CourseDao courseDao) {
		this.courseDao = courseDao;
	}

	public String getStart() {
		return start;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getEnd() {
		return end;
	}

	public void setEnd(String end) {
		this.end = end;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

}
