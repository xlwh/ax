package com.ax.dao.banner.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.ax.bean.BannerInfo;
import com.ax.dao.banner.BannerInfoDao;
import com.ax.dao.base.impl.DaoSupport;

@Repository
@Transactional
public class BannerInfoDaoImpl extends DaoSupport<BannerInfo> implements BannerInfoDao{

	@SuppressWarnings("unchecked")
	@Override
	public List<BannerInfo> findByNum(int num) {
		session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from BannerInfo");
		query.setFirstResult(0);
		if(num<0){
			query.setMaxResults(2);
		}else if(num>5){
			query.setMaxResults(5);
		}else{
			query.setMaxResults(num);
		}
		return query.list();
	}

}
