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
	
	// controller ������ �ʿ��� �������� ���޹޾Ƽ� ó��
	// MultipartFile�� file�� �޾���
	public int writeService(BoardDto dto, MultipartFile mpf) throws IllegalStateException, IOException{
		// view���� content, title, file�� ��� ������ controller�� catch�ؼ� ���� service�� �Ѱ���
		// BoardDto���� writer�� setting�� �ȵ�
		MemberDto mem = (MemberDto)session.getAttribute("log");
		dto.setWriter(mem.getName());
		
		// MultipartFile�� �ٲٰ� ���ε尡 �����°� �ƴ�
		int rst = 0;
		if(mpf.isEmpty()){
			rst = bDao.createOne(dto);
		}else{
			String real = mpf.getOriginalFilename();
			mpf.getSize();
			
			String i = UUID.randomUUID().toString();	// tempname (����� ���ϸ�)
			String path = application.getRealPath("/files");
			File dir = new File(path);
			dir.mkdirs();	// ���丮 ����
			
			File temp = new File(dir, i);
			mpf.transferTo(temp);
			//=========================================���� ���� �Ϸ�
			fDto.setRealFile(real);
			fDto.setTempFile(temp.getAbsolutePath());
			//=========================================
			bDao.createOne(dto);
			rst = fDao.createOne(fDto);
		}
		return rst;
	}
}
