package com.ax.dao.user;

import java.util.List;

import com.ax.bean.IdentificationInfo;
import com.ax.bean.Page;
import com.ax.bean.Users;
import com.ax.dao.base.DAO;
import com.ax.exception.DaoException;
import com.ax.exception.MethodParamException;

public interface UserDao extends DAO<Users>{
	/**
	 * 通过手机号码查找用户信息
	 * @param phone
	 * @return
	 */
	public Users findByPhone(String phone);
	/**
	 * 
	 * 分页列出所有的用户（老师）
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @return
	 */
	public Page<Users> findAll(Page<Users> page);
	/**
	 * 
	 * 绑定（设置）QQ账号
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param qq
	 */
	public void bindQQ(int id,String qq);
	/**
	 * 
	 * 绑定（设置）微信账号
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param wexin
	 */
	public void bindWexin(int id,String wexin);
	/**
	 * 
	 * 绑定（设置）微博账号
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id
	 * @param webo
	 */
	public void bindWebo(int id,String webo);
	
	/**
	 *身份认证 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param id    被认证者
	 * @param pic    证件照片
	 */
	public void idfcPerson(int id,String pic);
	/**
	 * 
	 * 学历认证
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 */
	public void idfcEducation(int id,String pic);
	/**
	 * 
	 * 职业认证
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id     认证者
	 * @param pic    认证图片
	 */
	public void idfcJob(int id,String pic);
	/**
	 * 
	 * 证书认证
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id     认证者id
	 * @param pic    认证图片
	 */
	public void idfcQualification(int id,String pic);
	/**
	 * 
	 * 证书审核
	 * 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param qulificationId
	 */
	public void auditQualification(int qulificationId);
	/**
	 * 
	 * 证书批量审核
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param ids
	 */
	public void auditQualification(List<String> ids);
	/**
	 * 
	 * 查询一个用户的认证情况
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id     用户id
	 * @return       认证情况
	 */
	public IdentificationInfo getIdentificationInfo(int id);
	/**
	 * 
	 * 设置个人的昵称，性别，姓名，头像照片
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param id       要设置的学生
	 * @param nicName   昵称
	 * @param sex      性别
	 * @param pic      头像
	 */
	public void setInfo(int id,String nicName,String sex,String pic);
	/**
	 * 
	 * 根据认证情况和老师类型，分页列出老师
	 * 
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param page
	 * @param type
	 * @param idfc
	 * @return
	 */
	public Page<Users> find(Page<Users> page,int type,int idfc);
	/**
	 * 
	 * 根据老师名字分页检索老师
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月23日
	 * @param name
	 * @return
	 */
	public Page<Users> searchTeacher(Page<Users> page,String name)throws InterruptedException;
	/**
	 * 
	 * (一句话功能简述)
	 * 通过用户的昵称检索到用户的信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param nicname   要进行查找的昵称
	 * @return          查询的结果
	 * @throws DaoException   数据库操作异常
	 * @throws MethodParamException  传参异常
	 */
	public Users findByNicName(String nicname) throws DaoException, MethodParamException;
	
}
