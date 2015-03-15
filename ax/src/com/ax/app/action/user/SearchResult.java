/*
 * Title:        爱学圈服务器 2015年1月26日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月26日
 */
package com.ax.app.action.user;

/**
 * (一句话功能简述)
 * 教师搜索结果的封装
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月26日
 */
public class SearchResult {
	private int id;
	private String pic;
	private String name;
	private float exp;
	private int type;
	private int idfc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getExp() {
		return exp;
	}

	public void setExp(float exp) {
		this.exp = exp;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getIdfc() {
		return idfc;
	}

	public void setIdfc(int idfc) {
		this.idfc = idfc;
	}

}
