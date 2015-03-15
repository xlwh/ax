package com.ax.dao.base.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import com.ax.bean.Page;
import com.ax.dao.base.DAO;
import com.ax.exception.DaoDeleteException;
import com.ax.exception.DaoException;
import com.ax.exception.DaoInsertException;
import com.ax.exception.DaoQueryException;
import com.ax.exception.DaoUpdateException;
import com.ax.exception.ExceptionHandle;
import com.ax.utils.GenericsUtils;

@Transactional
public class DaoSupport<T> implements DAO<T> {
	@Resource
	protected SessionFactory sessionFactory;
	protected Session session;
	@SuppressWarnings({ "unchecked" })
	protected Class<T> entityClass = GenericsUtils.getSuperClassGenricType(this.getClass());
	
	
	@Override
	public void save(T entity)  throws DaoException{
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#save(T entity)");
		}
		session.save(entity);
	}
	
	@Transactional(rollbackFor=DaoDeleteException.class)
	@Override
	public void remove(T entity) throws DaoException{
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#remove(T entity)");
		}
		session.delete(entity);
		
	}
	
	@Transactional(rollbackFor=DaoDeleteException.class)
	@Override
	public void remove(List<T> entitys) {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#remove(List<T> entitys)");
		}
		
		for(int i=0;i<entitys.size();i++){
			T entity = entitys.get(i);
			session.save(entity);
			
		}
		
	}

	@Transactional(rollbackFor=DaoUpdateException.class)
	@Override
	public void update(T entity) throws DaoException{
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#update(T entity)");
		}
		session.update(entity);
		
	}

	@Transactional(rollbackFor=DaoUpdateException.class)
	@Override
	public void saveOrUpdate(T entity) {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		session.saveOrUpdate(entity);
		
	}

	@Transactional(rollbackFor=DaoQueryException.class,readOnly=true)
	@SuppressWarnings("unchecked")
	@Override
	public T findById(Serializable entityID) {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#findById(Serializable entityID)");
		}
		//System.out.println("步骤1正确执行");
		return (T) session.get(entityClass, entityID);
	}

	@Transactional(rollbackFor=DaoQueryException.class,readOnly=true)
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByHQL(String hql, Object[] parameters) throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#findByHQL(String hql, Object[] parameters)");
		}
		Query qy = null;
		if(parameters == null){
			qy = session.createQuery(hql);
			return qy.list();
		}else{
			qy = session.createQuery(hql);
			Query query = buildQuery(qy,parameters);
			return query.list();
		}
		
	}
	
	
	public Query buildQuery(Query query,Object[] parameters) throws DaoException{
		if(query !=null && parameters.length>0)
		for(int i=0;i<parameters.length;i++){
			query.setParameter(i, parameters[i]);
			
		}else{
			throw new DaoException("HQL语句错误");
		}
		return query;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 放弃当前正在执行的数据库操作
	 * @see com.ax.dao.base.DAO#cancleQuery()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @throws DaoException
	 */
	@Override
	public void cancleQuery() throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#cancleQuery()");
		}
		session.cancelQuery();
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.base.DAO#clear()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @throws DaoException
	 */
	@Override
	public void clear() throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#clear()");
		}
		session.clear();
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 清除数据库查询缓存当中的对象
	 * @see com.ax.dao.base.DAO#evict(java.lang.Object)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param object
	 * @throws DaoException
	 */
	@Override
	public void evict(Object object) throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#evict(Object object)");
		}
		session.evict(object);
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 使用懒加载载入对象
	 * @see com.ax.dao.base.DAO#load(java.lang.Class, java.io.Serializable)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param type
	 * @param entityID
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings({ "unchecked" })
	@Override
	public T load(Serializable entityID) throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#load(Class type, Serializable entityID)");
		}
		T entity = (T) session.load(entityClass, entityID);
		return entity;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.base.DAO#load(java.lang.Class, java.io.Serializable, org.hibernate.LockMode)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param type
	 * @param entityID
	 * @param mode
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("deprecation")
	@Override
	public T load(Serializable entityID, LockMode mode) throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#load(Serializable entityID, LockMode mode)");
		}
		@SuppressWarnings("unchecked")
		T entity = (T) session.load(entityClass,entityID, mode);;
		return entity;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.base.DAO#getSize()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @return
	 */
	@Transactional
	@Override
	public long getSize() {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#load(Serializable entityID, LockMode mode)");
		}
		String classname = getEntityName(entityClass);
		String hql = "select count(*) from "+classname;
		long count=(long)session.createQuery(hql).uniqueResult();;
		return count;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.base.DAO#findByPage(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param hql
	 * @return
	 * @throws DaoException
	 */
	@SuppressWarnings("unused")
	@Override
	public Page<T> findByPage(Page<T> page,String hql) throws DaoException {
		session = sessionFactory.getCurrentSession();
		if( session == null || session.isConnected() == false){
			session = sessionFactory.openSession();
		}
		if(session ==null){
			DaoInsertException e = new DaoInsertException("没有获取到合适的session");
			ExceptionHandle.throwException(e, "com.ax.dao.base.impl#findByPage(Page<T> page,String hql)");
		}
		Query query = session.createQuery(hql);
		
		
		return null;
	}
	
	/**
	 * 获取实体的名称
	 * @param <E>
	 * @param clazz 实体类
	 * @return
	 */
	@SuppressWarnings("hiding")
	protected  <T> String getEntityName(Class<T> clazz){
		String entityname = clazz.getSimpleName();
		System.out.println(entityname);
		Entity entity = clazz.getAnnotation(Entity.class);
		if(entity.name()!=null && !"".equals(entity.name())){
			entityname = entity.name();
		}
		return entityname;
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 获取数据库当前绘画
	 * @author       张洪斌  1079039435@qq.com
	 * @throws DaoException 
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 */
	public void getSession() throws DaoException{
		session = sessionFactory.getCurrentSession();
		if(session == null){
			session = sessionFactory.openSession();
		}
		if(session == null){
			throw new DaoException("没有找到合适的Session");
		}
		
		if(session != null){
			if(session.isOpen() == false){
				session = sessionFactory.openSession();
			}
		}
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.dao.base.DAO#findAll()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @return
	 * @throws DaoException 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() throws DaoException {
		String hql = "from "+entityClass.getSimpleName();
		getSession();
		Query query = session.createQuery(hql);
		return query.list();
	}
	
}
