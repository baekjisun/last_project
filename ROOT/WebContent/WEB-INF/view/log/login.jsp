<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="log_form" align="right"
	style="background-color: #F6FFCC; height: 90px;">
	<h1 align="left">&nbsp;Index Page</h1>
	<c:choose>
		<%-- 로그인 전 --%>
		<c:when test="${log eq null }">
			<form action="/mem/log.it" method="post">
				ID <input type="text" name="id" style="width: 100px" /> | PW <input
					type="password" name="pass" style="width: 100px" /> <input
					type="submit" value="LOGIN" />&nbsp;&nbsp;
			</form>
		</c:when>
		<%-- 로그인 후 --%>
		<c:otherwise>
			<form action="/index.it" method="post">
				<b>${log.id }</b>님 접속중입니다.
				&nbsp;<input type="submit" value="LOGOUT" />&nbsp;&nbsp;
			</form>
		</c:otherwise>
	</c:choose>
</div>