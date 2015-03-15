package com.ax.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ax.bean.Users;
import com.ax.exception.DaoException;
import com.ax.exception.ServiceException;
import com.ax.service.user.UserService;

public class TestUserService extends BaseTest{
	
	private UserService userService;
	@Before
	public void setUp(){
		userService = (UserService)ctx.getBean("userServiceImpl");
	}
	@Test
	public void testGetCode(){
		UserService userService = (UserService)ctx.getBean("userServiceImpl");
		try {
			userService.getCode("18951899340", null);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testSearch(){
		List<Users> list;
		try {
			list = userService.searchUser(1, "张", null, false);
			for(Users user : list){
				System.out.println(user.getName());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
	}
}
