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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

/**
 * (一句话功能简述)
 * (功能详细描述)
 * @author       张洪斌  1079039435@qq.com
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        爱学圈服务器, 2015年3月9日
 */
@Entity
@Table(name = "T_REPLAY")
public class Replay {
	private String id;
	private String cid;
	private int uid;
	private String content;
	private Date createTime;
	private boolean isreaded;
	private int state;

	public Replay() {
		super();

	}

	public Replay(String id, String cid, int uid, String content, Date createTime, boolean isreaded, int state) {
		super();
		this.id = id;
		this.cid = cid;
		this.uid = uid;
		this.content = content;
		this.createTime = createTime;
		this.isreaded = isreaded;
		this.state = state;
	}
	@GenericGenerator(name = "generator", strategy = "uuid.hex")
    @Id
	@GeneratedValue(generator = "generator")
	@Column(name = "REPLAY_ID", unique = true, nullable = false, length = 32)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	@Column(name="REPLAY_CID",length = 32)
	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}
	@Column(name="REPLAY_UID",length = 32)
	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}
	@Column(name="REPLAY_CONTENT",length = 400)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "REPLAY_CREATETIME", length = 19, columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	@Column(name="REPLAY_ISREADED")
	public boolean isIsreaded() {
		return isreaded;
	}

	public void setIsreaded(boolean isreaded) {
		this.isreaded = isreaded;
	}
	@Column(name="REPLAY_STATE")
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
		result = prime * result + ((cid == null) ? 0 : cid.hashCode());
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createTime == null) ? 0 : createTime.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isreaded ? 1231 : 1237);
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
		Replay other = (Replay) obj;
		if (cid == null) {
			if (other.cid != null)
				return false;
		} else if (!cid.equals(other.cid))
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
		if (state != other.state)
			return false;
		if (uid != other.uid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Replay [id=" + id + ", cid=" + cid + ", uid=" + uid + ", content=" + content + ", createTime="
				+ createTime + ", isreaded=" + isreaded + ", state=" + state + "]";
	}

}
