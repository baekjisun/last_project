<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${rst gt 0}">
		<script>
			alert('${dto.id}님 회원가입이 성공했습니다.');
			location.href="/index.it";
		</script>
	</c:when>
	<c:otherwise>
		<script>
			alert('회원가입이 실패했습니다.');
			location.href="/index.it";
		</script>
	</c:otherwise>
</c:choose>
