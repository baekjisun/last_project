<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<script type="text/javascript" src="/script.js"></script>
<script>
	function sendRequest() {
		var request = openRequest();
		request.open("GET", "/guest/listxml.it", true);
		request.onreadystatechange = function() {
			if (request.readyState == 4 && request.status == 200) {
				var xml = request.responseXML;
				var req2 = openRequest();
				req2.open("GET", "/Xlist.xsl", true);
				req2.onreadystatechange = function() {
					if (req2.readyState == 4 && req2.status == 200) {
						var xsl = req2.responseXML;
						var div = document.getElementById("guestList");
						if (window.ActiveXObject != null) {
							div.innerHTML = xml.transformNode(xsl);
						} else {
							var trans = new XSLTProcessor();
							trans.importStylesheet(xsl);
							var frg = trans.transformToFragment(xml, document);
							div.innerHTML = "";
							div.appendChild(frg);
						}
					}
				}
				req2.send(null);
			}
		}
		request.send(null);
		setTimeout("sendRequest();", 5000);
	}

	window.onload = function() {
		sendRequest();
	}
</script>
<div id="guest_title" align="left">
	<h2>&nbsp;&nbsp;방명록</h2>
</div>
<div id="guestInsert" align="left">
	<form name="guest" action="/guest/list.it" method="post">
		<ul>
			<li>작성자&nbsp;&nbsp;<input type="text" name="writer" /></li>
			<li>내용&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="content" size="50" />&nbsp;<input
				type="submit" value="OK" /></li>
		</ul>
	</form>
</div>
<hr />
<div id="guestList"></div>