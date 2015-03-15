package com.ax.app.action.user;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.action.ActionResult;
import com.ax.action.BaseAction;
import com.ax.bean.Page;
import com.ax.bean.Teacher;
import com.ax.bean.Users;
import com.ax.exception.ActionException;
import com.ax.exception.ActionExceptionHandle;
import com.ax.exception.DaoException;
import com.ax.exception.ServiceException;
import com.ax.service.user.TeacherService;
import com.ax.service.user.UserService;
import com.ax.utils.PageUtil;

@Controller
@ParentPackage("json-default")
@Namespace("/user")
public class UserAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Resource
	private UserService userService;
	@Resource
	private TeacherService teacherService;
	private String phone;
	private String password;
	private String keyword;
	private int type;
	private int id = -1;
	private String cod;
	/**当前页码**/
	private int page;

	/**
	 * 用户登录系统
	 * @return
	 */
	@Action(value = "login", results = { @Result(type = "json") })
	public void login() {
		JSONObject obj = new JSONObject();
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Content-Type", "text/html;charset=utf8");
		int code = userService.checkUser(phone, password);
		state = 200;
		info = "success";
		obj.put("state", state);
		obj.put("info", info);
		obj.put("result", code);
		try {
			Writer out = resp.getWriter();
			out.write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 新用户注册
	 * @return
	 */
	@Action(value = "register", results = { @Result(type = "json") })
	public void register() {
		state = 200;
		info = "success";
		try {
			try {
				userService.register(getPhone(), getPassword());
			} catch (DaoException e) {
				state = 201;
				info = "注册失败";
				e.printStackTrace();
			}

		} catch (ServiceException e) {
			state = 201;
			info = "注册失败";
			e.printStackTrace();
		}
		JSONObject obj = new JSONObject();
		obj.put("state", state);
		obj.put("info", info);
		obj.put("xuehao", "ax111111");
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("utf-8");
		resp.setHeader("Content-Type", "text/html;charset=utf8");
		try {
			Writer out = resp.getWriter();
			out.write(obj.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 检查手机号码是不是已经注册过
	 * @return
	 */
	@Action(value = "check", results = { @Result(type = "json") })
	public String check() {
		int code = userService.checkPhone(getPhone());
		state = 200;
		info = "success";
		result = new HashMap<String, Object>();
		result.put("state", state);
		result.put("info", info);
		result.put("result", code);
		return SUCCESS;
	}

	/**
	 * 
	 * (一句话功能简述)
	 * 搜索一个用户
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	@Action(value = "search", results = { @Result(type = "json") })
	public void search() {
		JSONObject obj = new JSONObject();
		JSONArray array = new JSONArray();
		String result = "null";
		int state = 200;
		String info = "success";
		//一下是假数据//
		PageUtil<Teacher> pageUtil = new PageUtil<Teacher>();
		Page<Teacher> page = pageUtil.newPage(10, (int) userService.getCount());
		try {
			userService.searchUsers(page, info, state);
		} catch (ParseException e1) {

			e1.printStackTrace();
		}

		for (int i = 0; i < 10; i++) {
			SearchResult r = new SearchResult();
			r.setId(i);
			r.setExp(24.0f);
			r.setIdfc(1);
			r.setPic("p1.jpg");
			r.setType(3);
			array.add(r);
		}
		//假数据结束，以下是构建返回结果数据
		obj.put("state", state);
		obj.put("info", info);
		obj.put("result", array);
		result = obj.toString();

		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "text/html;charset=utf8");
		try {
			Writer out = resp.getWriter();
			out.write(result);
		} catch (IOException e) {
			//返回结果为空....
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * (一句话功能简述)
	 * 查看用户详情信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	@Action(value = "detail", results = { @Result(type = "json") })
	public void detail() {
		ActionResult action = new ActionResult();
		System.out.println("获取数据");
		action.setResp(ServletActionContext.getResponse());
		try {
			TeacherDetailResult res = teacherService.getDetailById(getId());
			String json = action.toJson(res);
			try {
				action.sendResponse(json);
			} catch (ActionException e) {
				e.printStackTrace();
				action.sendNull();
			} catch (IOException e) {
				e.printStackTrace();
				action.sendNull();
			}
		} catch (DaoException e) {
			e.printStackTrace();
			action.sendNull();
		}
	}

	/**
	 *获取验证码 
	 */
	@Action(value = "getcode", results = { @Result(type = "json") })
	public void getCode() {
		int state = 200;
		String info = "success";
		JSONObject obj = new JSONObject();
		try {
			userService.getCode(getPhone(), ServletActionContext.getRequest());
		} catch (ServiceException e) {
			state = 201;
			info = "error";
			e.printStackTrace();
		}
		obj.put("state", state);
		obj.put("info", info);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "text/html;charset=utf8");
		try {
			Writer out = resp.getWriter();
			out.write(obj.toString());
		} catch (IOException e) {
			//返回结果为空....
			e.printStackTrace();
		}

	}

	/**
	 * 验证码检查，检查验证码是否正确
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	@Action(value = "checkcode", results = { @Result(type = "json") })
	public void checkCode() {
		int state = 200;
		String info = "success";
		int result = 0;
		HttpSession session = ServletActionContext.getRequest().getSession();
		String cd = session.getAttribute(getPhone()).toString();
		if (cd == null) {
			//验证码并未发送成功，检查失败
			result = 0;
		} else {
			if (cd.equals(this.getCod())) {
				//验证成功
				result = 1;
			}
		}
		JSONObject obj = new JSONObject();
		obj.put("state", state);
		obj.put("info", info);
		obj.put("result", result);

		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "text/html;charset=utf8");
		try {
			Writer out = resp.getWriter();
			out.write(obj.toString());
		} catch (IOException e) {
			//返回结果为空....
			e.printStackTrace();
		}

	}
	
	/**
	 * 
	 * 获取用户的简要信息
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年2月1日
	 */
	@Action(value = "simpinfo", results = { @Result(type = "json") })
	public void getSimpInfo(){
		int  userid = getId();
		ActionResult res = new ActionResult();
		res.setResp(ServletActionContext.getResponse());
		if(userid == -1){
			res.setInfo("参数错误");
			res.setState(201);
			res.sendNull();
		}else{
			try {
				Users user = userService.getDetailById(userid);
				SimpResult sm = new SimpResult();
				sm.setId(user.getId());
				sm.setName(user.getName());
				sm.setStudentid(user.getStudentid());
				sm.setPic(user.getPic());
				sm.setType(user.getType());
				sm.setGender(user.getGender());
				try {
					res.sendResponse(res.toJson(sm));
				} catch (ActionException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				} catch (IOException e) {
					ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
					e.printStackTrace();
				}
			} catch (DaoException e) {
				ActionExceptionHandle.handle(e, ServletActionContext.getResponse());
				e.printStackTrace();
			}
		}
		
	}
	
   

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getCod() {
		return cod;
	}

}
