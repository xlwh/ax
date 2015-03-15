/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.dao.user.impl;

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
import org.hibernate.search.SearchFactory;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import com.ax.bean.Identification;
import com.ax.bean.Page;
import com.ax.bean.Teacher;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.dao.user.TeacherDao;
import com.ax.exception.DaoException;
import com.ax.exception.ExceptionHandle;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */
@Transactional
@Repository
public class TeacherDaoImpl extends DaoSupport<Teacher> implements TeacherDao {

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.TeacherDao#search(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param name
	 * @return
	 * @throws ParseException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<Teacher> search(Page<Teacher> page,String name) throws ParseException {
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
		Query query = queryParser.parse(name);
		booleanQuery.add(query, Occur.SHOULD);
		QueryParser parse = new QueryParser("isDelete", analyzer);
		Query query1 = parse.parse("0");
		parse.setDefaultOperator(QueryParser.Operator.OR);
		booleanQuery.add(query1, Occur.SHOULD);
		FullTextSession fullSession = Search.getFullTextSession(session);
		FullTextQuery fullQuery = fullSession.createFullTextQuery(booleanQuery, Teacher.class);
		int size = fullQuery.getResultSize();
		System.out.println("size:" + size);
		page.setRows(fullQuery.list());
		return page;
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 创建索引
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @throws Exception
	 */
	public void createIndexByHibernateSearch() throws Exception {
		getSession();
		long startTime = new Date().getTime();
		int BATCH_SIZE = 1000;
		FullTextSession s = Search.getFullTextSession(session);
		s.setFlushMode(FlushMode.MANUAL);
		s.setCacheMode(CacheMode.IGNORE);
		ScrollableResults results = s.createQuery("from Teacher").setFetchSize(BATCH_SIZE)
				.scroll(ScrollMode.FORWARD_ONLY);
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
		System.out.println("建立Teacher索引 ， 这花费了" + (endTime - startTime) + " 毫秒来把文档增加到索引里面去!");
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

	public void getSession() {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoException e = new DaoException("没有合适的Session");
			ExceptionHandle.throwException(e, "com.ax.course.dao.impl.CourseDaoImpl#getSession()");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.TeacherDao#getIdfcByUid(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<Identification> getIdfcByUid(int id) {
		getSession();
		String hql = "from Identification where userid=?";
		org.hibernate.Query query = session.createQuery(hql);
		query.setParameter(0, id);
		System.out.println(query.list().size());
		return query.list();
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.TeacherDao#search(com.ax.bean.Page, java.lang.String, java.lang.String, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param page
	 * @param name
	 * @param major
	 * @param type
	 * @return
	 * @throws InterruptedException 
	 */
	@Override
	public Page<Teacher> search(Page<Teacher> page, String name, String major, int type) throws InterruptedException {
		getSession();
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		fullTextSession.createIndexer().startAndWait();
		SearchFactory sfc = fullTextSession.getSearchFactory();
		QueryBuilder qb = sfc.buildQueryBuilder().forEntity( Teacher.class ).get();
		@SuppressWarnings("unused")
		Query query = null;
		
		if(major == null){
			//只按照名字和类型来检索
			query = qb.keyword().onField("name").andField("type").boostedTo(5).matching("").createQuery();
		}
		return null;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.TeacherDao#getAllByPage(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param page
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Teacher> getAllByPage(int page,int pageSize) {
	   // long count = this.getSize();
	    List<Teacher> result = null;
	    int start = 0;
	    int max = 0;
	    if(page == 1){
	    	//第一页
	    	start = 0;
	    	max = pageSize;
	    }else{
	    	start = page*pageSize - pageSize;
	    	max = page*pageSize + pageSize;
	    }
	    getSession();
		if(session != null){
			org.hibernate.Query query = session.createQuery("from Teacher");
			query.setFirstResult(start);
			query.setMaxResults(max);
			result = query.list();
		}
	    return result;
	}
	
	

}
