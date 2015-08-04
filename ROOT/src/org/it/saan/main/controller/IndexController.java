package org.it.saan.main.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	@Autowired
	HttpSession session;
	
	// 메인으로 보내줌
	@RequestMapping(value="/index.it")
	public String controller(){
		return "main.tiles";
	}
	
	// 로그아웃
	@RequestMapping(value="/index.it", method=RequestMethod.POST)
	public ModelAndView controller2(ModelAndView mav){
		if(session.getAttribute("id") != null){
			session.removeAttribute("id");
		}
		mav.addObject("msg", "로그아웃 되었습니다");
		mav.addObject("location", "/index.it");
		
		mav.setViewName("alert.tiles");
		return mav;
	}
}
