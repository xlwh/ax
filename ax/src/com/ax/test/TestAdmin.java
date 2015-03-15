package com.ax.test;

import org.junit.Test;

import com.ax.bean.Admin;
import com.ax.exception.DaoException;
import com.ax.web.service.user.AdminService;

public class TestAdmin extends BaseTest{
	
	private AdminService adminService;
	//@Test
	public void testSave(){
		adminService = (AdminService)ctx.getBean("adminServiceImpl");
		Admin admin = new Admin();
		admin.setPassword("123456");
		admin.setPhone("18951899340");
		try {
			adminService.register(admin);
		} catch (DaoException e) {
			System.out.println("注册失败");
			e.printStackTrace();
		}
	}
	
	@Test
	public void testLogin(){
		adminService = (AdminService)ctx.getBean("adminServiceImpl");
		System.out.println(adminService.login("18951899340", "123456"));
	}
}
