package org.it.saan.member.controller;

import java.util.Map;

import org.it.saan.member.model.CountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ChartController {
	@Autowired
	CountService cs;

	@RequestMapping(value="/mem/chart.it")
	public ModelAndView proc(ModelAndView mav){
		mav.addObject("url", "/mem/chart02.it");
		mav.setViewName("tiles2:member/chartList");
		return mav;
	}
	
	@RequestMapping(value="/mem/chart01.it")
	public ModelAndView proc01(ModelAndView mav){
		Map map = cs.service();
		mav.addAllObjects(map);
		mav.setViewName("tiles2:member/chart");
		return mav;
	}
	
	@RequestMapping(value="/mem/chart02.it")
	public ModelAndView proc02(ModelAndView mav){
		Map map = cs.service();
		mav.addAllObjects(map);
		mav.setViewName("chartview");
		return mav;
	}
	
	@RequestMapping(value="/mem/chart03.it")
	public ModelAndView proc03(ModelAndView mav){
		Map map = cs.service();
		mav.addAllObjects(map);
		mav.setViewName("member/chartxml");
		return mav;
	}
}
