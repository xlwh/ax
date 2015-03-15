package com.ax.dao.user.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.search.FullTextSession;
import org.hibernate.search.Search;
import org.hibernate.search.SearchFactory;
import org.hibernate.search.query.dsl.QueryBuilder;
import org.springframework.stereotype.Repository;

import com.ax.bean.Identification;
import com.ax.bean.IdentificationInfo;
import com.ax.bean.Page;
import com.ax.bean.Qualification;
import com.ax.bean.Users;
import com.ax.dao.base.impl.DaoSupport;
import com.ax.dao.user.UserDao;
import com.ax.exception.DaoException;
import com.ax.exception.DaoInsertException;
import com.ax.exception.DaoQueryException;
import com.ax.exception.DaoUpdateException;
import com.ax.exception.ExceptionHandle;
import com.ax.exception.MethodParamException;

@Repository
@Transactional
public class UserDaoImpl extends DaoSupport<Users> implements UserDao {

	@SuppressWarnings("unchecked")
	
	@Override
	public Users findByPhone(String phone) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoQueryException e = new DaoQueryException("没有找到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#findByPhone(String phone)");
		}
		Query query = session.createQuery("FROM Users WHERE phone=?");
		query.setParameter(0, phone);
		List<Users> result = query.list();
		if (result.size() > 0) {
			return result.get(0);
		} else {
			return null;
		}

	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 分页查看所有用户信息
	 * @see com.ax.dao.user.UserDao#findAll(com.ax.bean.Page)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param page
	 * @return
	 */
	@Transactional
	@SuppressWarnings("unchecked")
	@Override
	public Page<Users> findAll(Page<Users> page) {
		String hql = "from Users";
		List<Users> result = null;
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoQueryException e = new DaoQueryException("没有找到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#findAll(Page<Users> page)");
		}
		Query query = session.createQuery(hql);
		if (!(page.getStart() <= 0) || !(page.getMax() <= 0)) {
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getMax());
		}
		result = query.list();
		page.setRows(result);
		return page;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#bindQQ(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param qq
	 */
	@Transactional
	@Override
	public void bindQQ(int id, String qq) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null && qq != null) {
			user.setQq(qq);
		} else {
			DaoUpdateException e = new DaoUpdateException("该用户不存在");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}

	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#bindWexin(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param wexin
	 */
	@Override
	public void bindWexin(int id, String wexin) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null && wexin != null) {
			user.setWeixing(wexin);
		} else {
			DaoUpdateException e = new DaoUpdateException("该用户不存在");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#bindWebo(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param webo
	 */
	@Override
	public void bindWebo(int id, String webo) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null && webo != null) {
			user.setWebo(webo);
		} else {
			DaoUpdateException e = new DaoUpdateException("该用户不存在");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindWbo(int id,String qq)");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#idfcEducation(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param pic
	 */
	@Transactional
	@Override
	public void idfcEducation(int id, String pic) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null && pic != null) {
			Identification idfc = new Identification();
			Qualification quli = new Qualification();
			idfc.setState(0);
			idfc.setType(2);
			//quli.setCreateTime(new Date());
			quli.setName("学历认证");
			quli.setPic(pic);
			idfc.setUserid(id);
			idfc.setQulification(quli);
			session.save(idfc);
			session.save(quli);
		} else {
			DaoUpdateException e = new DaoUpdateException("该用户不存在");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#idfcJob(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param pic
	 */
	@Override
	public void idfcJob(int id, String pic) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null && pic != null) {
			Identification idfc = new Identification();
			Qualification quli = new Qualification();
			idfc.setState(0);
			idfc.setType(3);
			//quli.setCreateTime(new Date());
			quli.setName("职业认证");
			quli.setPic(pic);
			idfc.setUserid(id);
			idfc.setQulification(quli);
			session.save(idfc);
			session.save(quli);
		} else {
			DaoUpdateException e = new DaoUpdateException("该用户不存在");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#idfcQualification(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param pic
	 */
	@Override
	public void idfcQualification(int id, String pic) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null && pic != null) {
			Identification idfc = new Identification();
			Qualification quli = new Qualification();
			idfc.setState(0);
			idfc.setType(4);
			//quli.setCreateTime(new Date());
			quli.setName("证书认证");
			quli.setPic(pic);
			idfc.setUserid(id);
			idfc.setQulification(quli);
			session.save(idfc);
			session.save(quli);
		} else {
			DaoUpdateException e = new DaoUpdateException("该用户不存在");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 证书认证审核
	 * @see com.ax.dao.user.UserDao#auditQualification(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param qulificationId
	 */
	@Override
	public void auditQualification(int idfc) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle
					.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#auditQualification(int qulificationId)");
		}
		Identification iden = (Identification) session.load(Identification.class, idfc);
		iden.setState(1);

	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#auditQualification(java.util.List)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param ids
	 */
	@Override
	public void auditQualification(List<String> ids) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle
					.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#auditQualification(int qulificationId)");
		}
		for (int i = 0; i < ids.size(); i++) {
			int id = Integer.parseInt(ids.get(i));
			Identification iden = (Identification) session.load(Identification.class, id);
			iden.setState(1);
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#getIdentificationInfo(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @return
	 */
	@Override
	public IdentificationInfo getIdentificationInfo(int id) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#getIdentificationInfo(int id)");
		}
		return (IdentificationInfo) session.load(IdentificationInfo.class, id);
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#setInfo(int, java.lang.String, java.lang.String, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param nicName
	 * @param sex
	 * @param pic
	 */
	@Override
	public void setInfo(int id, String nicName, String sex, String pic) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e,
					"com.ax.dao.user.impl.UserDaoImpl#setInfo(int id, String nicName, String sex, String pic)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null) {
			user.setNicName(nicName);
			user.setGender(sex);
			user.setPic(pic);
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#find(com.ax.bean.Page, int, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param page
	 * @param type
	 * @param idfc
	 * @return
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Page<Users> find(Page<Users> page, int type, int idfc) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e,
					"com.ax.dao.user.impl.UserDaoImpl#setInfo(int id, String nicName, String sex, String pic)");
		}
		String hql = "from Users where type=? and idfc=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, type);
		query.setParameter(1, idfc);
		if (page.getStart() > 0 && page.getMax() > 0) {
			query.setFirstResult(page.getStart());
			query.setMaxResults(page.getMax());
		}
		page.setRows(query.list());
		return page;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#searchTeacher(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param name
	 * @return
	 * @throws InterruptedException 
	 */
	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public Page<Users> searchTeacher(Page<Users> page, String name) throws InterruptedException {
		session = sessionFactory.getCurrentSession();
		if (session == null || session.isConnected() == false) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#save(T entity)");
		}
		//使用Hibernate Session初始化索引
		FullTextSession fullTextSession = Search.getFullTextSession(session);
		fullTextSession.createIndexer().startAndWait();
		SearchFactory sfc = fullTextSession.getSearchFactory();
		QueryBuilder qb = sfc.buildQueryBuilder().forEntity(Users.class).get();
		org.apache.lucene.search.Query query = qb.keyword().onFields("name").matching(name).createQuery();
		org.hibernate.Query hibQuery = fullTextSession.createFullTextQuery(query, Users.class);
		if (page.getStart() >= 0 && page.getMax() > 0) {
			hibQuery.setFirstResult(page.getStart());
			hibQuery.setMaxResults(page.getMax());
		}
		List<Users> result = hibQuery.list();
		page.setRows(result);
		return page;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#findByNicName(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param nicname
	 * @return
	 * @throws DaoException 
	 * @throws MethodParamException 
	 */
	@Override
	public Users findByNicName(String nicname) throws DaoException, MethodParamException {
		getSession();
		Users user = null;
		if(nicname != null){
			String hql = "from Users where nicName=?";
			Query query = session.createQuery(hql);
			query.setParameter(0, nicname);
			user = (Users)query.uniqueResult();
		}else{
			throw new MethodParamException("传入的参数有误");
		}
		return user;
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 获取数据库的会话信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @throws DaoException
	 */
	public void getSession() throws DaoException{
		session = sessionFactory.getCurrentSession();
		if(session == null){
			session = sessionFactory.openSession();
		}
		if(session == null){
			throw new DaoException("没有合适的Session");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.user.UserDao#idfcPerson(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param id
	 * @param pic
	 */
	@Override
	public void idfcPerson(int id, String pic) {
		session = sessionFactory.getCurrentSession();
		if (session == null) {
			session = sessionFactory.openSession();
		}
		if (session == null) {
			DaoUpdateException e = new DaoUpdateException("没有找到合适的Session");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		Users user = (Users) session.load(Users.class, id);
		if (user != null && pic != null) {
			Identification idfc = new Identification();
			Qualification quli = new Qualification();
			idfc.setState(0);
			idfc.setType(1);
			//quli.setCreateTime(new Date());
			quli.setName("身份认证");
			quli.setPic(pic);
			idfc.setUserid(id);
			idfc.setQulification(quli);
			session.save(idfc);
			session.save(quli);
		} else {
			DaoUpdateException e = new DaoUpdateException("该用户不存在");
			ExceptionHandle.throwException(e, "com.ax.dao.user.impl.UserDaoImpl#bindQQ(int id,String qq)");
		}
		
	}

}
