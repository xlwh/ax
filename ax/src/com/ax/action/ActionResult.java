/*
 * Title:        爱学圈服务器 2015年1月28日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月28日
 */
package com.ax.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Component;

import com.ax.exception.ActionException;
import com.ax.exception.ConvertJosnException;

/**
 * (一句话功能简述)
 * 请求响应数据的发送
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月28日
 */
@Component
public class ActionResult{
	private int state = 200;
	private String info = "success";
	private HttpServletRequest req;
	private HttpServletResponse resp;
	private PrintWriter out;
	public ActionResult(){
		
	}
	/**
	 * 
	 * 构造函数
	 * (一句话功能简述)
	 * 传入请求和响应对象
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param req    请求
	 * @param resp   响应
	 */
	public ActionResult(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 把键值对转换为
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param value
	 * @throws ConvertJosnException 
	 */
	public String toJson(String keys[],Map<String,Object> kvs) throws ConvertJosnException{
		String result = null;
		int ksize = keys.length;
		int kvsize = kvs.size();
		if(ksize>0 && kvsize>0){
			if(ksize == kvsize){
				JSONObject obj = new JSONObject();
				obj.put("state", getState());
				obj.put("info", info);
				for(String k : keys){
					Object value = kvs.get(k);
					obj.put(k, value);
				}
				result = obj.toString();
			}else{
				throw new ConvertJosnException("键列表和键值列表参数不匹配异常");
			}
		}else{
			//传入的键值对为空。。异常
			throw new ConvertJosnException("传入的键值对为空。。异常");
		}
	   return result;
	}
	
	/**
	 *把一个对象数组转换为JSON数据 
     * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param objects   JSON对象数组
	 * @return         转换成功的json数据
	 */
	
	public String toJson(List<Object> objects){
		String result = null;
		JSONObject obj = new JSONObject();
		obj.put("state", getState());
		obj.put("info", getInfo());
		JSONArray array = new JSONArray();
		for(Object entity : objects){
			array.add(entity);
		}
		obj.put("rows", array);
		result = obj.toString();
		return result;
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 把一个对象装换为JSON
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月29日
	 * @param obj
	 * @return
	 */
	public String toJson(Object obj){
		String res = null;
		JSONObject ob1 = new JSONObject();
		JSONObject ob2 = new JSONObject();
		ob1.put("state", getState());
		ob1.put("info", getInfo());
		ob2.put("result", obj);
		ob1.put("ret", ob2);
		res = ob1.toString();
		return res;
	}
	
	/**
	 * 获取响应的输出流
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @throws ActionException
	 * @throws IOException 
	 */
	public void getWriter() throws ActionException, IOException{
		if(resp != null){
			setResponseHead(resp);
			out = resp.getWriter();
		}else{
			throw new ActionException("响应流为空");
		}
	}
	
	/**
	 * 配置响应头
     * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 */
	public void setResponseHead(HttpServletResponse response){
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-Type", "application/json;charset=utf-8");
		response.setHeader("Cache-Control", "must-revalidate,no-cache,private");
		response.setHeader("Keep-Alive", "timeout=30");
		response.setHeader("Cache-Control", "must-revalidate,no-cache,private");
		response.setHeader("Pragma", "no-cache");
	}
	
	/**
	 * 
	 * (一句话功能简述)
	 * 向客户端发送响应数据
	 * @author       张洪斌  1079039435@qq.com
	 * @see          相关函数,对于重要的函数建议注释
	 * @since        爱学圈服务器, 2015年1月28日
	 * @param res
	 * @throws IOException 
	 * @throws ActionException 
	 */
	public void sendResponse(String res) throws ActionException, IOException{
		getWriter();
		if(out != null){
			out.write(res);
			out.flush();
			out.close();
		}
	}
	
	public void sendNull(){
		try {
			getWriter();
		} catch (ActionException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		if(out != null){
			JSONObject obj = new JSONObject();
			obj.put("state", getState());
			obj.put("info", getInfo());
			obj.put("msg", "异常");
			out.write(obj.toString());
			out.flush();
			out.close();
		}
	}
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public HttpServletRequest getReq() {
		return req;
	}

	public void setReq(HttpServletRequest req) {
		this.req = req;
	}

	public HttpServletResponse getResp() {
		return resp;
	}

	public void setResp(HttpServletResponse resp) {
		this.resp = resp;
	}

}
