package org.it.saan.member.model;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CountService {
	@Autowired
	MemberDao dao;
	
	public Map service(){
		Map map = new HashMap();
		int c1 = dao.manCnt();
		map.put("man", c1);
		int c2 = dao.womanCnt();
		map.put("woman", c2);
		
		return map;
	}
}
