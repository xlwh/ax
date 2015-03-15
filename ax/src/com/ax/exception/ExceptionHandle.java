package com.ax.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * 
 * 异常处理
 * 主要功能是捕获异常，打印并且记录在日志中
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月22日
 */
public class ExceptionHandle {
	private static Log log = LogFactory.getLog(ExceptionHandle.class);

	/**
	 * 
	 * 基本异常信息处理
	 * 
	 * @author       				张洪斌  1079039435@qq.com
	 * @see          				相关函数,对于重要的函数建议注释
	 * @since        				爱学圈服务器, 2015年1月22日
	 * @param e      				异常
	 * @param errorCode   			抛出的异常信息码
	 * @param classAndMethod  		出错的类和方法
	 */
	public static void throwException(Exception e, String classAndMethod) {
		if (e != null && classAndMethod != null) {
			int code = ErrorCode.getCodeByException(e);
			String error = ErrorCode.getMessageByException(e);
			log.error(code + ":" + classAndMethod + ":" + error + "");
			e.printStackTrace();
		} else if (e != null && classAndMethod == null) {
			int code = ErrorCode.getCodeByException(e);
			String error = ErrorCode.getMessageByException(e);
			log.error(code + ":" + error);
			e.printStackTrace();
		} else {
			int code = 806;
			String error = "异常未知";
			log.error(code + ":" + error);
		}

	}
}
