package com.ax.web.service.user;

import com.ax.bean.BannerInfo;
import com.ax.exception.DaoException;

public interface BannerInfoService {
	/**
	 * 添加首页展示信息
	 * @param bannerInfo
	 */
	public void save(BannerInfo bannerInfo)throws DaoException;
}
