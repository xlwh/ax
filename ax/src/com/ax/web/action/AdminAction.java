package com.ax.web.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.web.service.user.AdminService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("struts-default")
@Namespace("/web")
public class AdminAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private AdminService adminService;
	private String phone;
	private String password;
	private String info;
	//Struts2中Map类型的session
	private Map<String, Object> session;
	//接收客户端传来的验证码
	private String securityCode;

	@Action(value = "login", results = { @Result(name = "success",location = "/manager/main.jsp",type="redirect"),
			@Result(name = "input",type="redirect",location = "/login.jsp") })
	public String login() {
		System.out.println("账号验证");
		/*String serverCode = (String) session.get("SESSION_SECURITY_CODE");
		System.out.println("\\\\\\\\\\\\\\\\"+serverCode);
		if (!serverCode.equals(securityCode)) {
			info = "验证码错误";
			return INPU
		} else {*/
			int code = adminService.login(getPhone(), getPassword());
			System.out.println(code);
			if (code == 3) {
				this.setInfo("账号和密码正确");
				ServletActionContext.getRequest().getSession().setAttribute("user", phone);
				return SUCCESS;
			} else {
				switch (code) {
				case 0: {
					this.setInfo("登录错误，请重试！");
				}
					;
					break;
				case 1: {
					this.setInfo("账号不存在！");
				}
					;
					break;
				case 2: {
					this.setInfo("密码错误！");
				}
					;
					break;
				default: {
					this.setInfo("登录错误，请重试！");
				}
					;
					break;
				}
				return INPUT;
			}
		//}
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public AdminService getAdminService() {
		return adminService;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}

}
