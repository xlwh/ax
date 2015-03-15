/*
 * Title:        爱学圈服务器 2015年2月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年2月1日
 */
package com.ax.dao.school.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ax.bean.School;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.dao.school.SchoolDao;
import com.ax.exception.DaoException;

/**
 * (一句话功能简述)
 * 学校相关的数据库访问接口的实现类
 * 完成数据库相关访问的具体的操作
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年2月1日
 */
@Repository
public class SchoolDaoImpl extends DaoSupport<School> implements SchoolDao{

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.school.SchoolDao#findByProvinceId(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param pid
	 * @return
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<School> findByProvinceId(String pid) throws DaoException {
		getSession();
		List<School> schools = null;
		if(session != null){
			String hql = "from School where provinceid=:pid";
			Query query = session.createQuery(hql);
			if(pid != null){
				query.setParameter("pid", pid);
				schools = query.list();
			}else{
				throw new DaoException("The pid can not be null!");
			}
		}
		return schools;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.school.SchoolDao#findByCityId(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param cid
	 * @return
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<School> findByCityId(String cid) throws DaoException {
		getSession();
		List<School> schools = null;
		if(session != null){
			String hql = "from School where cityid=:cid";
			Query query = session.createQuery(hql);
			if(cid != null){
				query.setParameter("cid", cid);
				schools = query.list();
			}else{
				throw new DaoException("The cid can not be null!");
			}
		}
		return schools;
	}
	
	

}
