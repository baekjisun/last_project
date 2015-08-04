<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<html>
<body>
	<div>
		<tiles:insertAttribute name="login" />
	</div>
	<div>
		<tiles:insertAttribute name="nav" />
	</div>
	<div style="min-height: 700px;">
		<div style="float: left; padding-left: 50px; width: 700px;"><tiles:insertAttribute name="guest" /></div>
		<div style="float: right; padding-right: 50px;"><tiles:insertAttribute name="reg" /></div>
	</div>
	<div>
		<tiles:insertAttribute name="footer" />
	</div>
</body>
</html>