package org.it.saan.board.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileDownService {
	@Autowired
	FilesDao fdao;

	// controller 땅에서 파일번호를 넘길때 다운로드 횟수 증가시키고
	// 파일 정보(dto) 구해서 controller 쪽으로 넘겨주기
	public Map service(String fnum) {
		Map map = new HashMap();

		fdao.updateCnt(fnum);
		map.put("file", fdao.readOne(fnum));

		return map;
	}
}
