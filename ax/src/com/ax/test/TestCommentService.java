/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
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
 * @since        爱学圈服务器, 2015年1月31日
 */
public class TestCommentService extends BaseTest{
	private CommonentService commonentService;
	@Before
	public void setUp(){
		commonentService = (CommonentService)ctx.getBean("commonentServiceImpl");
	}
	@Test
	public void testGet(){
		try {
			List<CommonentResult> res = commonentService.findByTid(2,1);
			for(CommonentResult cmt: res){
				System.out.println(cmt.getCreateTime()+","+cmt.getNicname()+"评论了你："+cmt.getContent());
			}
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
