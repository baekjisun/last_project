package org.it.saan.board.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

@Component(value="download")
public class Download extends AbstractView{
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		FilesDto z = (FilesDto) model.get("file");
		String fileName = z.getRealFile();

		fileName = URLEncoder.encode(fileName, "utf-8");

		response.setContentType("application/download; charset=utf-8");
		response.setHeader("Content-Transfer-Encoding", "bynary");
		response.setHeader("Content-Disposition", "attachment;filename=\"" + fileName + "\";");

		OutputStream os = response.getOutputStream();

		File o = new File(z.getTempFile());
		InputStream is = new FileInputStream(o);

		FileCopyUtils.copy(is, os);
	}
}
