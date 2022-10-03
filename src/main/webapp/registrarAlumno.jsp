<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletAlumno?tipo=registrar" id="frmRegistro"
		method="post">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txt_nom" class="required"></td>
			</tr>
			<tr>
				<td>Paterno:</td>
				<td><input type="text" name="txt_pat" class="required"></td>
			</tr>
			<tr>
				<td>Materno:</td>
				<td><input type="text" name="txt_mat" class="required"></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><input type="text" name="txt_edad" class="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Registrar"></td>
			</tr>
		</table>
	</form>
</body>
</html>