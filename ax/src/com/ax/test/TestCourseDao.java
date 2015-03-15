/*
 * Title:        爱学圈服务器 2015年1月26日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月26日
 */
package com.ax.test;

import org.apache.lucene.queryparser.classic.ParseException;
import org.junit.Before;
import org.junit.Test;

import com.ax.bean.Course;
import com.ax.bean.Page;
import com.ax.dao.course.CourseDao;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月26日
 */
public class TestCourseDao extends BaseTest{
	private CourseDao dao;
	@Before
	public void setUp(){
		dao = (CourseDao)ctx.getBean("courseDaoImpl");
	}
	
	
	//@Test
	public void testSave(){
		for(int i=0;i<1000;i++){
		 Course course = new Course();
		 course.setAddress("江苏省南京市玄武区");
		 course.setAvgPrice(3200f);
		 course.setDesc("编程技术");
		 course.setLocationId("22222222222");
		 course.setUserid(1);
		 course.setName("JAVA编程");
		try {
			dao.save(course);
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
		}
		
	}
	
	//@Test
	public void testSearch() throws ParseException{
		try {
			dao.searchCourse("思想");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//@Test
	public void testApply(){
	  dao.joinCourse(1, 1);
	}
	
	@Test
	public void testgetNear(){
		Page<Course> page = new Page<Course>();
		dao.nearbyCourse(page, 113, 53);
		
	}
	
}
