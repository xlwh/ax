package com.ax.web.dao.user.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ax.bean.Admin;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.web.dao.user.AdminDao;

@Repository
public class AdminDaoImpl extends DaoSupport<Admin> implements AdminDao{
	
	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 通过手机号码展示管理员
	 * @see com.ax.web.dao.user.AdminDao#findByPhone(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @param phone
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public Admin findByPhone(String phone) {
		session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Admin admin WHERE admin.phone=?");
		query.setParameter(0, phone);
		List<Admin> result = query.list();
		if(result.size()>0){
			return result.get(0);
		}else{
			return null;
		}
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.web.dao.user.AdminDao#findAll()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @return
	 */
	@Override
	public List<Admin> findAll() {
		
		return null;
	}
	
	
	

}
