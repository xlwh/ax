/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.test;

import org.junit.Before;
import org.junit.Test;

import com.ax.bean.Commonent;
import com.ax.dao.comment.CommentDao;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public class TestCommentDao extends BaseTest{
	private CommentDao commentDao;
	@Before
	public void setUp(){
		commentDao = (CommentDao)ctx.getBean("commentDaoImpl");
	}
	
	@Test
	public void TestSave(){
		for(int i=3;i<9;i++){
		Commonent c = new Commonent();
		c.setDesc("这是一个非常好的老师，我很喜欢他");
		c.setUserid(i);
	    c.setTeacherid(3);
	    c.setLever(2);
	    try {
			commentDao.save(c);
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
	}
	}
	
}
