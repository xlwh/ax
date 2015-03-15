/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.service.city;

import java.util.List;

import com.ax.dao.city.ProvinceResult;
import com.ax.exception.DaoException;
import com.ax.service.city.impl.ZoneResult;

/**
 * 
 * 地点信息相关的业务逻辑处理
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public interface CityService {
	/**
	 * 
	 * 获取所有的省份信息
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @return       找到的省级信息结果
	 * @throws DaoException 
	 */
	public List<ProvinceResult> getProvinces() throws DaoException;
	/**
	 * 
	 * 获取南京市所有区的信息
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @return      南京市的所有区
	 */
	public List<ZoneResult> getNjZone();
}
