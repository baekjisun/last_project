package org.it.saan.board.model;

import java.util.List;

public interface FilesDao {
	public int createOne(FilesDto dto); // Files Table �� ���
	public List readSome(String num); // Files Tbale ��ġ�ϴ� �۹�ȣ�� data ��������
	public FilesDto readOne(String fnum);
	public int updateCnt(String fnum);
}
