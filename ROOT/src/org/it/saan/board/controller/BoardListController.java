package org.it.saan.board.controller;

import java.util.List;
import java.util.Map;

import org.it.saan.board.model.BoardListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardListController {
	@Autowired
	BoardListService bls;

	@RequestMapping("/board/FileList.it")
	public ModelAndView controll(ModelAndView mav, @RequestParam(defaultValue = "1") int p) {
		// List li = bls.readAll();
		List li = bls.readPageServiceNaver(p);
		mav.addObject("li", li);
		mav.setViewName("tiles2:board/FileList");
		return mav;
	}

	@RequestMapping("/board/detailPop.it")
	public ModelAndView detailControll2(ModelAndView mav, String num) {
		Map map = bls.readOne(num);
		mav.addAllObjects(map);
		mav.setViewName("board/detail");
		return mav;
	}

	@RequestMapping("/board/detailMove.it")
	public ModelAndView detailControll(ModelAndView mav, String num) {
		Map map = bls.readOne(num);
		mav.addAllObjects(map);
		mav.setViewName("tiles2:board/detail");
		return mav;
	}
}
