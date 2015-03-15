/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.utils;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.ax.exception.DaoException;

/**
 * 视图建立工具
 * 主要功能是建立起用户的视图
 * 这样做的目的是把用户表一分为4
 * 用户表拆分为：普通用户表V_PT_USERS
 *              私教视图V_SJ_USERS
 *              名师视图	V_MS_USERS
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */
@Repository
@Transactional
public class CreateView {
	@Resource
	private SessionFactory sessionFactory;
	private Session session;
	
	/**
	 * 
	 * 创建普通用户视图
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	public void createPtUserView() throws DaoException{
		getSession();
		String hql = "CREATE VIEW V_PT_USERS AS SELECT * FROM T_USERS WHERE USERS_TYPE=1";
		session.createSQLQuery(hql).executeUpdate();
		
	}
	
	/**
	 * 创建私教视图
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	public void createSjUsers() throws DaoException{
		getSession();
		String hql = "CREATE VIEW V_SJ_USERS AS SELECT * FROM T_USERS WHERE USERS_TYPE=2";
		session.createSQLQuery(hql).executeUpdate();
	}
	/**
	 * 创建名师视图
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	public void createMsUsers() throws DaoException{
		getSession();
		String hql = "CREATE VIEW V_SJ_USERS AS SELECT * FROM T_USERS WHERE USERS_TYPE=3";
		session.createSQLQuery(hql).executeUpdate();
	}
	
	/**
	 * 批量创建视图
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	public void create() throws DaoException{
		createPtUserView();
		createSjUsers();
		createMsUsers();
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 获取数据库session
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @throws DaoException
	 */
	public void getSession() throws DaoException{
		session = sessionFactory.getCurrentSession();
		if(session == null){
			session = sessionFactory.openSession();
		}
		if(session == null){
			throw new DaoException("没有合适的Session");
		}
	}
}
