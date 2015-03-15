package com.ax.service.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.lucene.queryparser.classic.ParseException;

import com.ax.bean.Page;
import com.ax.bean.Teacher;
import com.ax.bean.Users;
import com.ax.exception.DaoException;
import com.ax.exception.MethodParamException;
import com.ax.exception.ServiceException;


/**
 * 用户相关的业务逻辑接口
 * @author 张洪斌
 *
 */
public interface UserService {
	
	/**
	 * 用户注册相关的业务逻辑
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone    电话号码
	 * @param password   密码
	 * @throws ServiceException 
	 * @throws DaoException
	 */
	public void register(String phone,String password)throws ServiceException, DaoException;
	/**
	 * 用户登录验证
	 * @param phone
	 * @param password
	 * @return
	 */
	public int checkUser(String phone,String password);
	/**
	 * 验证用户的手机号码是否是本人的
	 * 验证方法：
	 *    在一分钟之内发送六位数的验证码到用户手机
	 *    同时把这条验证码存储到session中（key为手机号码 value为六位数的验证码）
	 *    用户提交表单后和session中存储的value进行比对，如果一致，则返回成功的信息（1）
	 *    如果不匹配，则返回(0)
	 * @param phone
	 * @return
	 */
	public int checkPhone(String phone);
	/**
	 * 验证昵称是否已经被使用
	 * @param name
	 * @return
	 * @throws MethodParamException 
	 * @throws DaoException 
	 */
	public int checkNicName(String name) throws DaoException, MethodParamException;
	
	/**
	 * 绑定QQ号码
	 * @param id
	 * @param qq
	 */
	public void bindingQq(int id,String qq);
	/**
	 * 绑定微信
	 * @param id
	 * @param wexin
	 */
	public void bindingWexin(int id,String wexin);
	/**
	 * 绑定微博账号
	 * @param id
	 * @param webo
	 */
	public void bindingWebo(int id,String webo);
	/**
	 * 生成验证码
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone
	 * @throws ServiceException 
	 */
	public void getCode(String phone,HttpServletRequest req) throws ServiceException;
	/**
	 * 获取所有用户信息
	 * @return 所有用户的信息
	 */
	public List<Users> getAll();
	/**
	 * 
	 * 用户检索
	 * 分类，并且分页的检索用户的信息
	 * type的取值说明：
	 *       1：搜索普通用户
	 *       2：搜索私教
	 *       3：搜索名师
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param keyword   搜索的关键词
	 * @param type      搜索的用户类型
	 * @return          搜索的结果
	 * @throws ParseException 
	 */
	public Page<Teacher> searchUsers(Page<Teacher> page,String keyword,int type) throws ParseException;
	/**
	 * 
	 * 查看某个用户的详细信息
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param id     用户的主键/id
	 * @return       用户信息实体类
	 * @throws DaoException 
	 */
	public Users getDetailById(int id) throws DaoException;
	/**
	 * 
	 * (一句话功能简述)
	 * 检验验证码是不是正确
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone
	 * @param code
	 * @param req
	 * @return
	 */
	public boolean checkCode(String phone,String code,HttpServletRequest req);
	/**
	 * 
	 * 用户的个人信息编辑
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param id
	 * @param nicname
	 * @param gender
	 * @param phone
	 */
	public void editInfo(int id,String nicname,String gender,String pic);
	/**
	 * 
	 * (一句话功能简述)
	 * 获取总记录数目
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	public long getCount();
	/**
	 * 
	 * (一句话功能简述)
	 * 老师详情信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @return       老师的详情
	 */
	public Teacher teacherDetail();
	/**
	 * 
	 * (一句话功能简述)
	 * 用户认证
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param type   认证类型：1：身份认证  2：学历认证  3：职业认证 4：证书认证
	 * @param uid
	 * @param pic
	 * @return
	 */
	public boolean idfcUser(int type,int uid,String pic);
	/**
	 * 
	 * 搜索和筛选搜索结果
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月4日
	 * @return       
	 * @throws DaoException 
	 */
	public List<Users> searchUser(int page,String keyword,String subject,boolean idfc) throws DaoException;
	/**
	 * 
	 * 按照距离等多条件检索老师
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月5日
	 * @param lng       经度
	 * @param lat       纬度
	 * @param keyword    搜索关键词
	 * @param subject    科目
	 * @param idfc       时候否认证
	 * @return           搜索到的结果
	 */
	public List<Users> searchUser(float lng,float lat,int r,String keyword,String subject,boolean idfc);
	
}
