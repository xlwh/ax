package com.ax.web.dao.user;

import java.util.List;

import com.ax.bean.Admin;
import com.ax.dao.base.DAO;

public interface AdminDao extends DAO<Admin>{
	/**
	 * 
	 * (一句话功能简述)
	 * 通过手机号码展示管理员的信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @param phone
	 * @return
	 */
	public Admin findByPhone(String phone);
	
	/**
	 * 
	 * (一句话功能简述)
	 * 列出所有管理员信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @return       所有的管理员信息
	 */
	public List<Admin> findAll();
}
