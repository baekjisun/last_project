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

	// controller ������ ��ü��� ����
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
		// sublist ó���ؼ� ������ ����
		// 10���� �ѷ��߰ڴٰ� �����Ѵٸ�, p�� 1�϶� 0~9, 2�̸� 10~19, 3�̸� 20~29
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

	// controller ������ �۹�ȣ�� �޾��� ��, �ش��ϴ� files ���� / board ���� ����
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
