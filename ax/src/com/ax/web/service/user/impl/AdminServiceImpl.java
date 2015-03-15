package com.ax.web.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.bean.Admin;
import com.ax.exception.DaoException;
import com.ax.web.dao.user.AdminDao;
import com.ax.web.service.user.AdminService;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Resource
	private AdminDao adminDao;
	@Override
	public int login(String phone, String password) {
		long i = System.currentTimeMillis();
		Admin admin = adminDao.findByPhone(phone);
		long j = System.currentTimeMillis();
		System.out.println("话费时间："+(j-i));
		int info = 0;
		if(admin == null){
			//管理员不存在
			info = 1;
		}else{
			if(admin.getPassword().equals(password)){
				//正确
				info = 3;
			}else{
				//密码错误
				info = 2;
			}
		}
		return info;
	}
	@Override
	public void register(Admin admin) throws DaoException {
		adminDao.save(admin);
		
	}

}
