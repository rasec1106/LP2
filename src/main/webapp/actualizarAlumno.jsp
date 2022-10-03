<%@ page import="entidad.Alumno" %>
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
	Alumno a = (Alumno) request.getAttribute("registro");
%>
	<form action="ServletAlumno?tipo=actualizar" id="frmActualizar"
		method="post">
		<input type="hidden" name="txt_cod" value="<%=a.getCodigo()%>">
		<table>
			<tr>
				<td>Nombre:</td>
				<td><input type="text" name="txt_nom" value="<%=a.getNombre()%>" class="required"></td>
			</tr>
			<tr>
				<td>Apellido:</td>
				<td><input type="text" name="txt_ape" value="<%=a.getApellido()%>" class="required"></td>
			</tr>
			<tr>
				<td>Direccion:</td>
				<td><input type="text" name="txt_mat" value="<%=a.getDireccion()%>" class="required"></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><input type="text" name="txt_edad" value="<%=a.getEdad()%>" class="required"></td>
			</tr>
			<tr>
				<td>Correo:</td>
				<td><input type="text" name="txt_cor" value="<%=a.getCorreo()%>" class="required"></td>
			</tr>
			<tr>
				<td>Distrito:</td>
				<td><input type="text" name="txt_dis" value="<%=a.getDistrito()%>" class="required"></td>
			</tr>
			<tr>
				<td>Cargo:</td>
				<td><input type="text" name="txt_car" value="<%=a.getCargo()%>" class="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Actualizar"></td>
			</tr>
		</table>
	</form>
</body>
</html>