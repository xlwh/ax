/*
 * Title:        爱学圈服务器 2015年2月5日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月5日
 */
package com.ax.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.ax.action.commonent.CommonentResult;
import com.ax.exception.DaoException;
import com.ax.service.commonent.CommonentService;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月5日
 */
public class TestCommonentService extends BaseTest{
	private CommonentService comm;
	@Before
	public void setUp(){
		comm = (CommonentService)ctx.getBean("commonentServiceImpl");
	}
	
	@Test
	public void test(){
		try {
			List<CommonentResult> res = comm.findByTid(2, 2);
			for(CommonentResult r: res){
				System.out.println(r.getCreateTime());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
