package org.it.saan.board.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileDownService {
	@Autowired
	FilesDao fdao;

	// controller ������ ���Ϲ�ȣ�� �ѱ涧 �ٿ�ε� Ƚ�� ������Ű��
	// ���� ����(dto) ���ؼ� controller ������ �Ѱ��ֱ�
	public Map service(String fnum) {
		Map map = new HashMap();

		fdao.updateCnt(fnum);
		map.put("file", fdao.readOne(fnum));

		return map;
	}
}
