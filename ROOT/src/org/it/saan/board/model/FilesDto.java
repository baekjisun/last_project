package org.it.saan.board.model;

import org.springframework.stereotype.Component;

@Component
public class FilesDto {
	private int fnum;
	private int num;
	private String realFile;
	private String tempFile;
	private int cnt;
	
	public int getFnum() {
		return fnum;
	}
	public void setFnum(int fnum) {
		this.fnum = fnum;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getRealFile() {
		return realFile;
	}
	public void setRealFile(String realFile) {
		this.realFile = realFile;
	}
	public String getTempFile() {
		return tempFile;
	}
	public void setTempFile(String tempFile) {
		this.tempFile = tempFile;
	}
	public int getCnt() {
		return cnt;
	}
	public void setCnt(int cnt) {
		this.cnt = cnt;
	}
}
