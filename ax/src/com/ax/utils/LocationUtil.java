/*
 * Title:        爱学圈服务器 2015年2月2日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月2日
 */
package com.ax.utils;

/**
 * (一句话功能简述)
 * 经纬度位置工具
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月2日
 */
public class LocationUtil {
	/** 
	 * 生成以中心点为中心的四方形经纬度 
	 *  
	 * @param lat 纬度 
	 * @param lon 精度 
	 * @param raidus 半径（以米为单位） 
	 * @return 
	 */
	public static double[] getAround(double lat, double lon, int raidus) {

		Double latitude = lat;
		Double longitude = lon;

		Double degree = (24901 * 1609) / 360.0;
		double raidusMile = raidus;

		Double dpmLat = 1 / degree;
		Double radiusLat = dpmLat * raidusMile;
		Double minLat = latitude - radiusLat;
		Double maxLat = latitude + radiusLat;

		Double mpdLng = degree * Math.cos(latitude * (Math.PI / 180));
		Double dpmLng = 1 / mpdLng;
		Double radiusLng = dpmLng * raidusMile;
		Double minLng = longitude - radiusLng;
		Double maxLng = longitude + radiusLng;
		return new double[] { minLat, minLng, maxLat, maxLng };
	}

	/** 
	 * 计算中心经纬度与目标经纬度的距离（米） 
	 *  
	 * @param centerLon 
	 *            中心精度 
	 * @param centerLan 
	 *            中心纬度 
	 * @param targetLon 
	 *            需要计算的精度 
	 * @param targetLan 
	 *            需要计算的纬度 
	 * @return 米 
	 */
	public static double distance(double centerLon, double centerLat, double targetLon, double targetLat) {

		double jl_jd = 102834.74258026089786013677476285;// 每经度单位米;  
		double jl_wd = 111712.69150641055729984301412873;// 每纬度单位米;  
		double b = Math.abs((centerLat - targetLat) * jl_jd);
		double a = Math.abs((centerLon - targetLon) * jl_wd);
		return Math.sqrt((a * a + b * b));
	}

}
