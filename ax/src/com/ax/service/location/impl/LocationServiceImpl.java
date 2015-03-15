/*
 * Title:        爱学圈服务器 2015年2月2日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月2日
 */
package com.ax.service.location.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.action.location.LocationResult;
import com.ax.bean.Location;
import com.ax.dao.location.LocationDao;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;
import com.ax.service.location.LocationService;
import com.ax.utils.LocationUtil;

/**
 * (一句话功能简述)
 * 位置相关的业务逻辑接口的具体实现类
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月2日
 */
@Service
public class LocationServiceImpl implements LocationService {

	@Resource
	private LocationDao locationDao;

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 搜索周边的1KM
	 * @see com.ax.service.location.LocationService#getNearBy(double, double, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @return       搜索到的周围的
	 * @throws DaoException 
	 * @throws NullPointException 
	 */
	@Override
	public List<LocationResult> getNearBy(double lng, double lat, int type) throws NullPointException, DaoException {
		List<LocationResult> res = null;
		List<Location> list = locationDao.findByLocation(lng, lat, type);
		if (list != null & list.size() > 0) {
			res = new ArrayList<LocationResult>();
			for (Location location : list) {
				LocationResult lr = new LocationResult();
				lr.setContentid(location.getContentid());
				lr.setDistance(LocationUtil.distance(lng, lat, location.getLongitude(), location.getLatitude()));
				lr.setLatitude(location.getLatitude());
				lr.setLongitude(location.getLongitude());
				res.add(lr);
			}
		}
		return res;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 搜索周边的N km
	 * @see com.ax.service.location.LocationService#getNearBy(double, double, int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @param r     N KM
	 * @return      周边N KM
	 * @throws DaoException 
	 * @throws NullPointException 
	 */
	@Override
	public List<LocationResult> getNearBy(double lng, double lat, int type, int r) throws NullPointException,
			DaoException {
		List<LocationResult> res = null;
		List<Location> list = locationDao.findByLocation(lng, lat, type, r);
		if (list != null & list.size() > 0) {
			res = new ArrayList<LocationResult>();
			for (Location location : list) {
				LocationResult lr = new LocationResult();
				lr.setContentid(location.getContentid());
				lr.setDistance(LocationUtil.distance(lng, lat, location.getLongitude(), location.getLatitude()));
				lr.setLatitude(location.getLatitude());
				lr.setLongitude(location.getLongitude());
				res.add(lr);
			}
		}
		return res;
	}

}
