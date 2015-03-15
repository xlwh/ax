/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.dao.location.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.ax.bean.Location;
import com.ax.bean.Page;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.dao.location.LocationDao;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;

/**
 * (一句话功能简述)
 * 位置相关的数据库访问接口的具体实现类
 * 主要功能是搜索某个位置周边的一些信息
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
@Repository
public class LocationDaoImpl extends DaoSupport<Location> implements LocationDao{

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.location.LocationDao#findByLocationAndByPage(long, long, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * 搜索：1度是111KM
	 * @param lng
	 * @param lat
	 * @param type
	 * @return
	 * @throws DaoException 
	 * @throws NullPointException 
	 */

	@SuppressWarnings("unchecked")
	@Override
	public Page<Location> findByLocationAndByPage(Page<Location> page,double lng, double lat, int type) throws DaoException, NullPointException {
		getSession();
		List<Location> locations = null;
		float r = 0.01f; //附近1KM
		if(session != null){
			String sql = "select * from T_LOCATION where LOCATION_LATITUDE > "+lat+"-"+r+" and LOCATION_TYPE="+type+" and LOCATION_LATITUDE < "+lat+"+"+r+" and LOCATION_LONGITUDE > "+lng+"-"+r+" and LOCATION_LONGITUDE < "+lng+"+"+r+" order by ACOS(SIN(("+lat+" * 3.1415) / 180 ) *SIN((LOCATION_LONGITUDE * 3.1415) / 180 ) +COS(("+lat+" * 3.1415) / 180 ) * COS((LOCATION_LATITUDE * 3.1415) / 180 ) *COS(("+lng+"* 3.1415) / 180 - (LOCATION_LONGITUDE* 3.1415) / 180 ) ) * 6380 asc";
			System.out.println("查询语句："+sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getMax());
			query.addEntity(Location.class);
			locations = query.list();
			
		}else{
			throw new NullPointException("没有找到合适的Session");
		}
		page.setRows(locations);
		return page;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.location.LocationDao#findByLocation(long, long, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng
	 * @param lat
	 * @param type
	 * @return
	 * @throws NullPointException 
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findByLocation(double lng, double lat, int type) throws NullPointException, DaoException {
		getSession();
		List<Location> locations = null;
		float r = 0.01f; //附近1KM
		if(session != null){
			String sql = "select * from T_LOCATION where LOCATION_LATITUDE > "+lat+"-"+r+" and LOCATION_TYPE="+type+" and LOCATION_LATITUDE < "+lat+"+"+r+" and LOCATION_LONGITUDE > "+lng+"-"+r+" and LOCATION_LONGITUDE < "+lng+"+"+r+" order by ACOS(SIN(("+lat+" * 3.1415) / 180 ) *SIN((LOCATION_LONGITUDE * 3.1415) / 180 ) +COS(("+lat+" * 3.1415) / 180 ) * COS((LOCATION_LATITUDE * 3.1415) / 180 ) *COS(("+lng+"* 3.1415) / 180 - (LOCATION_LONGITUDE* 3.1415) / 180 ) ) * 6380 asc";
			System.out.println("查询语句："+sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Location.class);
			locations = query.list();
			
		}else{
			throw new NullPointException("没有找到合适的Session");
		}
		return locations;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.location.LocationDao#findByLocationAndByPage(long, long, int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng
	 * @param lat
	 * @param type
	 * @param r
	 * @return
	 * @throws DaoException 
	 * @throws NullPointException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<Location> findByLocationAndByPage(Page<Location> page,double lng, double lat, int type, int rad) throws DaoException, NullPointException {
		getSession();
		List<Location> locations = null;
		float r = 0.01f*rad; //附近1KM
		if(session != null){
			String sql = "select * from T_LOCATION where LOCATION_LATITUDE > "+lat+"-"+r+" and LOCATION_TYPE="+type+" and LOCATION_LATITUDE < "+lat+"+"+r+" and LOCATION_LONGITUDE > "+lng+"-"+r+" and LOCATION_LONGITUDE < "+lng+"+"+r+" order by ACOS(SIN(("+lat+" * 3.1415) / 180 ) *SIN((LOCATION_LONGITUDE * 3.1415) / 180 ) +COS(("+lat+" * 3.1415) / 180 ) * COS((LOCATION_LATITUDE * 3.1415) / 180 ) *COS(("+lng+"* 3.1415) / 180 - (LOCATION_LONGITUDE* 3.1415) / 180 ) ) * 6380 asc";
			System.out.println("查询语句："+sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getMax());
			query.addEntity(Location.class);
			locations = query.list();
			
		}else{
			throw new NullPointException("没有找到合适的Session");
		}
		page.setRows(locations);
		return page;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.location.LocationDao#findByLocation(long, long, int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng
	 * @param lat
	 * @param type
	 * @param r
	 * @return
	 * @throws NullPointException 
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Location> findByLocation(double lng, double lat, int type, int rad) throws NullPointException, DaoException {
		getSession();
		List<Location> locations = null;
		float r = 0.01f*rad; //附近1KM
		if(session != null){
			String sql = "select * from T_LOCATION where LOCATION_LATITUDE > "+lat+"-"+r+" and LOCATION_TYPE="+type+" and LOCATION_LATITUDE < "+lat+"+"+r+" and LOCATION_LONGITUDE > "+lng+"-"+r+" and LOCATION_LONGITUDE < "+lng+"+"+r+" order by ACOS(SIN(("+lat+" * 3.1415) / 180 ) *SIN((LOCATION_LONGITUDE * 3.1415) / 180 ) +COS(("+lat+" * 3.1415) / 180 ) * COS((LOCATION_LATITUDE * 3.1415) / 180 ) *COS(("+lng+"* 3.1415) / 180 - (LOCATION_LONGITUDE* 3.1415) / 180 ) ) * 6380 asc";
			System.out.println("查询语句："+sql);
			SQLQuery query = session.createSQLQuery(sql);
			query.addEntity(Location.class);
			locations = query.list();
			
		}else{
			throw new NullPointException("没有找到合适的Session");
		}
		return locations;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.location.LocationDao#findByLocationAndByPage(long, long, int, int, java.util.Date)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng
	 * @param lat
	 * @param type
	 * @param r
	 * @param time
	 * @return
	 */
	@Override
	public Page<Location> findByLocationAndByPage(double lng, double lat, int type, int r, Date time) {
		
		return null;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.location.LocationDao#findByLocation(long, long, int, int, java.util.Date)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng
	 * @param lat
	 * @param type
	 * @param r
	 * @param time
	 * @return
	 */
	@Override
	public List<Location> findByLocation(double lng, double lat, int type, int r, Date time) {
		
		return null;
	}

}
