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
		<h1>User Registration View</h1>

		<h3 style="color: green"><%=suc != null ? suc : ""%></h3>
		<h3 style="color: red"><%=err != null ? err : ""%></h3>

		<form action="UserRegistrationCtl" method="post">
			<table>
				<tr>
					<th>First Name</th>
					<td><input type="text" name="firstName" value=""
						placeholder="enter your firstname"></td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td><input type="text" name="lastName" value=""
						placeholder="enter your last name"></td>
				</tr>
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
					<th>Dob</th>
					<td><input type="date" name="dob" value=""></td>
				</tr>
				<tr>
					<th></th>
					<td><input type="submit" name="opretion" value="singUp"></td>
				<tr>
			</table>
		</form>
	</div>

	<%@ include file="Footer.jsp"%>
</body>
</html>