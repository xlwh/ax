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

import com.ax.bean.Identification;
import com.ax.bean.Qualification;
import com.ax.dao.identification.IdentificationDao;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public class TestIdfc extends BaseTest{
	private IdentificationDao identificationDao;
	@Before
	public void setUp(){
		identificationDao = (IdentificationDao)ctx.getBean("identificationDaoImpl");
	}
	
	//@Test
	public void testSave(){
		Identification idfc = new Identification();
		idfc.setName("学历认证");
		idfc.setState(1);
		idfc.setType(3);
		idfc.setUserid(1);
		
		Qualification a = new Qualification();
		a.setName("学历认证");
		a.setPic("pic.jpg");
		idfc.setQulification(a);
		try {
			identificationDao.save(idfc);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Test
    public void testget(){
		try {
			Identification idfc = identificationDao.findById(2);
			System.out.println(idfc.getName());
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
	
}
