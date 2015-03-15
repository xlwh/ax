/*
 * Title:        爱学圈服务器 2015年1月27日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月27日
 */
package com.ax.dao.activity;

import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import com.ax.bean.Activity;
import com.ax.dao.base.DAO;
import com.ax.exception.DaoException;
import com.ax.exception.DaoInsertException;
import com.ax.exception.DaoQueryException;

/**
 * 
 * 活动相关的数据库访问接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月27日
 */
public interface ActivityDao extends DAO<Activity>{
	/**
	 * 
	 * 
	 * 搜索活动
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param keyword  搜索关键词语
	 * @return         搜索到的相关的活动
	 */
	public List<Activity> searchActivity(String keyword) throws ParseException, DaoException ;
	/**
	 * 根据活动的主键id来获取到活动的详情信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param id     活动id
	 * @return       活动信息
	 */
	public Activity findById(int id)throws DaoException,DaoQueryException;
	/**
	 * 参加活动
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @throws DaoInsertException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 */
	public void joinActivity(int uid,int aid) throws DaoException, DaoInsertException;
	/**
	 * 支付活动费用
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param uid   支付者
	 * @param aid   支付的目标活动
	 */
	public void apply(int uid,int aid);
	/**
	 * 结束课程
     * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param activityId 
	 */
	public void endActivity(int activityId);
	/**
	 * 取消活动报名
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param aid   活动id
	 * @param uid   用户id 
	 */
	public void cancle(int aid,int uid);
	/**
	 * 发表对活动的评论
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param uid    发表者
	 * @param aid    活动id
	 * @param level  评价的星级
	 * @param desc
	 * @throws DaoException 
	 * @throws DaoInsertException 
	 */
	public void commonent(int uid,int aid,int level,String desc) throws DaoException, DaoInsertException;
	/**
	 * 获取数据库的Session 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 */
	public void getSession()throws DaoException;
	/**
	 * 简历索引
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @throws Exception
	 */
	public void createIndexByHibernateSearch() throws Exception;
}
