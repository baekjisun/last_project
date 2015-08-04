package org.it.saan.guest.model;

import java.util.List;

import org.it.saan.member.model.MemberLogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GuestRegisterServiceImpl implements GuestRegisterService{
	@Autowired
	GuestDao dao;

	// ���� ���
	public int registerService(GuestDto dto) {
		int r=dao.createOne(dto);
		return r;
	}
	
	// ���� ����Ʈ 5���� ����
	public List readService() {
		List li = dao.readLatest();
		if(li.size() >5) {
			li = li.subList(0, 5);
		}
		return li;
	}
}
