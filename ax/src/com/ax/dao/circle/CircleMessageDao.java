/*
 * Title:        爱学圈服务器 2015年3月9日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月9日
 */
package com.ax.dao.circle;

import java.util.List;

import com.ax.bean.CircleMessage;
import com.ax.dao.base.DAO;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * 学习圈数据库访问接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */
public interface CircleMessageDao extends DAO<CircleMessage>{
	/**
	 * 
	 * 通过用户ID获取所有的动态
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param uid    用户ID
	 * @return       自己发表的所有的
	 * @throws DaoException 
	 */
	public List<CircleMessage> getByUid(int uid) throws DaoException;
	/**
	 * 
	 * 获取附近20公里学习圈的动态
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param lng    经度
	 * @param lat    纬度
	 * @return       学习圈的动态信息
	 * @throws DaoException 
	 */
	public List<CircleMessage> getNearby(float lng,float lat) throws DaoException;
}
