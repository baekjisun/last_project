package org.it.saan.member.controller;

import javax.servlet.http.HttpSession;

import org.it.saan.member.model.LoginCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	LoginCheckService lcs;

	// �α��� ó��
	@RequestMapping(value = "/mem/log.it", method = RequestMethod.POST)
	public ModelAndView logChk(ModelAndView mav, String id, String pass, HttpSession session) {
		boolean rst = lcs.service(id, pass, session);
		if (rst) {
			mav.addObject("msg", id+"��, ȯ���մϴ�!");
			mav.addObject("location", "/index.it");
			mav.setViewName("alert.tiles");
			return mav;
		}else{
			mav.addObject("msg", "���̵� �Ǵ� ��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			mav.addObject("location", "/index.it");
			mav.setViewName("alert.tiles");
			return mav;
		}
	}
}
