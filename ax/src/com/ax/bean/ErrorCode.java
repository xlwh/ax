package com.ax.bean;

/**
 * 错误码定义
 * @author Administrator
 *
 */
public class ErrorCode {
	/**请求地址未找到**/
	public static int NOT_FOUND = 400;
	/**禁止访问**/
	public static int FORBID_VISIT = 403;
	/**不允许访问**/
	public static int NOT_ALLOWED = 405;
	/**数据库访问错误**/
	public static int DB_ERROR = 701;
	/**其他错误**/
	public static int ERR = 702;
}
