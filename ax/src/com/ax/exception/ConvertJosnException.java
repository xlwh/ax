/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.exception;

/**
 * (一句话功能简述)
 * JSON数据转换异常
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */
public class ConvertJosnException extends Exception{

	/**
	 * (域的意义,目的,功能)
	 */
	private static final long serialVersionUID = 1L;
	public ConvertJosnException(){
		super();
	}
	
	public ConvertJosnException(String error){
		super(error);
	}

}
