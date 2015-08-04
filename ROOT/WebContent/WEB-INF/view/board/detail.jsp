<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<script type="text/javascript">
	function show() {
		var f = document.getElementById("fdown");
		var l = document.getElementById("log");
		if (f.style.display == 'none') {
			f.style.display = '';
			l.innerHTML = "접기";
		} else {
			f.style.display = 'none';
			l.innerHTML = "펼치기";
		}
	}
</script>
<div id="filelist_title">
	<h2>상세 글보기</h2>
	<hr />
	<form action="/board/FileList.it" method="get">
		<input type="submit" value="글목록" />
	</form>
</div>
<div>
	<i>#${bdto.num }</i>. <b>${bdto.title }</b> <br /> <br />
	<hr />
	<div style="height: 200;">
		<pre>${bdto.content }</pre>
	</div>
	<hr />
	첨부파일 <b>${flist.size() }</b> <a href="javascript:show()"><span
		id="log">펼치기</span></a>
	<div id="fdown" style="display: none; background-color: #E4F7BA">
		<c:if test="${flist ne null }">
			<c:forEach var="t" items="${flist }">
				<a href="/download.it?fnum=${t.fnum }">${t.realFile }</a> (download count : ${t.cnt })
				<br />
			</c:forEach>
		</c:if>
	</div>
</div>