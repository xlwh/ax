/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.test;

import org.junit.Before;
import org.junit.Test;

import com.ax.bean.Location;
import com.ax.bean.Page;
import com.ax.dao.location.LocationDao;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;
import com.ax.utils.LocationUtil;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
public class TestLocationDao extends BaseTest{
	private LocationDao locationDao;
	@Before
	public void setUp(){
		locationDao = (LocationDao)ctx.getBean("locationDaoImpl");
	}
	
	//@Test
	public void testSave(){
		double i=22.999101476027793,j=22.999023879158443;
		  while(i<24.000898523972207 && j<24.000976120841557){
			Location location = new Location();
			i = i+0.001;
			j = j+0.001;
			location.setLongitude(i);
			location.setLatitude(j);
			location.setType(1);
			//location.setContentid(k);
			try {
				locationDao.save(location);
			} catch (DaoException e) {
			
				e.printStackTrace();
			}
		  }
		System.out.println("数据构建完成");
	}
	
	
	public void testLocationUtil(){
		double d[] = LocationUtil.getAround(23, 23, 100);
		for(int i=0;i<d.length;i++){
			System.out.println(d[i]);
		}
	}
	
	@Test
	public void testGetByPage(){
		Page<Location> page = new Page<Location>();
		page.setStart(0);
		page.setMax(100);
		try {
			page = locationDao.findByLocationAndByPage(page, 23, 23, 1);
			System.out.println(page.getRows().size());
			/*for(Location location : page.getRows()){
				System.out.println("经度："+location.getLongitude()+",纬度："+location.getLatitude());
			}*/
		} catch (DaoException e) {
			
			e.printStackTrace();
		} catch (NullPointException e) {
			
			e.printStackTrace();
		}
	}
}
