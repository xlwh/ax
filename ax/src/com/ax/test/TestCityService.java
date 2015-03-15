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

import com.ax.dao.city.ProvinceResult;
import com.ax.exception.DaoException;
import com.ax.service.city.CityService;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public class TestCityService extends BaseTest{
	private CityService cityService;
	@Before
	public void setUp(){
		cityService = (CityService)ctx.getBean("cityServiceImpl");
	}
	
	//@Test
	public void testGet(){
		try {
			List<ProvinceResult> res = cityService.getProvinces();
			System.out.println(res.size());
			for(ProvinceResult r : res){
				System.out.println(r.getName());
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testGetNj(){
		cityService.getNjZone();
	}
}
