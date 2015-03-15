/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.dao.location;

import java.util.Date;
import java.util.List;

import com.ax.bean.Location;
import com.ax.bean.Page;
import com.ax.dao.base.DAO;
import com.ax.exception.DaoException;
import com.ax.exception.NullPointException;

/**
 * (一句话功能简述)
 * 为孩子相关的数据库访问接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
public interface LocationDao extends DAO<Location> {
	/**
	 * 
	 * 分页获取周边的数据
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng    经度
	 * @param lat    维度
	 * @param type   类型：1：普通用户和私教  2：名师  3：课程   4：活动
	 * @return       
	 * @throws DaoException 
	 * @throws NullPointException 
	 */
	public Page<Location> findByLocationAndByPage(Page<Location> page,double lng, double lat, int type) throws DaoException, NullPointException;

	/**
	 * 
	 * (一句话功能简述)
	 * 不分页加载所有周边的位置信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @return       周边的东西
	 * @throws NullPointException 
	 * @throws DaoException 
	 */
	public List<Location> findByLocation(double lng, double lat, int type) throws NullPointException, DaoException;

	/**
	 * 
	 * 分页获取周边的数据
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng    经度
	 * @param lat    维度
	 * @param type   类型：1：普通用户和私教  2：名师  3：课程   4：活动
	 * @param r      半径
	 * @return       
	 * @throws DaoException 
	 * @throws NullPointException 
	 */
	public Page<Location> findByLocationAndByPage(Page<Location> page,double lng, double lat, int type, int r) throws DaoException, NullPointException;

	/**
	 * 
	 * (一句话功能简述)
	 * 不分页加载所有周边的位置信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @param r      半径
	 * @return       周边的东西
	 * @throws NullPointException 
	 * @throws DaoException 
	 */
	public List<Location> findByLocation(double lng, double lat, int type, int r) throws NullPointException, DaoException;
	/**
	 * 
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @param r      半径
	 * @param time   时间
	 * @return       周围的事物
	 */
	public Page<Location> findByLocationAndByPage(double lng, double lat, int type, int r, Date time);

	/**
	 * 
	 * (一句话功能简述)
	 * 不分页加载所有周边的位置信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param type   类型
	 * @param r      半径
	 * @return       周边的东西
	 */
	public List<Location> findByLocation(double lng, double lat, int type, int r, Date time);
}
