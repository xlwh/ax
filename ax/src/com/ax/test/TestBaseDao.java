/*
 * Title:        爱学圈服务器 2015年1月22日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月22日
 */
package com.ax.test;

import org.junit.Test;

import com.ax.bean.Users;
import com.ax.dao.user.UserDao;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月22日
 */
public class TestBaseDao extends BaseTest{
	
	//测试数据库正常存储
	//@Test
	public void testSaveOk(){
		UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");
		Users user = new Users();
		user.setName("张洪斌");
		try {
			userDao.save(user);
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
	}
	
	//测试数据库回滚
		//@Test
	public void testRollback(){
		UserDao userDao = (UserDao) ctx.getBean("userDaoImpl");
		Users user = new Users();
		user.setName("张洪斌5555555555555555555555555555555555555555555555555555555555555555555555");
		try {
			userDao.save(user);
		} catch (DaoException e) {
			System.out.println("回滚了");
			e.printStackTrace();
		}
	}
		
   @Test
   public void testGetCount(){
	   UserDao user = (UserDao)ctx.getBean("userDaoImpl");
	   long count = user.getSize();
	   System.out.println(count);
   }
		
}
