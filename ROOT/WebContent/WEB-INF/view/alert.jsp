<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:choose>
	<c:when test="${msg ne null }">
		<script type="text/javascript">
			alert("${msg}");
			location.href = "${location}";
		</script>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			location.href = "${location}";
		</script>
	</c:otherwise>
</c:choose>