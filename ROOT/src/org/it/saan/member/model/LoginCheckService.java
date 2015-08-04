package org.it.saan.member.model;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginCheckService {
	@Autowired
	MemberLogDao mld;
	@Autowired
	MemberDao dao;

	// id, pass 체크 후 포인트, 날짜 업데이트
	public boolean service(String id, String pass, HttpSession session){
		boolean rst = false;
		MemberDto dto = dao.readOne(id);
		if(dto!=null&&dto.getPass().equals(pass)){
			mld.upPoint(id);
			mld.upLog(id);
			session.setAttribute("log", dto);
			rst = true;
		}
		return rst;
	}
}
