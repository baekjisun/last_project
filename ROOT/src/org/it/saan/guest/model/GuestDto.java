package org.it.saan.guest.model;

import java.util.Date;

import org.springframework.stereotype.Component;

public class GuestDto {
	private String writer;
	private String content;
	private Date writedate;
	
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getWritedate() {
		return writedate;
	}
	public void setWritedate(Date writedate) {
		this.writedate = writedate;
	}
}
