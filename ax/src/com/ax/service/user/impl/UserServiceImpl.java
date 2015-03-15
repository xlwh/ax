package com.ax.service.user.impl;

import java.util.List;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.lucene.queryparser.classic.ParseException;
import org.springframework.stereotype.Service;

import com.ax.bean.Page;
import com.ax.bean.Teacher;
import com.ax.bean.Users;
import com.ax.dao.course.CourseDao;
import com.ax.dao.user.TeacherDao;
import com.ax.dao.user.UserDao;
import com.ax.exception.DaoException;
import com.ax.exception.MethodParamException;
import com.ax.exception.NullPointException;
import com.ax.exception.ServiceException;
import com.ax.service.user.UserService;
import com.ax.utils.SMSUtil;
import com.ax.utils.StudentIdUtil;

@Service
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	@Resource
	private SMSUtil sMSUtil;
	@Resource
	private TeacherDao teacherDao;
	@Resource
	private CourseDao courseDao;
	@Resource
	private StudentIdUtil studentIdUtil;

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 用户注册
	 * @see com.ax.service.user.UserService#register(java.lang.String, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone    注册用的电话号码
	 * @param password   密码
	 * @throws ServiceException  异常信息
	 * @throws DaoException
	 */
	@Override
	public void register(String phone, String password) throws ServiceException, DaoException {
		Users user = new Users();
		//user.setCreateTime(new Date());
		try {
			String studentid = studentIdUtil.getStudentId();
			user.setStudentid(studentid);
		} catch (NullPointException e) {

			e.printStackTrace();
		}
		user.setPhone(phone);
		user.setPassword(password);
		userDao.save(user);
	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 用户的账号和密码验证
	 * @see com.ax.service.user.UserService#checkUser(java.lang.String, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone   电话号码（账号）
	 * @param password  密码
	 * @return         验证的结果0：异常 1：账号不存在 2：密码错误  3：账号和密码正确
	 */
	@Override
	public int checkUser(String phone, String password) {
		Users user = userDao.findByPhone(phone);
		int code = 0;
		if (user != null) {
			if (user.getPassword().equals(password)) {
				//密码正确
				code = user.getId();
			} else {
				//密码错误
				code = -2;
			}
		} else {
			code = -1; //手机号码不存在
		}
		return code;
	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 检验手机号码是不是已经被注册过了
	 * @see com.ax.service.user.UserService#checkPhone(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone   手机号码
	 * @return        检测的结果：-1验证异常  1：已经被注册过 0：该手机号码尚未被注册
	 */
	@Override
	public int checkPhone(String phone) {
		Users user = userDao.findByPhone(phone);
		int code = -1; //验证异常
		if (user != null) {
			code = 1; //该手机号码已经注册
		} else {
			code = 0; //该手机号码没有注册过
		}
		return code;
	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 检查昵称是不是已经有人注册了
	 * @see com.ax.service.user.UserService#checkNicName(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param name   昵称
	 * @return       检查的结果：0：没有注册  1：已经被注册过
	 * @throws DaoException       检测异常
	 * @throws MethodParamException   参数传入有误
	 */
	@Override
	public int checkNicName(String name) throws DaoException, MethodParamException {
		Users user = userDao.findByNicName(name);
		int result = 0;
		if (user != null) {
			result = 1; //已经注册过
		} else {
			result = 0; //没有注册
		}
		return result;
	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 进行QQ账号绑定（需要给邮箱发送验证的）
	 * @see com.ax.service.user.UserService#bindingQq(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param id     要绑定的用户
	 * @param qq      要绑定的QQ号码
	 */
	@Override
	public void bindingQq(int id, String qq) {
		userDao.bindQQ(id, qq);

	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 用户绑定微信
	 * @see com.ax.service.user.UserService#bindingWexin(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param id     要绑定的用户
	 * @param wexin  要绑定的微信号码
	 */
	@Override
	public void bindingWexin(int id, String wexin) {
		userDao.bindWexin(id, wexin);

	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 用户执行微博的绑定
	 * @see com.ax.service.user.UserService#bindingWebo(int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param id     要绑定的用户
	 * @param webo   要绑定的微博账号
	 */
	@Override
	public void bindingWebo(int id, String webo) {
		userDao.bindWebo(id, webo);

	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 生成验证码，并向指定的手机发送验证码
	 * @see com.ax.service.user.UserService#getCode(java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone
	 * @throws ServiceException 
	 */
	@Override
	public void getCode(String phone, HttpServletRequest req) throws ServiceException {
		Random random = new Random();
		int c1 = random.nextInt(10);
		int c2 = random.nextInt(10);
		int c3 = random.nextInt(10);
		int c4 = random.nextInt(10);
		int c5 = random.nextInt(10);
		int c6 = random.nextInt(10);
		String code = "" + c1 + c2 + c3 + c4 + c5 + c6;
		HttpSession session = req.getSession();
		if (session != null) {
			session.setAttribute(phone, code);
			String result = sMSUtil.sendSMS(phone, code);
			System.out.println(result);
		} else {
			throw new ServiceException("写入验证码异常！");
		}

	}

	/**
	 * 
	 * 覆盖方法/实现方法(选择其一)
	 * 获取所有的用户
	 * @see com.ax.service.user.UserService#getAll()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @return       用户列表
	 */
	@Override
	public List<Users> getAll() {
		List<Users> users = null;
		try {
			userDao.findByHQL("FROM Users", null);
		} catch (DaoException e) {

			e.printStackTrace();
		}
		return users;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.UserService#searchUsers(java.lang.String, int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param keyword
	 * @param type
	 * @return
	 * @throws ParseException 
	 */
	@Override
	public Page<Teacher> searchUsers(Page<Teacher> user, String keyword, int type) throws ParseException {
		teacherDao.search(user, keyword);
		return null;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.UserService#getDetailById(int)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param id
	 * @return
	 * @throws DaoException 
	 */
	@Override
	public Users getDetailById(int id) throws DaoException {
		Users user = userDao.findById(id);
		return user;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.UserService#checkCode(java.lang.String, java.lang.String, javax.servlet.http.HttpServletRequest)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月27日
	 * @param phone
	 * @param code
	 * @param req
	 * @return
	 */
	@Override
	public boolean checkCode(String phone, String code, HttpServletRequest req) {
		boolean result = false;
		if (phone != null && code != null && req != null) {
			HttpSession session = req.getSession();
			String c = session.getAttribute(phone).toString();
			if (c != null) {
				if (c.equals(code)) {
					result = true;
				}
			} else {
				result = false;
			}
		} else {
			result = false;
		}
		return result;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.UserService#editInfo(int, java.lang.String, java.lang.String, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param id
	 * @param nicname
	 * @param gender
	 * @param phone
	 */
	@Override
	public void editInfo(int id, String nicname, String gender, String pic) {
		userDao.setInfo(id, nicname, gender, pic);

	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.UserService#getCount()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	@Override
	public long getCount() {

		return userDao.getSize();
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.UserService#teacherDetail()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @return
	 */
	@Override
	public Teacher teacherDetail() {

		return null;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 用户认证
	 * @see com.ax.service.user.UserService#idfcUser(int, int, java.lang.String)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 * @param type   认证类型
	 * @param uid    认证者
	 * @param pic    上传的图片
	 * @return        认证的结果
	 */
	@Override
	public boolean idfcUser(int type, int uid, String pic) {
		if (type == 1) {
			//身份认证 
			userDao.idfcEducation(uid, pic);
		}

		if (type == 2) {
			//学历认证
			userDao.idfcEducation(uid, pic);
		}

		if (type == 3) {
			//职业认证
			userDao.idfcJob(uid, pic);
		}

		if (type == 4) {
			//证书认证
			userDao.idfcQualification(uid, pic);
		}
		return true;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.ax.service.user.UserService#searchUser(int, java.lang.String, boolean)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月4日
	 * @param page   页码
	 * @param subject 科目名字
	 * @param idfc    是否认证
	 * @return        搜索结果
	 * @throws DaoException 
	 */
	@Override
	public List<Users> searchUser(int page, String keyword,String subject, boolean idfc) throws DaoException {
	     List<Users> result = null;
	     /**
	      * 下面有多多种情况进行处理，每种情况会生成不一样的HQL语句
	      *  keyword,subject,infc三个条件.....
	      * 1. ,,,,,
	      * 2.keyword,
	      * 3. keyword,subject,
	      * 4.keyword,idfc
	      * 5.subject,idfc
	      * 6.keyword,subject,idfc
	      */
		String hql = buildHql(keyword,subject,idfc);
		result = userDao.findByHQL(hql, null);
		return result;
	}
	
	private String buildHql(String keyword,String subject, boolean idfc){
		String hql = null;
		if(keyword==null && subject == null && idfc == false){
			//随便选几条结果就行.....
			hql = "From Users";
		}
		if(keyword != null && subject==null && idfc ==false){
			hql = "from Users where name like '%"+keyword+"%'";
		}
		
		if(keyword != null && subject !=null &&idfc==false){
			hql = "from Users where name like '%"+keyword+"%' and subject="+subject+"";
		}
		
		if(keyword != null && subject ==null && idfc == true){
			hql = "from Users where name like '%"+keyword+"%' and idfc=1";
		}
		
		if(keyword == null && subject != null && idfc == true){
			hql = "from Users where subject="+subject+" and idfc=1";
		}
		
		if(keyword !=null && subject !=null && idfc == true){
			hql = "from Users where name like '%"+keyword+"%' and subject="+subject+" and idfc=1";
		}
		
		
		return hql;
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 按照距离以及其他的关键词检索老师
	 * @see com.ax.service.user.UserService#searchUser(float, float, int, java.lang.String, java.lang.String, boolean)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月5日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param r      距离
	 * @param keyword  关键词
	 * @param subject   科目
	 * @param idfc      是否认证
	 * @return          搜索到的结果
	 */
	@Override
	public List<Users> searchUser(float lng, float lat, int r, String keyword, String subject, boolean idfc) {
		List<Users> result = null;
		return result;
	}

}
