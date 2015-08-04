<%@ page language="java" contentType="text/xml; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<guestlist>
<c:forEach var="t" items="${li }">
	<guest>
		<writer>${t.writer }</writer>
		<content>${t.content }</content>
		<writedate><fmt:formatDate value="${t.writedate }" pattern="YYYY년 MM월 dd일, HH:mm"/></writedate>
	</guest>
</c:forEach>
</guestlist>