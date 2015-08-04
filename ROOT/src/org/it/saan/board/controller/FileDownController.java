package org.it.saan.board.controller;

import org.it.saan.board.model.FileDownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FileDownController {
	@Autowired
	FileDownService fds;

	@RequestMapping(value = "/download.it")
	public ModelAndView downControll(ModelAndView mav, String fnum) {

		mav.addAllObjects(fds.service(fnum));

		mav.setViewName("download");
		return mav;
	}
}
