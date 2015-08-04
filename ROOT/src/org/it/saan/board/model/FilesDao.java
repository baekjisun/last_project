package org.it.saan.board.model;

import java.util.List;

public interface FilesDao {
	public int createOne(FilesDto dto); // Files Table 에 등록
	public List readSome(String num); // Files Tbale 일치하는 글번호에 data 가져오기
	public FilesDto readOne(String fnum);
	public int updateCnt(String fnum);
}
