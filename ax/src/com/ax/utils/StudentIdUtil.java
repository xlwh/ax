/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.utils;

import java.util.Random;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.ax.exception.NullPointException;

/**
 * (一句话功能简述)
 * 学号生成工具
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
@Component
public class StudentIdUtil {
	@Resource
	private SessionFactory sessionFactory;

	/**
	 * 生成学号
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @return
	 */
	private String create() {
		int l1, l2, l3, l4, l5, l6;
		Random random = new Random();
		l1 = random.nextInt(10);
		l2 = random.nextInt(10);
		l3 = random.nextInt(10);
		l4 = random.nextInt(10);
		l5 = random.nextInt(10);
		l6 = random.nextInt(10);
		return "ax" + l1 + l2 + l3 + l4 + l5 + l6;
	}

	/**
	 * 
	 * 获取学号
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @return
	 * @throws NullPointException
	 */
	public String getStudentId() throws NullPointException {
		String s = null;
		s = create();
		while (check(s) == true) {
			s = create();
		}

		return s;
	}

	/**
	 * 
	 * 检查该学号是不是已经被使用过了
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param xh
	 * @return
	 * @throws NullPointException
	 */
	@SuppressWarnings("unused")
	private boolean check(String xh) throws NullPointException {
		boolean flag = false;
		Session session = getSession();
		if (session != null) {
			Query query = session.createQuery("from Users where studentid=:studentid");
			query.setParameter("studentid", xh);
			if (query.list().size() > 0) {
				flag = true; //已结存在该学号
			}
		} else {
			throw new NullPointException("没有合适的Session从系统中获取到！");
		}
		return false;
	}

	/**
	 * 
	 * 获取数据库的Session会话
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @return       Session对象
	 */
	private Session getSession() {
		Session session = null;
		if (sessionFactory != null) {
			session = sessionFactory.getCurrentSession();
		}
		return session;
	}

}
