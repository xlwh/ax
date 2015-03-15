/*
 * Title:        爱学圈服务器 2015年3月9日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月9日
 */
package com.ax.dao.circle.impl;

import java.util.List;

import com.ax.bean.CircleMessage;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.dao.circle.CircleMessageDao;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * 学习圈动态的数据库访问接口实现类
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */
public class CircleDaoImpl extends DaoSupport<CircleMessage> implements CircleMessageDao{

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 通过用户ID获取用户所发表的动态
	 * @see com.ax.dao.circle.CircleMessageDao#getByUid(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param uid    用户ID
	 * @return       学习圈动态
	 * @throws DaoException 
	 */
	@Override
	public List<CircleMessage> getByUid(int uid) throws DaoException {
		 String[] p = {""+uid};
	     return findByHQL("from CircleMessage where uid=?", p);
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 获取学习圈的附近的学习圈动态
	 * @see com.ax.dao.circle.CircleMessageDao#getNearby(float, float)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param lng    经度
	 * @param lat    纬度
	 * @return       学习圈动态
	 * @throws DaoException 数据库访问异常
	 */
	@Override
	public List<CircleMessage> getNearby(float lng, float lat) throws DaoException {
		String hql = "from Location location where type=4 and SQRT((location.longitude-" + lng
				+ ")*(location.longitude-" + lat + ")-(location.latitude-" + lat + ")*(location.latitude-" + lat
				+ "))>2000";
		return super.findByHQL(hql, null);
	}

}
