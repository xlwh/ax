package com.ax.test;


import java.util.List;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ax.bean.Page;
import com.ax.bean.Users;
import com.ax.dao.user.UserDao;
import com.ax.exception.DaoException;
import com.ax.utils.PageUtil;

public class TestUserDao extends BaseTest{
	
	@Test
	@SuppressWarnings("resource")
	public void testSave(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
        for( int i=0;i<10;i++){
        Users user = new Users();
        user.setName("张洪斌");
       // user.setCreateTime(new Date(i));
        user.setDescription("测试用户，这是测试用户，用于测试");
        user.setExperience(4.5f);
        user.setGender("男");
        user.setId(i);
        user.setIsInSchool(1);
        user.setIsVerify(1);
        user.setIsVerify(1);
        user.setNicName("雪落无痕");
        user.setPassword("123456");
        user.setPic("http://121.40.142.73/t2.jpg");
        user.setTitle("测试");
        //System.out.println("测试");
        try {
			dao.save(user);
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
        }
	}
	
	//@Test
	public void testDelete(){
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
        Users user = new Users();
        user.setName("张");
        user.setId(1);
        try {
			dao.remove(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("删除成功!");
	}
	
	//@Test
	@SuppressWarnings("resource")
	public void testUpdate(){
		 ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
         UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
		 Users user = new Users();
		 user.setId(2);
	     user.setName("张洪斌");
	     try {
			dao.update(user);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testFindById(){
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
        Users us = null;
		try {
			us = dao.findById(2);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(us.getName());
	}
	
	
	@SuppressWarnings("resource")
	public void testFindByHql(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
        Object[] p = {"张洪斌"};
        String hql = "from Users u where u.name=?";
        try {
			List<Users> list = dao.findByHQL(hql, p);
			for(int i=0;i<list.size();i++){
				Users user = list.get(i);
				System.out.println(user.getName());
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testGetAll(){
		UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
		Page<Users> page = new PageUtil<Users>().newPage(10, 10);
		page = dao.findAll(page);
		List<Users> list = page.getRows();
		for(int i=0;i<list.size();i++){
			Users user = list.get(i);
			System.out.println(user.getName());
		}
	}
	
	//@Test
	public void testBidQq(){
		UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
		dao.bindQQ(1, "1079039435");
		System.out.println("绑定QQ成功");
	}
	
	//@Test
	public void testEduidfc(){
		UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
		dao.idfcEducation(1, "edu.jpg");
		System.out.println("学历认证成功");
	}
	
	//@Test
	public void testSearch(){
		UserDao dao = (UserDao)ctx.getBean("userDaoImpl");
		Page<Users> page = new Page<Users>();
		try {
			dao.searchTeacher(page, "张洪斌");
			List<Users> users = page.getRows();
			for(Users user : users){
				System.out.println(user.getName());
			}
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	
}
