/*
 * Title:        爱学圈服务器 2015年1月26日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月26日
 */
package com.ax.dao.course;

import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import com.ax.bean.Course;
import com.ax.bean.Page;
import com.ax.dao.base.DAO;

/**
 * (一句话功能简述)
 * 课程相关数据库访问接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月26日
 */
public interface CourseDao extends DAO<Course>{
	/**
	 * 
	 * 搜索课程
	 *输入关键词，通过关键词从数据库中检索相关的课程
	 *默认只展示相关度最大的十条记录
	 *使用Apache Luence来进行实现相关的功能
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param keyword  搜索关键词语
	 * @return         搜索到的相关课程
	 * @throws Exception 
	 */
	public List<Course> searchCourse(String keyword)throws ParseException, Exception;
	/**
	 * 
	 * 使用主键来获取课程信息
	 * 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param id
	 * @return
	 */
	public Course getInfoById(int id);
	/**
	 * 
	 * 报名课程
	 * 在订单表里面创建一条订单记录
	 * 完成课程的报名操作
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param userid
	 */
	public void joinCourse(int courseid,int userid);
	/**
	 * 
	 * 课程发起者结束课程
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param id
	 */
	public void endCourse(int id);
	/**
	 * 
	 * 评价课程
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param id     课程主键
	 * @param uid    用户主键
	 * @param desc   评论内容
	 */
	public void comment(int id,int uid,int level,String desc);
	/**
	 * 
	 * 附近课程搜索
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param longititude    经度
	 * @param latitude       维度
	 * @return              搜索到的课程
	 */
	public Page<Course> nearbyCourse(Page<Course> page,long longititude,long latitude);
	/**
	 * 
	 * (一句话功能简述)
	 * 建立索引，同步数据库中的数据，进行索引
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @throws Exception
	 */
	public void createIndexByHibernateSearch() throws Exception;
	/**
	 * 
	 * (一句话功能简述)
	 * 查找某个老师教的课程信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @param id
	 * @return
	 */
	public List<Course> findByUid(int id);
}
