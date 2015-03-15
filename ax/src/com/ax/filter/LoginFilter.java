/*
 * Title:        爱学圈服务器 2015年3月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月1日
 */
package com.ax.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * (一句话功能简述)
 * 系统权限的粗粒度控制
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月1日
 */
public class LoginFilter implements Filter{

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 销毁方法
	 * @see javax.servlet.Filter#destroy()
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月1日
	 */
	@Override
	public void destroy() {
		
		
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月1日
	 * @param req    请求对象
	 * @param resp   响应对象
	 * @param chain  处理链
	 * @throws IOException
	 * @throws ServletException
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException,
			ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		HttpServletResponse rep = (HttpServletResponse)resp;
		String user = request.getSession().getAttribute("user").toString();
		if(user == null){
			//用户没有登录，重定向到登录页面
			rep.sendRedirect("WEB-INF/manager/user/login.jsp");
		}else{
			//用户已经登录，转向首页
			rep.sendRedirect("WEB-INF/manager/main.jsp");
		}
	}

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * 初始化方法
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月1日
	 * @param config
	 * @throws ServletException
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		
		
	}

}
