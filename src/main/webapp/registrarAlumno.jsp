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
				<td>Apellido:</td>
				<td><input type="text" name="txt_ape" class="required"></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><input type="text" name="txt_dir" class="required"></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><input type="text" name="txt_edad" class="required"></td>
			</tr>			
			<tr>
				<td>Correo:</td>
				<td><input type="text" name="txt_cor" class="required"></td>
			</tr>
			<tr>
				<td>Distrito:</td>
				<td><input type="text" name="txt_dis" class="required"></td>
			</tr>
			<tr>
				<td>Cargo:</td>
				<td><input type="text" name="txt_car" class="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Registrar"></td>
			</tr>
		</table>
	</form>
</body>
</html>