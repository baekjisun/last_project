package org.it.saan.board.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BoardListService {
	@Autowired
	BoardDao bdao;
	@Autowired
	FilesDao fdao;
	@Autowired
	HttpSession session;

	// controller 땅으로 전체목록 리턴
	public List readAll() {
		return bdao.readAll();
	}

	/*
	 * public List readPageServiceGoogle(int start) { List li = bdao.readAll();
	 * int end = start + 10; if (end > li.size()) end = li.size(); return
	 * li.subList(start, end); }
	 */

	public List readPageServiceNaver(int p) {
		List li = bdao.readAll();
		// sublist 처리해서 데이터 리턴
		// 10개씩 뿌려야겠다고 생각한다면, p가 1일때 0~9, 2이면 10~19, 3이면 20~29
		int size = 10;
		int page = li.size();
		int tot = page / size;
		int start = (p - 1) * 10;
		int end = p * 10;
		if (page % size > 0) {
			tot++;
		}
		if (end > li.size())
			end = li.size();
		session.setAttribute("tot", tot);
		return li.subList(start, end);
	}

	// controller 땅에서 글번호를 받았을 때, 해당하는 files 정보 / board 정보 리턴
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map readOne(String m) {
		BoardDto bdto = bdao.readOne(m);
		List flist = fdao.readSome(m);
		Map map = new HashMap();
		map.put("bdto", bdto);
		map.put("flist", flist);

		return map;
	}
}
