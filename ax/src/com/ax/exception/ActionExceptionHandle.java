/*
 * Title:        爱学圈服务器 2015年1月31日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月31日
 */
package com.ax.exception;

import javax.servlet.http.HttpServletResponse;

import com.ax.action.ActionResult;

/**
 *Action对捕获的异常进行统一的处理
 * 从请求中获取响应流，输出错误响应信息
 * 根据捕获到的异常，自动判断异常类型，
 * 获取异常信息，转换成为JSON数据输出
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月31日
 */
public class ActionExceptionHandle {
	/**
	 * 
	 * (一句话功能简述)
	 * 处理异常信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月31日
	 * @param e
	 * @param resp
	 */
	public static void handle(Exception e,HttpServletResponse resp){
		int code = ErrorCode.getCodeByException(e);
		String info = ErrorCode.getMessageByException(e);
		ActionResult action = new ActionResult();
		action.setResp(resp);
		action.setInfo(info);
		action.setState(code);
		action.sendNull();
	}
}
