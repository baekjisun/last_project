package org.it.saan.guest.model;

import java.util.List;

import org.it.saan.member.model.MemberLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestRegisterServiceImpl implements GuestRegisterService{
	@Autowired
	GuestDao dao;

	// 방명록 등록
	public int registerService(GuestDto dto) {
		int r=dao.createOne(dto);
		return r;
	}
	
	// 방명록 리스트 5개씩 리턴
	public List readService() {
		List li = dao.readLatest();
		if(li.size() >5) {
			li = li.subList(0, 5);
		}
		return li;
	}
}
