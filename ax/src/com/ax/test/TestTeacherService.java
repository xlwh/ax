/*
 * Title:        爱学圈服务器 2015年1月29日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月29日
 */
package com.ax.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ax.bean.Course;
import com.ax.bean.Rank;
import com.ax.bean.Subject;
import com.ax.bean.Teacher;
import com.ax.bean.TeacherRecommendInfo;
import com.ax.dao.user.TeacherDao;
import com.ax.dao.user.TeacherRecommendInfoDao;
import com.ax.exception.DaoException;
import com.ax.service.user.TeacherService;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月29日
 */
public class TestTeacherService extends BaseTest{
	
	
	public void test(){
		TeacherService teacherService = (TeacherService)ctx.getBean("teacherServiceImpl");
		try {
			teacherService.getDetailById(1);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void buildData() throws DaoException{
		//构建教师假数据
		//添加一位老师  设置推荐信息  设置课程信息  
		Teacher teacher = new Teacher();
		teacher.setAddress("江苏省南京市玄武区");
		teacher.setAge(43);
		teacher.setDesc("多年来在全国十几个大中城市辅导考研政治，高屋建瓴，大家风范。 其授课全面细致，一针见血，鞭辟入里，深受广大考研学子的信赖和拥戴.");
		teacher.setEdu("博士");
		teacher.setExp(10);
		teacher.setGender("男");
		teacher.setMajor("毛泽东思想和中国特色社会主义理论体系概论");
		teacher.setName("陆卫明");
		teacher.setNicName("陆卫明");
		teacher.setPhone("18951899340");
		teacher.setPic("http://121.40.142.73/pic/t2.jpg");
		Rank rk = new Rank();
		rk.setName("英语名师");
		List<Rank> ranks = new ArrayList<Rank>();
		ranks.add(rk);
		teacher.setRank(ranks);
		teacher.setStar(4);
		teacher.setState("在线");
		teacher.setType(3);
		
		TeacherRecommendInfo recommend = new TeacherRecommendInfo();
		recommend.setCourseid(1);
		recommend.setMajor("英语");
		recommend.setPic("http://121.40.142.73/pic/t2.jpg");
		recommend.setStar(4);
		recommend.setTitle("英语名师");
		recommend.setTitle("海天“任氏教学法”创立者，实践者之一");
		recommend.setUserID(3);
		
		Course course = new Course();
		course.setAddress("江苏省南京市南京大学");
		course.setAvgPrice(3000);
		course.setDesc(" 考研公共课由海天名师团队授课，包含考研各阶段单项班型。无限次听课，从起步到临考全程教学，直达高分。标准课程奠定基础，从备考初期到考前复习全程学习规划指导及名师答疑，全新的授课模式及服务，从知识点讲解到题目演练，到重点总结，层层深入，提高考生实战解决问题的能力。一改以往政治复习旧习，早报早学，在奠定基础的前提下，根据考研不同时间段配备对应的班次帮助考生逐步提高，助力你的2015年考研！");
		course.setState(1);
		
		Subject subject = new Subject();
		subject.setName("考研英语");
		course.setSubject(subject);
		course.setUserid(1);
		
		
		TeacherDao teacherDao = (TeacherDao)ctx.getBean("teacherDaoImpl");
		teacherDao.save(teacher);
		
		
		TeacherRecommendInfoDao recommendDao = (TeacherRecommendInfoDao)ctx.getBean("teacherRecommendInfoDaoImpl");
		recommendDao.save(recommend);
		/*CourseDao courseDao = (CourseDao)ctx.getBean("courseDaoImpl");
		courseDao.save(course);*/
		
	}
	
	@SuppressWarnings("unused")
	@Test
	public void testGet(){
		TeacherService teacherService = (TeacherService)ctx.getBean("teacherServiceImpl");
	    
		
	}
}
