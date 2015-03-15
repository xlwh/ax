package com.ax.utils;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("unused")
public class ActionUtil {
	private ActionContext actionContext;
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Map<String, Object> application;
	private Map<String, Object> session;
	private ValueStack valueStack;
	
	public ActionContext getActionContext() {
		return ActionContext.getContext();
	}
	public void setActionContext(ActionContext actionContext) {
		this.actionContext = actionContext;
	}
	
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public Map<String, Object> getApplication() {
		return actionContext.getApplication();
	}
	public void setApplication(Map<String, Object> application) {
		this.application = application;
	}
	public Map<String, Object> getSession() {
		return actionContext.getSession();
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public ValueStack getValueStack() {
		return actionContext.getValueStack();
	}
	public void setValueStack(ValueStack valueStack) {
		this.valueStack = valueStack;
	}
	
	
}
