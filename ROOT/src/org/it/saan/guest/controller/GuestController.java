package org.it.saan.guest.controller;

import java.util.List;

import org.it.saan.guest.model.GuestDto;
import org.it.saan.guest.model.GuestRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GuestController {
	@Autowired
	GuestRegisterService grs;

/*	// 방명록 페이지
	@RequestMapping(value = "/guest/write.it", method = RequestMethod.GET)
	public ModelAndView doGet(ModelAndView mav) {
		mav.setViewName("main.tiles");
		return mav;
	}
	
	// 방명록 등록
	@RequestMapping(value = "/guest/write.it", method = RequestMethod.POST)
	public ModelAndView doPost(ModelAndView mav, GuestDto dto) {
		mav.setViewName("main.tiles");
		int r = grs.registerService(dto);
		mav.addObject("rst", r);
		mav.addObject("dto", dto);
		return mav;
	}*/
	
	/*	// XSL 페이지로 연결
	@RequestMapping(value = "/guest/listxsl.it", method = RequestMethod.GET)
	public ModelAndView doList3(ModelAndView mav, GuestDto dto) {
		mav.setViewName("guestxsl.tiles");
		return mav;
	}*/
	
	// 방명록 등록
	@RequestMapping(value = "/guest/list.it", method = RequestMethod.POST)
	public ModelAndView doList(ModelAndView mav, GuestDto dto) {
		mav.setViewName("main.tiles");
		int r = grs.registerService(dto);
		mav.addObject("rst", r);
		mav.addObject("dto", dto);

		return mav;
	}
	
	// XML 페이지로 연결
	@RequestMapping(value = "/guest/listxml.it", method = RequestMethod.GET)
	public ModelAndView doList2(ModelAndView mav, GuestDto dto) {
		List li = grs.readService();
		return new ModelAndView("guestlist.tiles","li",li);
	}
	
}
