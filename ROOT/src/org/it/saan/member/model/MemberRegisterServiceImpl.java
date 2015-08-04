package org.it.saan.member.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;

@Component
public class MemberRegisterServiceImpl implements MemberRegisterService {
	@Autowired
	MemberDao memberDao;
	@Autowired
	MemberLogDao memberLogDao;

	// memberlog���� ���Ե��
	public int service(MemberDto dto) {
		memberDao.createOne(dto);
		return memberLogDao.createOne(dto.getId());
	}
	
	// ���̵� �ߺ�üũ
	public boolean service(String id){
		MemberDto dto = memberDao.readOne(id);
		if(dto==null){
			return true;
		}else{
			return false;
		}
	}
}
