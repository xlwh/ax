/*
 * Title:        爱学圈服务器 2015年2月2日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月2日
 */
package com.ax.service.location;

import java.util.List;

import com.ax.action.location.LocationResult;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;

/**
 * 位置相关的业务逻辑
 * 
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月2日
 */
public interface LocationService {
	/**
	 * 
	 * 获取附近1KM
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @return       附近1km
	 * @throws DaoException 
	 * @throws NullPointException 
	 */
	public List<LocationResult> getNearBy(double lng,double lat,int type) throws NullPointException, DaoException;
	/**
	 * 
	 * 附近n km
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月2日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @param r      千米数
	 * @return       附近N km
	 * @throws DaoException 
	 * @throws NullPointException 
	 */
	public List<LocationResult> getNearBy(double lng,double lat,int type,int r) throws NullPointException, DaoException;
}
