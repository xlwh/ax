/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.dao.comment.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ax.bean.Commonent;
import com.ax.bean.Page;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.dao.comment.CommentDao;
import com.ax.exception.DaoException;

/**
 * 评论相关的数据库访问接口的实现类
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
@Repository
public class CommentDaoImpl extends DaoSupport<Commonent> implements CommentDao {

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 通过用户ID获取记录
	 * @see com.ax.dao.comment.CommentDao#findByUid(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @param uid    用户id
	 * @return       检索到的数据库记录
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Commonent> findByUid(int uid) throws DaoException {
		getSession();
		String hql = "from Commonent where teacherid=:uid";
		if (session != null) {
			Query query = session.createQuery(hql);
			query.setParameter("uid", uid);
			return query.list();
		} else {
			return null;
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 分页加载所有的评论数据
	 * @see com.ax.dao.comment.CommentDao#findByUidAndPage(int, com.ax.bean.Page)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @param uid    用户id
	 * @param page   分页对象
	 * @return       分页搜索到的内容
	 * @throws DaoException   数据库异常
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<Commonent> findByUidAndPage(int uid, Page<Commonent> page) throws DaoException {
		getSession();
		if (session != null) {
			String hql = "from Commonent where userid=:userid";
			Query query = session.createQuery(hql);
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getMax());
			page.setRows(query.list());
			return page;
		} else {
			return null; //数据库查询错误！
		}

	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.comment.CommentDao#findByUidAndPage(int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月3日
	 * @param uid
	 * @param page
	 * @return
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Commonent> findByUidAndPage(int uid, int page) throws DaoException {
		List<Commonent> list = null;
		long count = this.getSize();
		if(page<(count/5-1)){
		
		int start = 0;
	    int max = 0; 
		if(page == 1){
        	 start = 0;
        	 max = 5;
         }else{
        	 start = page*5-5;
        	 max = 5;
         }
        
		System.out.println(start+","+max);
	    getSession();
	    if(session != null){
	    	Query query = session.createQuery("from Commonent");
	    	query.setFirstResult(start);
	    	query.setMaxResults(max);
	    	list = query.list();
	    }else{
	    	throw new DaoException("没有找到合适的Session");
	    }
		}
		return list;
	}

}
