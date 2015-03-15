/*
 * Title:        爱学圈服务器 2015年3月9日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月9日
 */
package com.ax.service.circle;

import java.util.List;

import com.ax.bean.CircleMessage;

/**
 * (一句话功能简述)
 * 学习圈业务逻辑接口
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */
public interface CircleMessageService {
	/**
	 * 
	 *获取附近的学习圈动态
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param lng    经度
	 * @param lat    纬度
	 * @return       学习圈动态消息
	 */
	public List<CircleMessage> getNearby(float lng,float lat);
	/**
	 * 
	 *在学习圈中发表动态信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param lng    经度
	 * @param lat    纬度
	 * @param uid    用户的ID
	 * @param content  动态内容
	 * @param fileNames  上传的图片的名字
	 * @param fileType   上传的图片的文件类型
	 */
	public void write(float lng,float lat,int uid,String content,String[] fileNames,String[] fileType);
	/**
	 * 
	 *获取详细信息
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param id     学习圈动态的ID
	 * @return       学习圈的动态信息
	 */
	public CircleMessage getDetail(String id);
	/**
	 * 
	 * 获取某个用户自己发表的学习圈动态
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年3月9日
	 * @param uid    用户id
	 * @return       学习圈的动态集合
	 */
	public List<CircleMessage> getByUser(int uid);
	
}
