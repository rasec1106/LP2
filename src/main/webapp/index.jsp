<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	String x = (String) request.getAttribute("msj");
	String a = "";
	if (x != null)
		a = x;
	%>
	<form action="ServletEmpleado" name="frmsesion" method="post">
		<table border="1" align="center">
			<tr>
				<td>Login</td>
				<td><input type="text" name="txtLogin"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="text" name="txtClave"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Iniciar"></td>
			</tr>
		</table>
		<h5 align="center"><%=a%></h5>
	</form>
</body>
</html>