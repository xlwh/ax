package com.ax.web.service.user.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ax.bean.BannerInfo;
import com.ax.dao.banner.BannerInfoDao;
import com.ax.exception.DaoException;
import com.ax.web.service.user.BannerInfoService;

@Service
public class BannerInfoServiceImpl implements BannerInfoService{
	
	@Resource
	private BannerInfoDao bannerInfoDao;
	@Override
	public void save(BannerInfo bannerInfo) throws DaoException {
		bannerInfoDao.save(bannerInfo);
	}

}
