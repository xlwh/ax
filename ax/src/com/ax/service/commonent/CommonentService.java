/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.service.commonent;

import java.util.List;

import com.ax.action.commonent.CommonentResult;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * 评论相关的业务逻辑
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public interface CommonentService {
	/**
	 * 
	 * 找到某个老师的相关的评论
	 * 分页加载评论数据
	 * 每次加载5条数据
	 * 传入页码n
	 *    获取总记录数目count
	 *    if(count<5)---->直接返回。。。。
	 *    else:
	 *       计算总页数:pagenum -> if(n<pagenum)---->计算该页的记录起始，返回记录
	 *                else----->out of table
	 * 
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @param tid
	 * @return
	 * @throws DaoException 
	 */
	public List<CommonentResult> findByTid(int tid,int page) throws DaoException;
	/**
	 * 
	 * 写评论
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param uid
	 * @param teacherid
	 * @param level
	 * @param content
	 * @throws DaoException
	 */
	public void writeCommonent(int uid,int teacherid,int level,String content) throws DaoException;
	
}
