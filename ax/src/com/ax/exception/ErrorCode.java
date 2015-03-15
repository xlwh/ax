/*
 * Title:        爱学圈服务器 2015年1月22日
 * Description:  错误码
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月22日
 */
package com.ax.exception;

/**
 * 常见错误码
 * 定义错误码
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月22日
 */
public class ErrorCode {
	/**数据库异常**/
	public static int DAO_EXCEPTION = 701;
	/**数据库查询异常**/
	public static int DAO_INSERT_EXCEPTION = 702;
	/**执行数据库删除异常**/
	public static int DAO_DELETE_EXCEPTION = 703;
	/**执行数据库更新异常**/
	public static int DAO_UPDATE_EXCEPTION = 704;
	/**数据库查询异常**/
	public static int DAO_QUERY_EXCEPTION = 705;
	/**服务层异常**/
	public static int SERVICE_EXCEPTION = 706;
	/**请求层异常**/
	public static int ACTION_EXCEPTION = 707;
	/**数据异常**/
	public static int DATA_EXCEPTION = 708;
	/**空指针异常**/
	public static int NULL_POINT_EXCEPTION = 709;
	/**ACTION层传参异常**/
	public static int ACTION_PARAM_EXCEPTION = 800;
	/**方法传参异常**/
	public static int METHOD_PARAM_EXCEPTION = 801;
	/**找不到请求内容异常**/
	public static int NOT_FOUND = 802;
	/**禁止访问异常**/
	public static int FORBIND = 803;
	/**没有访问权限异常**/
	public static int NOT_ALLOW = 804;
	/**超时异常**/
	public static int OUT_TIME = 805;
	/**基本异常**/
	public static int BASE_EXCEPTION = 806;
	/**
	 * 
	 * 根据异常寻找异常原因
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param e      异常类
	 * @return       异常信息
	 */
	public static String getMessageByException(Exception e){
		String error = "异常信息未知";
		
		if(e instanceof DaoException){
			error = "数据库层执行异常";
		}
		if(e instanceof DaoInsertException ){
			error = "执行数据库数据插入出错";
		}
		if(e instanceof DaoDeleteException){
			error = "执行数据库数据删除异常";
		}
		if(e instanceof DaoUpdateException){
			error = "执行数据库更新异常";
		}
		if(e instanceof DaoQueryException){
			error = "执行数据库查询异常";
		}
		if(e instanceof ActionException){
			error = "执行Action时出错";
		}
		if(e instanceof ActionParamException){
			error = "请求参数错误";
		}
		if(e instanceof BaseException){
			error = "基本异常";
		}
		if( e instanceof DataException){
			error = "数据异常";
		}
		if( e instanceof ForbindException){
			error = "禁止访问";
		}
		if(e instanceof MethodParamException){
			error = "方法传参异常";
		}
		if( e instanceof NotAllowException){
			error = "不允许访问";
		}
		if(e instanceof NotFoundException){
			error = "找不到请求内容";
		}
		if(e instanceof NullPointException){
			error = "空指针异常";
		}
		if( e instanceof OutTimeException){
			error = "超时异常";
		}
		if(e instanceof ServiceException){
			error = "服务层异常";
		}
		return error;
	}
	
	/**
	 * 
	 * 根据异常寻找错误码
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param e      异常
	 * @return       错误码
	 */
	public static int getCodeByException(Exception e){
		int code = 806;
		if(e instanceof DaoException){
			code = 701;
		}
		if(e instanceof DaoInsertException ){
			code = 702;
		}
		if(e instanceof DaoDeleteException){
			code = 703;
		}
		if(e instanceof DaoUpdateException){
			code = 704;
		}
		if(e instanceof DaoQueryException){
			code = 705;
		}
		if(e instanceof ActionException){
			code = 707;
		}
		if(e instanceof ActionParamException){
			code = 800;
		}
		if(e instanceof BaseException){
			code = 806;
		}
		if( e instanceof DataException){
			code = 708;
		}
		if( e instanceof ForbindException){
			code = 803;
		}
		if(e instanceof MethodParamException){
			code = 801;
		}
		if( e instanceof NotAllowException){
			code = 804;
		}
		if(e instanceof NotFoundException){
			code = 802;
		}
		if(e instanceof NullPointException){
			code = 709;
		}
		if( e instanceof OutTimeException){
			code = 805;
		}
		if(e instanceof ServiceException){
			code = 706;
		}
		return code;
	}
	
	/**
	 * 
	 * 根据错误码寻找异常
	 * (功能详细描述)
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月22日
	 * @param code   错误码
	 * @return       异常
	 */
	public static Exception getExceptionByCode(int code){
		return null;
	}
	
}
