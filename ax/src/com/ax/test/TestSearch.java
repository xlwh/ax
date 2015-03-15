/*
 * Title:        爱学圈服务器 2015年1月23日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月23日
 */
package com.ax.test;

import java.util.List;

import org.junit.Test;

import com.ax.bean.Page;
import com.ax.bean.Users;
import com.ax.dao.user.UserDao;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月23日
 */
public class TestSearch extends BaseTest{
	@Test
	public void testSearch(){
		UserDao userDao = (UserDao)ctx.getBean("userDaoImpl");
		Page<Users> page = new Page<Users>();
		try {
			page = userDao.searchTeacher(page,"张洪斌");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Users> res = page.getRows();
		System.out.println(res.size());
	}
}
