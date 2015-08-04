package org.it.saan.member.controller;

import org.it.saan.member.model.MemberDto;
import org.it.saan.member.model.MemberRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {
	@Autowired
	MemberRegisterService mrs;

	// ȸ������ ó�� �� ��� �� dto ����
	@RequestMapping(value = "/mem/reg.it", method = RequestMethod.POST)
	public ModelAndView doPost(MemberDto dto) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("regSucc.tiles");
		int r = mrs.service(dto);
		mav.addObject("rst", r);
		mav.addObject("dto", dto);

		return mav;
	}

	// ���̵� �ߺ�üũ
	@RequestMapping(value = "/mem/check.it")
	public ModelAndView doPost(ModelAndView mav, String id) {
		boolean rst = mrs.service(id);
		mav.addObject("rst", rst);
		mav.setViewName("chk.tiles");

		return mav;
	}
}
