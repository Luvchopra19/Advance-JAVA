<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	String suc = (String) request.getAttribute("successMsg");
	String err = (String) request.getAttribute("errorMsg");
	%>

	<%@ include file="Header.jsp"%>

	<div align="center">
		<h1>Login View</h1>

		<h3 style="color: green"><%=suc != null ? suc : ""%></h3>
		<h3 style="color: red"><%=err != null ? err : ""%></h3>

		<form action="LoginCtl" method="post">
			<table>
				<tr>
					<th>Login</th>
					<td><input type="email" name="login" value=""
						placeholder="enter your email"></td>
				</tr>
				<tr>
					<th>Password</th>
					<td><input type="password" name="password" value=""
						placeholder="enter your password"></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="opretion" value="singIn"></td>
				<tr>
			</table>
		</form>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>