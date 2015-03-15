package com.ax.app.action.sys;

import java.io.Writer;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.stereotype.Controller;

import com.ax.service.sys.IndexService;
import com.opensymphony.xwork2.ActionSupport;

@Controller
@ParentPackage("json-default")
@Namespace("/pub")
public class IndexAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private int num;
	private float width;
	private float height;
	private Map<String,Object> result;
	@Resource(name="indexServiceImpl")
	private IndexService indexService;
	@Action(value="index",results={@Result(type="json")})
	public void init(){
		try{
		String res = indexService.goIndex(num,width,height);
		HttpServletResponse resp = ServletActionContext.getResponse();
		resp.setCharacterEncoding("UTF-8");
		resp.setHeader("Content-Type", "text/html;charset=utf8");
		Writer out = resp.getWriter();
		out.write(res);
		//this.setResult(res);
		}catch(Exception e){
			e.printStackTrace();
		}
	    //System.out.println(indexService == null);
		//File file = new File("");
		//System.out.println();
		
		
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public float getWidth() {
		return width;
	}

	public void setWidth(float width) {
		this.width = width;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public Map<String, Object> getResult() {
		return result;
	}

	public void setResult(Map<String, Object> result) {
		this.result = result;
	}

	public IndexService getIndexService() {
		return indexService;
	}

	public void setIndexService(IndexService indexService) {
		this.indexService = indexService;
	}

	
	
}
