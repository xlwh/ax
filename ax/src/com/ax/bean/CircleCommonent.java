/*
 * Title:        爱学圈服务器 2015年3月9日
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2015
 * Company:      爱学圈
 * @author       张洪斌
 * @version      1.0  2015年3月9日
 */
package com.ax.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * (一句话功能简述)
 * 学习圈评论数据的实体bean对象的封装
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */
@Entity
@Table(name = "T_CIRCLECOMMONENT")
public class CircleCommonent {
	private String id;
	private int uid;
	private CircleMessage circleMessage;
	private Date createTime;
	private String content;
	private boolean isreaded;
	private Set<Replay> replays = new HashSet<Replay>();
	private int state;

	public CircleCommonent() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CircleCommonent(String id, int uid, CircleMessage circleMessage, Date createTime, String content,
			boolean isreaded, Set<Replay> replays, int state) {
		super();
		this.id = id;
		this.uid = uid;
		this.circleMessage = circleMessage;
		this.createTime = createTime;
		this.content = content;
		this.isreaded = isreaded;
		this.replays = replays;
		this.state = state;
	}

	@GenericGenerator(name = "generator", strategy = "uuid.hex")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "CIRCLECOMMONENT_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name = "CIRCLECOMMONENT_UID")
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CIRCLECOMMONENT_CIRCLEMESSAGE")
	public CircleMessage getCircleMessage() {
		return circleMessage;
	}

	public void setCircleMessage(CircleMessage circleMessage) {
		this.circleMessage = circleMessage;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CIRCLECOMMONENT_CREATETIME", length = 19, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "CIRCLECOMMONENT_CONTENT", length = 400)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "CIRCLECOMMONENT_ISREADED")
	public boolean isIsreaded() {
		return isreaded;
	}

	public void setIsreaded(boolean isreaded) {
		this.isreaded = isreaded;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "CIRCLECOMMONENT_REPLAYS")
	public Set<Replay> getReplays() {
		return replays;
	}

	public void setReplays(Set<Replay> replays) {
		this.replays = replays;
	}

	@Column(name = "CIRCLECOMMONENT_STATE")
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((circleMessage == null) ? 0 : circleMessage.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isreaded ? 1231 : 1237);
		result = prime * result + ((replays == null) ? 0 : replays.hashCode());
		result = prime * result + state;
		result = prime * result + uid;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CircleCommonent other = (CircleCommonent) obj;
		if (circleMessage == null) {
			if (other.circleMessage != null)
				return false;
		} else if (!circleMessage.equals(other.circleMessage))
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (createTime == null) {
			if (other.createTime != null)
				return false;
		} else if (!createTime.equals(other.createTime))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isreaded != other.isreaded)
			return false;
		if (replays == null) {
			if (other.replays != null)
				return false;
		} else if (!replays.equals(other.replays))
			return false;
		if (state != other.state)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CircleCommonent [id=" + id + ", uid=" + uid + ", circleMessage=" + circleMessage + ", createTime="
				+ createTime + ", content=" + content + ", isreaded=" + isreaded + ", replays=" + replays + ", state="
				+ state + "]";
	}

}
