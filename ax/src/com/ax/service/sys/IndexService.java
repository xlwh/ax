package com.ax.service.sys;

import java.util.List;

import com.ax.bean.BannerInfo;
import com.ax.bean.TeacherRecommendInfo;

public interface IndexService {
	
	/**
	 * 构建服务器返回给app首页的信息
	 * @param num
	 * @param width
	 * @param height
	 * @return
	 */
	public String goIndex(int num,float width,float height);
	
	/**
	 * 构建服务器首页的滚动图片栏信息
	 * @param num
	 * @param width
	 * @param height
	 * @return
	 */
	public List<BannerInfo> getBannerInfo(int num,float width,float height);
	
	/**
	 * 获取APP首页的名师推荐信息
	 * 
	 * @return
	 */
	public List<TeacherRecommendInfo> getTeacherInfo();
}
