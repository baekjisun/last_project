<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	function showDetail(num) {
		var loc = "/board/detailPop.it?num=" + num;
		// location.href=loc;
		var cw = 600;
		var ch = 500;
		var sw = screen.availWidth;
		var sh = screen.availHeight;
		var px = (sw - cw) / 2;
		var py = (sh - ch) / 2;
		window.open(loc, "", "width=600, height=500, top=" + py + ", left="
				+ px + "", true);
		// 띄울 경로, 윈도우 프레임네임, 기타옵션
	}
</script>


<div id="filelist_title" style="padding-left: 20px">
	<h2>파일 목록</h2>
	<hr />
	<form action="/board/FileSearch.it" method="get">
		<input type="text" name="search" />&nbsp;<input type="submit"
			value="검색" /><br />
	</form>
</div>
<div style="padding-left: 20px">
	<table
		style="border-style: inherit; border-color: #000000; width: 70%;">
		<tr>
			<td><input type="button" value="글쓰기"
				onclick="location.href='/board/FileWrite.it'" /></td>
		<tr>
		<tr style="background-color: #E4F7BA;">
			<th style="width: 5%;">글번호</th>
			<th style="width: 15%;">작성일</th>
			<th style="width: 10%;">작성자</th>
			<th style="width: 70%;">글제목</th>
		</tr>
		<c:forEach items="${li }" var="o">
			<tr>
				<td align="center">${o.num }</td>
				<td align="center"><fmt:formatDate value="${o.writedate }"
						pattern="yyyy/MM/dd" /></td>
				<td align="center">${o.writer }</td>
				<td align="left"><a href="javascript:showDetail('${o.num }')">${o.title }</a></td>
			</tr>
		</c:forEach>
	</table>
</div>

<div id="page" align="center">
	<!-- page link view -->
	<c:forEach var="num" begin="1" end="${tot }">
		<c:choose>
			<c:when test="${param.p eq null and num eq 1 }">
				<b><font color="gray">${num }</font></b>
			</c:when>
			<c:when test="${num ne param.p}">
				<a href="/board/FileList.it?p=${num }"><font color="gray">${num }</font></a>
			</c:when>
			<c:otherwise>
				<b><font color="gray">${num }</font></b>
			</c:otherwise>
		</c:choose>
	</c:forEach>
</div>