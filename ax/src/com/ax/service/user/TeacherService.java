/*
 * Title:        爱学圈服务器 2015年1月29日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月29日
 */
package com.ax.service.user;

import java.util.List;

import com.ax.app.action.user.TeacherDetailResult;
import com.ax.bean.Teacher;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * 名师相关的业务逻辑处理
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月29日
 */
public interface TeacherService {
	/**
	 * 
	 * 获取老师详情
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public TeacherDetailResult getDetailById(int id) throws DaoException;
	/**
	 * 
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param keyword  搜索关键词
	 * @param subject  按科目
	 * @param r        距离
	 * @param auto     是否自动排序
	 * @param type     是否认证
	 * @param lng      经度
	 * @param lat      纬度
	 * @return         搜索结果
	 */
	public List<Teacher> search(String keyword,String subject,int r,int auto,int type,long lng,long lat);
	/**
	 * 
	 * 获取所有老师
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @return
	 * @throws DaoException 
	 */
	public List<Teacher> getAll() throws DaoException;
	/**
	 * 
	 * 分页加载所有老师
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param page
	 * @return
	 */
	public List<Teacher> getAll(int page,int pageSize);
	/**
	 * 
	 * 获取总记录数
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @return
	 */
	public long getCount();
	
}
