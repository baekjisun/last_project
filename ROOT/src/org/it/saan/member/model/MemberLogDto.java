package org.it.saan.member.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class MemberLogDto{
	private String id;
	private Date lastlog;
	private int point;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getLastlog() {
		return lastlog;
	}

	public void setLastlog(Date lastlog) {
		this.lastlog = lastlog;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
}
