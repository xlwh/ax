/*
 * Title:        爱学圈服务器 2015年1月27日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月27日
 */
package com.ax.dao.activity.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.lucene.analysis.standard.StandardAnalyzer;
import org.apache.lucene.queryparser.classic.MultiFieldQueryParser;
import org.apache.lucene.queryparser.classic.ParseException;
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

import com.ax.bean.Activity;
import com.ax.bean.Apply;
import com.ax.bean.Commonent;
import com.ax.dao.activity.ActivityDao;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.exception.DaoException;
import com.ax.exception.DaoInsertException;
import com.ax.exception.DaoQueryException;

/**
 *活动相关的数据库访问接口实现类
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月27日
 */
@Repository
@Transactional
public class ActivityDaoImpl extends DaoSupport<Activity> implements ActivityDao{

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.activity.ActivityDao#searchActivity(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param keyword  搜索的关键词
	 * @return        搜索到的结果
	 * @throws ParseException 
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Activity> searchActivity(String keyword) throws ParseException, DaoException {
		//createIndexByHibernateSearch();
		getSession();
		//设置最多可以搜索20条信息
		BooleanQuery.setMaxClauseCount(20);
		//构建多条件查询
		BooleanQuery booleanQuery = new BooleanQuery();
		//使用标词法分析器
		StandardAnalyzer analyzer = new StandardAnalyzer();
		// 基本关键词搜索
		String[] searchFields = new String[] { "name" };//成员变量
		MultiFieldQueryParser queryParser = new MultiFieldQueryParser(searchFields, analyzer);
		queryParser.setDefaultOperator(QueryParser.Operator.AND);
		Query query = queryParser.parse(keyword);
		booleanQuery.add(query, Occur.SHOULD);
		QueryParser parse = new QueryParser("isDelete", analyzer);
		Query query1 = parse.parse("0");
		parse.setDefaultOperator(QueryParser.Operator.OR);
		booleanQuery.add(query1, Occur.SHOULD);
		FullTextSession fullSession = Search.getFullTextSession(session);
		FullTextQuery fullQuery = fullSession.createFullTextQuery(booleanQuery, Activity.class);
		int size = fullQuery.getResultSize();
		System.out.println("size:" + size);
		return fullQuery.list();
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.activity.ActivityDao#findById(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param id
	 * @return
	 * @throws DaoException 
	 * @throws DaoQueryException 
	 */
	@Override
	public Activity findById(int id) throws DaoException, DaoQueryException {
		getSession();
		Activity activity = null;
		if(session !=null){
			activity = (Activity)session.get(Activity.class, id);
		}else{
			throw new DaoQueryException("Session为空");
		}
		return activity;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.activity.ActivityDao#joinActivity()
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @throws DaoInsertException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 */
	@Override
	public void joinActivity(int uid,int aid) throws DaoException, DaoInsertException {
		getSession();
		if(session !=null){
			Activity activity = (Activity)session.load(Activity.class, aid);
			if(activity != null){
				Apply apply = new Apply();
				apply.setCourseidOrActivityid(aid);
				if(activity.getCharge()>0){
					apply.setIsfree(false);
				}else{
					apply.setIsfree(true);
				}
				apply.setState(0);
				apply.setType(3);
				apply.setUserid(uid);
				session.save(apply);
			}else{
				throw new DaoInsertException("对应的活动并不存在，出现异常");
			}
		}else{
			throw new DaoInsertException("Session为空");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 对课程支付相关费用....
	 * @see com.ax.dao.activity.ActivityDao#apply(int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param uid
	 * @param aid
	 */
	@Override
	public void apply(int uid, int aid) {
		
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.activity.ActivityDao#endActivity(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param activityId
	 */
	@Override
	public void endActivity(int activityId) {
		
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.activity.ActivityDao#cancle(int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param aid
	 * @param uid
	 */
	@Override
	public void cancle(int aid, int uid) {
		
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.activity.ActivityDao#commonent(int, int, int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param uid
	 * @param aid
	 * @param level
	 * @param desc
	 * @throws DaoException 
	 * @throws DaoInsertException 
	 */
	@Override
	public void commonent(int uid, int aid, int level, String desc) throws DaoException, DaoInsertException {
		getSession();
		if(session != null){
			Commonent c = new Commonent();
			c.setDesc(desc);
			c.setLever(level);
			c.setState(0);
			c.setType(3);
			c.setUserid(uid);
			session.save(c);
		}else{
			throw new DaoInsertException("Session为空");
		}
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 获取数据库中的Session
	 * @see com.ax.dao.activity.ActivityDao#getSession()
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 */
	@Override
	public void getSession() throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null){
			session = sessionFactory.openSession();
		}
		if(session == null){
			throw new DaoException("没有找到合适的Session");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 建立数据库搜索索引
	 * @see com.ax.dao.activity.ActivityDao#createIndexByHibernateSearch()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @throws Exception
	 */
	@Override
	public void createIndexByHibernateSearch() throws Exception {
		getSession();
		long startTime = new Date().getTime();
		int BATCH_SIZE = 1000;
		FullTextSession s = Search.getFullTextSession(session);
		s.setFlushMode(FlushMode.MANUAL);
		s.setCacheMode(CacheMode.IGNORE);
		ScrollableResults results = s.createQuery("from Activity").setFetchSize(BATCH_SIZE).scroll(ScrollMode.FORWARD_ONLY);
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
		System.out.println("建立Activity索引 ， 这花费了" + (endTime - startTime) + " 毫秒来把文档增加到索引里面去!");
	
	 }

}
