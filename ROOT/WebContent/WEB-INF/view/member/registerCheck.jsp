<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:choose>
	<c:when test="${rst eq true }">
		<font color="blue">사용 가능합니다</font>
	</c:when>
	<c:otherwise>
		<font color="red">사용 불가능합니다</font>
	</c:otherwise>
</c:choose>
