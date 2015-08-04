<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
	var request=null;
	function sender() {
		request = openRequest();
		request.onreadystatechange = receiver;
		var id = document.mem_reg.id.value;
		request.open("GET", "/mem/check.it?id=" + id, true);
		request.send(null);
	}

	function receiver() {
		if (request.readyState == 4 && request.status == 200) {
			document.getElementById("ids").innerHTML = request.responseText;
		}
	}
</script>

<div id="reg_title" align="right">
	<h2>회원 가입</h2>
</div>
<div id="reg_form" align="right">
	<form action="/mem/reg.it" method="post" name="mem_reg">
		<table style="border-color: #FFFFFF">
			<tr style="color: #EAEAEA">
				<td><input type="text" name="id" placeholder="ID" onblur="sender()"/></td>
			</tr>
			<tr>
				<td><span id="ids"></span></td>
			</tr>
			<tr style="color: #EAEAEA">
				<td><input type="password" name="pass" placeholder="Password"/></td>
			</tr>
			<tr style="color: #EAEAEA">
				<td><input type="text" name="name" placeholder="Name"/></td>
			</tr>
			<tr style="color: #EAEAEA">
				<td>
					<input type="radio" name="gender" value="남"/>man
					<input type="radio" name="gender" value="여"/>woman
				</td>
			</tr>
			<tr style="color: #EAEAEA">
				<td><input type="text" name="email" placeholder="E-mail"/></td>
			</tr>
			<tr style="color: #EAEAEA">
				<td><input type="text" name="address" placeholder="Address"/></td>
			</tr>
		</table>
		<input type="submit" value="OK" />&nbsp;<input type="reset" value="Reset" />
	</form>
</div>