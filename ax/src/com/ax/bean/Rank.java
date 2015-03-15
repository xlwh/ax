/*
 * Title:        爱学圈服务器 2015年1月30日
 * Description:  教师头衔
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年1月30日
 */
package com.ax.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年1月30日
 */
@Entity
@Table(name = "T_RANK")
public class Rank {
	private int id;
	private String name;

	@Id
	@GeneratedValue
	@Column(name="RANK_ID")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="RANK_NAME",length=20)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
