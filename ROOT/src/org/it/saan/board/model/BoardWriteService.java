package org.it.saan.board.model;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.it.saan.member.model.MemberDto;
import org.it.saan.member.model.MemberLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class BoardWriteService {
	@Autowired
	HttpSession session;
	@Autowired
	FilesDto fDto;
	@Autowired
	BoardDao bDao;
	@Autowired
	ServletContext application;
	@Autowired
	FilesDao fDao;
	
	// controller 땅에서 필요한 정보들을 전달받아서 처리
	// MultipartFile로 file은 받아줌
	public int writeService(BoardDto dto, MultipartFile mpf) throws IllegalStateException, IOException{
		// view에서 content, title, file을 골라 보내면 controller는 catch해서 이쪽 service로 넘겨줌
		// BoardDto에서 writer가 setting이 안됨
		MemberDto mem = (MemberDto)session.getAttribute("log");
		dto.setWriter(mem.getName());
		
		// MultipartFile로 바꾸고 업로드가 끝나는게 아님
		int rst = 0;
		if(mpf.isEmpty()){
			rst = bDao.createOne(dto);
		}else{
			String real = mpf.getOriginalFilename();
			mpf.getSize();
			
			String i = UUID.randomUUID().toString();	// tempname (저장시 파일명)
			String path = application.getRealPath("/files");
			File dir = new File(path);
			dir.mkdirs();	// 디렉토리 생성
			
			File temp = new File(dir, i);
			mpf.transferTo(temp);
			//=========================================파일 전송 완료
			fDto.setRealFile(real);
			fDto.setTempFile(temp.getAbsolutePath());
			//=========================================
			bDao.createOne(dto);
			rst = fDao.createOne(fDto);
		}
		return rst;
	}
}
