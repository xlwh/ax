/*
 * Title:        爱学圈服务器 2015年3月1日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月1日
 */
package com.ax.filter;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月1日
 */

public class LoginInterceptor extends AbstractInterceptor{

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 覆盖方法/实现方法(选择其一)
	 * (功能详细描述)
	 * @see com.opensymphony.xwork2.interceptor.AbstractInterceptor#intercept(com.opensymphony.xwork2.ActionInvocation)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月1日
	 * @param arg0
	 * @return
	 * @throws Exception
	 */
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		 ActionContext ctx = invocation.getInvocationContext();
		 @SuppressWarnings("rawtypes")
		Map session = ctx.getSession();
		 String user = (String) session.get("user");  
		 if( user != null){
			 return invocation.invoke();
		 }
		 ctx.put("tip", "你还没有登录");  
		 return Action.LOGIN; 
		}

}
