/*
 * Title:        爱学圈服务器 2015年1月26日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月26日
 */
package com.ax.dao.course.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.BooleanClause.Occur;
import org.apache.lucene.search.BooleanQuery;
import org.apache.lucene.search.Query;
import org.hibernate.CacheMode;
import org.hibernate.FlushMode;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.hibernate.search.FullTextQuery;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.springframework.stereotype.Repository;

import com.ax.bean.Apply;
import com.ax.bean.Commonent;
import com.ax.bean.Course;
import com.ax.bean.Page;
import com.ax.bean.Users;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.dao.course.CourseDao;
import com.ax.exception.DaoException;
import com.ax.exception.ExceptionHandle;

/**
 * (一句话功能简述)
 * 课程相关数据库访问接口实现类
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月26日
 */
@Transactional
@Repository
public class CourseDaoImpl extends DaoSupport<Course> implements CourseDao{

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.course.CourseDao#searchCourse(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param keyword
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> searchCourse(String keyword) throws Exception {
		//createIndexByHibernateSearch();
		getSession();
		//设置最多可以搜索20条信息
		BooleanQuery.setMaxClauseCount(20);
		//构建多条件查询
		BooleanQuery booleanQuery = new BooleanQuery();  
		//使用标词法分析器
		StandardAnalyzer analyzer=new StandardAnalyzer();
		// 基本关键词搜索
		String[] searchFields = new String[] { "name" };//成员变量
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(searchFields,analyzer);
		queryParser.setDefaultOperator(QueryParser.Operator.AND);
		Query query = queryParser.parse(keyword);
		booleanQuery.add(query,Occur.SHOULD);
		QueryParser parse=new QueryParser("isDelete",analyzer);
		Query query1=parse.parse("0");
		parse.setDefaultOperator(QueryParser.Operator.OR);
		booleanQuery.add(query1,Occur.SHOULD);
        FullTextSession fullSession = Search.getFullTextSession(session);
		FullTextQuery fullQuery = fullSession.createFullTextQuery(booleanQuery,Course.class);
		int size = fullQuery.getResultSize();
		System.out.println("size:" + size);
		return fullQuery.list();
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.course.CourseDao#getInfoById(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param id
	 * @return
	 */
	@Override
	public Course getInfoById(int id) {
		Course course = null;
		getSession();
		if(session != null){
			course = (Course)session.get(Course.class, id);
		}
		return course;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 报名参加课程
	 * 自动根据用户信息，生成报名表
	 * @see com.ax.dao.course.CourseDao#joinCourse(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param userid
	 */
	@Override
	public void joinCourse(int courseid,int userid) {
		getSession();
		if(session != null){
			Users user = (Users)session.load(Users.class, userid);
			Course course = (Course)session.load(Course.class, courseid);
			if(user != null && course !=null){
				//存在这个用户
				Apply apply = new Apply();
				//apply.setApplyTime(new Date());
				if(course.getPrice() == 0){
					apply.setIsfree(true);
				}else{
					apply.setIsfree(false);
				}
				apply.setState(0);   //刚报名....
				apply.setType(1);  //1：课程报名  2：活动报名
				apply.setUserid(userid);
				apply.setCourseidOrActivityid(courseid);
				session.save(apply);    //生成订单
			}
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 课程发起者自行结束开设课程
	 * @see com.ax.dao.course.CourseDao#endCourse(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param id
	 */
	@Override
	public void endCourse(int id) {
		getSession();
		if(session != null){
			Course course = (Course)session.load(Course.class, id);
			if(course != null){
				course.setState(0);
			}
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 对课程进行评论
	 * @see com.ax.dao.course.CourseDao#comment(int, int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param id     课程编号
	 * @param uid   主键
	 * @param desc   课程描述
	 */
	@Override
	public void comment(int id, int uid, int level,String desc) {
		getSession();
		if(session != null ){
			Commonent c = new Commonent();
			c.setDesc(desc);
			c.setLever(level);
			c.setUserid(uid);
			c.setState(0);  //0：等待审核状态  1：审核通过 -1:内容审核不通过
		    c.setType(1);   
		    session.save(c);
		}
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.course.CourseDao#nearbyCourse(com.ax.bean.Page, long, long)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @param page
	 * @param longititude
	 * @param latitude
	 * @return
	 */
	@Override
	public Page<Course> nearbyCourse(Page<Course> page, long longititude, long latitude) {
		getSession();
		//计算平方根
		//from Location location where type=4 and SQRT((location.longitude-"+longititude+")*(location.longitude-"+longititude+")*-(location.longitude-"+longititude+")*(location.longitude-"+longititude+")) 
		String hql = "from Location location where type=4 and SQRT((location.longitude-"+longititude+")*(location.longitude-"+longititude+")-(location.latitude-"+latitude+")*(location.latitude-"+latitude+"))>2000";
		System.out.println(hql);
		return null;
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 创建全文检索索引
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 * @throws Exception
	 */
	@Override
	public void createIndexByHibernateSearch() throws Exception{
		getSession();
		long startTime = new Date().getTime();
		int BATCH_SIZE = 1000;
		FullTextSession s = Search.getFullTextSession(session);
		s.setFlushMode(FlushMode.MANUAL);
		s.setCacheMode(CacheMode.IGNORE);
		ScrollableResults results = s.createQuery("from Course").setFetchSize(BATCH_SIZE).scroll(ScrollMode.FORWARD_ONLY);
		int index = 0;
		while (results.next()) {
			index++;
			s.index(results.get(0));
			if (index % BATCH_SIZE == 0) {
				s.clear();
			}
		}
		s.clear();
		long endTime = new Date().getTime();
		System.out.println("建立Product索引 ， 这花费了" + (endTime - startTime) + " 毫秒来把文档增加到索引里面去!");
		// tr.commit();

		 }
	
	/**
	 * 
	 *
	 *获取数据库操作的Session 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月26日
	 */
	
	public void getSession(){
		session = sessionFactory.getCurrentSession();
		if(session == null){
			session = sessionFactory.openSession();
		}
		if(session == null){
			DaoException e = new DaoException("没有合适的Session");
			ExceptionHandle.throwException(e,"com.ax.course.dao.impl.CourseDaoImpl#getSession()" );
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.course.CourseDao#findByUid(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @param id
	 * @return
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public List<Course> findByUid(int id) {
		getSession();
		String hql = "from Course where id=?";
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter(0, id);
		//System.out.println("步骤2正确执行");
		return query.list();
	}
	
	
}
