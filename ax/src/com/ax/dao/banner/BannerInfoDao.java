package com.ax.dao.banner;

import java.util.List;

import com.ax.bean.BannerInfo;
import com.ax.dao.base.DAO;

public interface BannerInfoDao extends DAO<BannerInfo>{
	/**
	 * 获取指定数量的广告信息
	 * @param num
	 * @return
	 */
	public List<BannerInfo> findByNum(int num);
}
