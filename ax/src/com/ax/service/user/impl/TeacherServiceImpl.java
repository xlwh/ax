/*
 * Title:        爱学圈服务器 2015年1月29日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月29日
 */
package com.ax.service.user.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.app.action.user.TeacherDetailResult;
import com.ax.bean.Course;
import com.ax.bean.Identification;
import com.ax.bean.Rank;
import com.ax.bean.Teacher;
import com.ax.bean.TeacherRecommendInfo;
import com.ax.dao.course.CourseDao;
import com.ax.dao.user.TeacherDao;
import com.ax.dao.user.TeacherRecommendInfoDao;
import com.ax.exception.DaoException;
import com.ax.service.user.TeacherService;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月29日
 */
@Service
public class TeacherServiceImpl implements TeacherService {
	/**课程**/
	@Resource
	private CourseDao courseDao;
	/**老师信息**/
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private TeacherRecommendInfoDao teacherRecommendInfoDao;

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.TeacherService#getDetailById()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @return
	 * @throws DaoException 
	 */
	@Override
	public TeacherDetailResult getDetailById(int id) throws DaoException {
		TeacherRecommendInfo tc = teacherRecommendInfoDao.findById(id);
		System.out.println("获取到推荐表的数据");
		if (tc != null) {
			Teacher teacher = teacherDao.findById(tc.getUserID());
			System.out.println("获取到老师表的数据");
			Course course = courseDao.findById(tc.getCourseid());
			return buildResult(id, teacher, course);
		} else {
			return null;
		}

	}

	/**
	 * 构建返回结果
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月30日
	 * @param id
	 * @param teacher
	 * @param course
	 * @return
	 */
	private TeacherDetailResult buildResult(int id, Teacher teacher, Course course) {
		TeacherDetailResult teacherDetailResult = null;
		if (teacher != null && course != null) {
			teacherDetailResult = new TeacherDetailResult();
			teacherDetailResult.setAddress(teacher.getAddress());
			teacher.setAge(teacher.getAge());
			teacherDetailResult.setCourse(course);
			teacherDetailResult.setDesc(teacher.getDesc());
			teacherDetailResult.setEdu(teacher.getEdu());
			teacherDetailResult.setExp(teacher.getExp());
			teacherDetailResult.setGender(teacher.getGender());
			List<Identification> idfs = teacherDao.getIdfcByUid(id);
			List<String> ids = new ArrayList<String>();
			for (Identification idf : idfs) {
				ids.add(idf.getName());
			}
			teacherDetailResult.setIdfc(ids);
			teacherDetailResult.setName(teacher.getName());
			teacherDetailResult.setPic(teacher.getPic());
			teacherDetailResult.setStar(teacher.getStar());
			teacherDetailResult.setType(teacher.getType());
			List<String> ran = new ArrayList<String>();
			List<Rank> ranks = teacher.getRank();
			for (Rank r : ranks) {
				ran.add(r.getName());
			}
			teacherDetailResult.setRank(ran);

		} else if (teacher != null && course == null) {
			teacherDetailResult = new TeacherDetailResult();
			teacherDetailResult.setAddress(teacher.getAddress());
			teacher.setAge(teacher.getAge());
			//teacherDetailResult.setCourse(course);
			teacherDetailResult.setDesc(teacher.getDesc());
			teacherDetailResult.setEdu(teacher.getEdu());
			teacherDetailResult.setExp(teacher.getExp());
			teacherDetailResult.setGender(teacher.getGender());
			List<Identification> idfs = teacherDao.getIdfcByUid(id);
			List<String> ids = new ArrayList<String>();
			for (Identification idf : idfs) {
				ids.add(idf.getName());
			}
			teacherDetailResult.setIdfc(ids);
			teacherDetailResult.setName(teacher.getName());
			teacherDetailResult.setPic(teacher.getPic());
			teacherDetailResult.setStar(teacher.getStar());
			teacherDetailResult.setType(teacher.getType());
		} else {
			teacherDetailResult = null; //不返回任何值 
		}
		return teacherDetailResult;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.TeacherService#search(java.lang.String, java.lang.String, int, int, int, long, long)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param keyword
	 * @param subject
	 * @param r
	 * @param auto
	 * @param type
	 * @param lng
	 * @param lat
	 * @return
	 */
	@Override
	public List<Teacher> search(String keyword, String subject, int r, int auto, int type, long lng, long lat) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 获取所有老师
	 * @see com.ax.service.user.TeacherService#getAll()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @return
	 * @throws DaoException 
	 */
	@Override
	public List<Teacher> getAll() throws DaoException {
		return teacherDao.findAll();
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.TeacherService#getAll(com.ax.bean.Page)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param page
	 * @return
	 */
	@Override
	public List<Teacher> getAll(int page,int pageSize) {
		return teacherDao.getAllByPage(page, pageSize);
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.TeacherService#getCount()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @return
	 */
	@Override
	public long getCount() {
		return teacherDao.getSize();
	}

}
