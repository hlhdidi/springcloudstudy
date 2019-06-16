package com.hlhdidi.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	private Long id;
	private String type;
	private Date ctime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getCtime() {
		return ctime;
	}

	public void setCtime(Date ctime) {
		this.ctime = ctime;
	}

	@Override public String toString() {
		return "User{" + "id=" + id + ", type='" + type + '\'' + ", ctime=" + ctime + '}';
	}
}
