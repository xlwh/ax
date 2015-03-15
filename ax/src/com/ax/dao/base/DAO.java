package com.ax.dao.base;

import java.io.Serializable;
import java.util.List;

import org.hibernate.LockMode;

import com.ax.bean.Page;
import com.ax.exception.DaoException;

/**
 * 数据库基本操作接口
 * @author zhanghongbin
 *
 * @param <T>
 */

public interface DAO<T> {
	/**
	 * 存储持久化对象
	 * @param entity
	 */
	public void save(T entity) throws DaoException;
	/**
	 * 删除单个实体类对象
	 * @param entity
	 */
	public void remove(T entity) throws DaoException;
	/**
	 * 批量删除
	 * @param entitys
	 */
	public void remove(List<T> entitys) throws DaoException;
	/**
	 * 更新持久化对象
	 * @param entity
	 */
	public void update(T entity) throws DaoException;
	/**
	 * 保存或者更新持久化对象
	 * @param entity
	 */
	public void saveOrUpdate(T entity) throws DaoException;
	/**
	 * 通过ID获取持久化对象
	 * @param type
	 * @param entityID
	 * @return
	 */
	public T findById(Serializable entityID) throws DaoException;
	/**
	 * 获取所有的记录
	 * (一句话功能简述)
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @return
	 * @throws DaoException 
	 */
	public List<T> findAll() throws DaoException;
	/**
	 * 通过HQL语句不分页查找实体类对象
	 * @param hql
	 * @param parameters
	 * @return
	 */
	public List<T> findByHQL(String hql,Object[] parameters) throws DaoException;
	/**
	 * 
	 * (一句话功能简述)
	 * 终止数据库查询操作
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @throws DaoException
	 */
	public void cancleQuery() throws DaoException;
	/**
	 * 
	 * 
	 * 清空session
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @throws DaoException
	 */
	public void clear() throws DaoException;
	/**
	 * 
	 * 从缓存中清除对对象
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param object
	 * @throws DaoException
	 */
	public void evict(Object object) throws DaoException;
	/**
	 * 
	 * 使用延迟加载对象
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param type      对象类型
	 * @param entityID  对象ID
	 * @return           持久化对象
	 * @throws DaoException  
	 */
	public T load(Serializable entityID) throws DaoException;
	/**
	 * 
	 * 启用加锁机制载入持久化对象
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param type
	 * @param entityID
	 * @param mode
	 * @return
	 * @throws DaoException
	 */
	public T load(Serializable entityID,LockMode mode) throws DaoException;
	/**
	 * 
	 * 查询数据库中对应表的总记录数目
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @return
	 */
	public long getSize();
	/**
	 * 
	 * (一句话功能简述)
	 * 不带查询条件的分页查询
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param hql    查询语句
	 * @return        分页的查询结果
	 * @throws DaoException
	 */
	public Page<T> findByPage(Page<T> page,String hql) throws DaoException;
}
