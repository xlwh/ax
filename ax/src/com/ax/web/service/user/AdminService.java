package com.ax.web.service.user;

import com.ax.bean.Admin;
import com.ax.exception.DaoException;

public interface AdminService {
	/**
	 * 管理员登陆验证
	 * @param phone
	 * @param password
	 * @return
	 */
	public int login(String phone,String password);
	/**
	 * 管理员账号注册
	 * @param admin
	 */
	public void register(Admin admin)throws DaoException;
}
