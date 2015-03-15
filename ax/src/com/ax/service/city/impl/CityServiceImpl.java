/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.service.city.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.bean.CityInfo;
import com.ax.bean.ProvinceInfo;
import com.ax.dao.city.CityInfoDao;
import com.ax.dao.city.ProvinceInfoDao;
import com.ax.dao.city.ProvinceResult;
import com.ax.exception.DaoException;
import com.ax.service.city.CityService;

/**
 * (一句话功能简述)
 * 城市相关的相关业务逻辑接口实现类
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
@Service
public class CityServiceImpl implements CityService{
	@Resource
	private CityInfoDao cityInfoDao;
	@Resource
	private ProvinceInfoDao provinceInfoDao;
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.city.CityService#getProvinces()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @return
	 * @throws DaoException 
	 */
	@Override
	public List<ProvinceResult> getProvinces() throws DaoException {
		List<ProvinceInfo> pros = provinceInfoDao.findAll();
		List<ProvinceResult> res = new ArrayList<ProvinceResult>();
		for(ProvinceInfo pro : pros){
			ProvinceResult r = new ProvinceResult();
			r.setName(pro.getProvinceName());
			r.setId(pro.getProvinceCode());
			res.add(r);
		}
		return res;
	}
	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.city.CityService#getNjZone()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @return
	 */
	@Override
	public List<ZoneResult> getNjZone() {
		try {
			List<CityInfo> cityinfos = cityInfoDao.findByHQL("from CityInfo where provinceCode=320000 and cityCode <320200", null);
			for(CityInfo city : cityinfos){
				System.out.println(city.getCityCode()+":"+ city.getCityName());
			}
		} catch (DaoException e) {
			
			e.printStackTrace();
		}
		return null;
	}

}
