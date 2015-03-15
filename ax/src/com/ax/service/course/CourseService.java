/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.service.course;

import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import com.ax.bean.Course;
import com.ax.bean.CourseName;
import com.ax.bean.Subject;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;

/**
 * (一句话功能简述)
 * 课程相关的业务逻辑
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public interface CourseService {
	/**
	 * 
	 *发起课程
	 * 
	 * @author       张洪斌  1079039435@qq.com
	 * @throws NullPointException 
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 */
	public void startSjCourse(String address, String start, String end, int uid, String courseName, int type)
			throws NullPointException, DaoException;
    
	/**
	 * 
	 * 发起名师课程
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param address
	 * @param start
	 * @param end
	 * @param uid
	 * @param courseName
	 * @param type
	 * @throws NullPointException
	 * @throws DaoException
	 */
	public void startMsCourse(int schoolid, String start, String end, int uid, String courseName,float price)
			throws NullPointException, DaoException;
	/**
	 * 
	 * 获取所有的科目列表
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @return       所有的科目列表
	 * @throws NullPointException 
	 * @throws DaoException 
	 */
	public List<Subject> getSubjects() throws NullPointException, DaoException;

	/**
	 * 
	 * 通过科目获取科目所有的课程
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param id
	 * @return
	 * @throws NullPointException 
	 * @throws DaoException 
	 */
	public List<CourseName> getCoursesBySubjectId(int id) throws NullPointException, DaoException;
	/**
	 * 
	 * 搜索课程
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param keyword    搜索关键词语
	 * @return           搜索到的课程
	 * @throws Exception 
	 * @throws ParseException 
	 */
	public List<Course> search(String keyword) throws ParseException, Exception;
	/**
	 * 
	 * 通过id获取课程详情
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param id
	 * @return
	 * @throws DaoException 
	 */
	public Course getById(int id) throws DaoException;
	/**
	 * 
	 * 课程报名
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param uid    报名者
	 * @param cid    课程id
	 */
	public void joinCourse(int uid,int cid);
	/**
	 * 
	 * (一句话功能简述)
	 * 课程发起者取消课程
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param uid    课程发起者
	 */
	public void end(int uid);
}
