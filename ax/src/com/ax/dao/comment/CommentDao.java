/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.dao.comment;

import java.util.List;

import com.ax.bean.Commonent;
import com.ax.bean.Page;
import com.ax.dao.base.DAO;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * 评论相关的数据库访问接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public interface CommentDao extends DAO<Commonent>{
	/**
	 * 
	 * 找到对应于某个用户的相关的评论
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @param uid
	 * @return
	 * @throws DaoException 
	 */
	public List<Commonent> findByUid(int uid) throws DaoException;
	
	/**
	 * 
	 * 分页加载所有的评论
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @param uid
	 * @param page
	 * @return
	 * @throws DaoException 
	 */
	public Page<Commonent> findByUidAndPage(int uid,Page<Commonent> page) throws DaoException;
	/**
	 * 通过页码来分页加载评论
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月3日
	 * @param uid    用户的id
	 * @param page   页码
	 * @return      分页的评论
	 * @throws DaoException 
	 */
	public List<Commonent> findByUidAndPage(int uid,int page) throws DaoException;
}
