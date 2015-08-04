package org.it.saan.board.controller;

import java.io.IOException;

import org.it.saan.board.model.BoardDto;
import org.it.saan.board.model.BoardWriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	BoardWriteService bws;

	@RequestMapping(value = "/board/FileWrite.it", method = RequestMethod.GET)
	public ModelAndView service(ModelAndView mav) {
		mav.setViewName("tiles2:board/FileWrite");
		return mav;
	}

	@RequestMapping(value = "/board/FileWrite.it", method = RequestMethod.POST)
	public ModelAndView service(ModelAndView mav,
			@RequestParam("mpf") MultipartFile mpf, BoardDto dto)
			throws IllegalStateException, IOException {
		try {
			bws.writeService(dto, mpf);
			mav.setViewName("redirect:/board/FileList.it");
		} catch (Exception e) {
			mav.setViewName("alert.tiles");
			mav.addObject("msg", "등록 중 오류가 발생했습니다.");
			mav.addObject("location", "file.tiles");
			e.printStackTrace();
		}
		return mav;
	}
}
