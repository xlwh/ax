package com.ax.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 公共的action
 * 
 * @author zhanghongbin
 * 
 */
public class BaseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	/** 请求执行状态 **/
	protected int state = 200;
	/** 请求信息 **/
	protected String info = "success";
	/** 服务器返回的结果 **/
	protected Map<String, Object> result;
	/**actionContext**/
	protected ActionContext actionContext;
	
	public BaseAction(){
		super();
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

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

}
