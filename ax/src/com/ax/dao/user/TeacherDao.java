/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.dao.user;

import java.util.List;

import org.apache.lucene.queryparser.classic.ParseException;

import com.ax.bean.Identification;
import com.ax.bean.Page;
import com.ax.bean.Teacher;
import com.ax.dao.base.DAO;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */
public interface TeacherDao extends DAO<Teacher>{
	/**
	 * 搜索老师
	 * @throws ParseException 
	 */
	public Page<Teacher> search(Page<Teacher> page,String name) throws ParseException;
	/**
	 * 
	 * 获取教师的认证情况
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @param id
	 * @return
	 */
	public List<Identification> getIdfcByUid(int id);
	/**
	 * 
	 * 多条件检索老师
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param page   分页的页面对象
	 * @param name   老师名字
	 * @param major  科目 
	 * @param type   老师类型
	 * @return       搜索到的老师
	 * @throws InterruptedException 
	 */
	public Page<Teacher> search(Page<Teacher> page,String name,String major,int type) throws InterruptedException;
	/**
	 * 
	 * 分页加载所有的老师
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param page
	 * @return
	 */
	public List<Teacher> getAllByPage(int page,int pageSize);
}
