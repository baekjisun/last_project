<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript" src="/ckeditor/ckeditor.js"></script>
<div id="file_title" style="padding-left: 20px;">
	<h2>파일 업로드</h2>
		<hr />
	<form action="/board/FileList.it" method="get">
		<input type="submit" value="글목록" />
	</form>
	<hr />
</div>
<div id="file" style="padding-left: 20px;">
	<form action="/board/FileWrite.it" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>제목</td>
				<td><input type="text" name="title" size="28"/></td>
			</tr>
			<tr>
				<td>내용</td>
				<td>
					<textarea rows="5" cols="30" name="content"></textarea>
					<script type="text/javascript">
						CKEDITOR.replace('content');
					</script>
				</td>
			</tr>
			<tr>
				<td></td>
				<td><input type="file" value="파일" name="mpf"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="확인" /></td>
			</tr>
		</table>
	</form>
</div>