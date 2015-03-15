/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.dao.school;

import java.util.List;

import com.ax.bean.School;
import com.ax.dao.base.DAO;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * 学校相关的业务逻辑访问接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
public interface SchoolDao extends DAO<School>{
	/**
	 * 
	 * 查找某个省份的高校
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param pid
	 * @return
	 * @throws DaoException 
	 */
	public List<School> findByProvinceId(String pid) throws DaoException;
	/**
	 * 
	 * 通过城市的id获取某个城市的学校
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param cid
	 * @return
	 * @throws DaoException 
	 */
	public List<School> findByCityId(String cid) throws DaoException;
	
}
