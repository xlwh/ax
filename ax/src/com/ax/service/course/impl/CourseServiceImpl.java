/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.service.course.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.stereotype.Service;

import com.ax.bean.Course;
import com.ax.bean.CourseName;
import com.ax.bean.Subject;
import com.ax.dao.course.CourseDao;
import com.ax.dao.course.CourseNameDao;
import com.ax.dao.course.SubjectDao;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;
import com.ax.service.course.CourseService;

/**
 * 课程相关的业务逻辑接口的实现类
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
@Service
public class CourseServiceImpl implements CourseService {
	@Resource
	private SubjectDao subjectDao;
	@Resource
	private CourseNameDao courseNameDao;
	@Resource
	private CourseDao courseDao;

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 发起名师课程
	 * @see com.ax.service.course.CourseService#startMsCourse(java.lang.String, java.lang.String, java.lang.String, int, java.lang.String, int, float)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param schoolid  上课地点（学校）
	 * @param start      开始时间   
	 * @param end        结束时间
	 * @param uid        课程发起者
	 * @param courseName   课程名字
	 * @param type        课程类型2
	 * @param price        课程价格
	 * @throws NullPointException  空指针异常
	 * @throws DaoException       数据库访问异常
	 */
	@Override
	public void startMsCourse(int schoolid, String start, String end, int uid, String courseName,float price) throws NullPointException, DaoException {
		if (checkTimeFormat(start) == true && checkTimeFormat(end) == true) {
			//发起私教课程
			Date st = getDateFromString(start);
			Date ed = getDateFromString(end);
			Course course = new Course();
			if (st != null) {
				course.setStart(st);
			}
			if (ed != null) {
				course.setEnd(ed);
			}
			course.setSchoolid(schoolid);
			course.setName(courseName);
			course.setType(2); //type=2是名师课程
			course.setUserid(uid);
			course.setPrice(price);
			courseDao.save(course);
		} else {
			throw new NullPointException("传入的时间的格式不正确！");
		}
		
	}
	/**
	 * 发起课程
	 * 发起的课程有两类
	 * （1）发起私教课程
	 *      address:
	 *      start
	 *      end
	 *      uid
	 *      subject
	 *      coursename
	 *      type....
	 * （2）发起名师课程
	 * @see com.ax.service.course.CourseService#startCourse()
	 * @author       张洪斌  1079039435@qq.com
	 * @throws NullPointException 
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 */
	@Override
	public void startSjCourse(String address, String start, String end, int uid, String courseName, int type)
			throws NullPointException, DaoException {
		if (checkTimeFormat(start) == true && checkTimeFormat(end) == true) {
			//发起私教课程
			Date st = getDateFromString(start);
			Date ed = getDateFromString(end);
			Course course = new Course();
			if (st != null) {
				course.setStart(st);
			}
			if (ed != null) {
				course.setEnd(ed);
			}
			course.setAddress(address);
			course.setName(courseName);
			course.setType(1); //type=1是私教课程
			course.setUserid(uid);
			courseDao.save(course);
		} else {
			throw new NullPointException("传入的时间的格式不正确！");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 获取科目列表
	 * @see com.ax.service.course.CourseService#getSubjects()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @return       所有的课程列表
	 * @throws NullPointException   空指针异常
	 * @throws DaoException         数据库访问异常
	 */
	@Override
	public List<Subject> getSubjects() throws NullPointException, DaoException {
		List<Subject> subjects = null;
		if (subjectDao != null) {
			subjects = subjectDao.findAll();
		} else {
			throw new NullPointException("The object SubjectDao can not be null,please check!");
		}
		return subjects;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 获取科目下的课程列表
	 * @see com.ax.service.course.CourseService#getCoursesBySubjectId(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param id     科目ID
	 * @return       科目下的课程
	 * @throws NullPointException 
	 * @throws DaoException 
	 */
	@Override
	public List<CourseName> getCoursesBySubjectId(int id) throws NullPointException, DaoException {
		List<CourseName> courseNames = null;
		if (courseNameDao != null && id > 0) {
			Object parame[] = { id };
			courseNames = courseNameDao.findByHQL("from CourseName where subjectid=?", parame);
		} else {
			throw new NullPointException("The object CourseDao can not be null or the id can not <0!");
		}
		return courseNames;
	}

	/**
	 * 
	 * 检查传入参数中的时间的格式是不是正确的
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param time
	 * @return
	 */
	private boolean checkTimeFormat(String time) {
		boolean result = false;
		int i = 0, j = 0, k = 0, l = 0, m = 0;
		if (time.length() == 10) {
			char s[] = time.toCharArray();
			for (char c : s) {
				m++;
				if (c == '-') {
					l++;
				}
				switch (l) {
				case 1: {
					i = m;
				}
					;
					break;
				case 2: {
					j = m;
				}
					;
					break;
				case 3: {
					k = m;
				}
					;
					break;
				}
			}

			if (i == 7 && j == 10 && k == 0) {
				result = true;
			}

		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 
	 * (一句话功能简述)
	 * 把字符串转换为日期
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param time
	 * @return
	 */
	private Date getDateFromString(String time) {
		if (time != null && checkTimeFormat(time) == true) {
			Calendar calendar = Calendar.getInstance();
			int year = Integer.parseInt(time.substring(0, 4));
			int mounth = Integer.parseInt(time.substring(5, 7));
			int day = Integer.parseInt(time.substring(8, 10));
			calendar.set(year, mounth, day);
			return calendar.getTime();
		} else {
			return null;
		}

	}
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.course.CourseService#search(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param keyword
	 * @return
	 * @throws Exception 
	 * @throws ParseException 
	 */
	@Override
	public List<Course> search(String keyword) throws ParseException, Exception {
		return courseDao.searchCourse(keyword);
	}
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.course.CourseService#getById(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param id
	 * @return
	 * @throws DaoException 
	 */
	@Override
	public Course getById(int id) throws DaoException {
		return courseDao.findById(id);
	}
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.course.CourseService#joinCourse(int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param uid
	 * @param cid
	 */
	@Override
	public void joinCourse(int uid, int cid) {
		courseDao.joinCourse(cid, uid);
		
	}
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.course.CourseService#end(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param uid
	 */
	@Override
	public void end(int uid) {
	   courseDao.endCourse(uid);
		
	}

	

}
