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
				<td>Paterno:</td>
				<td><input type="text" name="txt_pat" value="<%=a.getPaterno()%>" class="required"></td>
			</tr>
			<tr>
				<td>Materno:</td>
				<td><input type="text" name="txt_mat" value="<%=a.getMaterno()%>" class="required"></td>
			</tr>
			<tr>
				<td>Edad:</td>
				<td><input type="text" name="txt_edad" value="<%=a.getEdad()%>" class="required"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					value="Actualizar"></td>
			</tr>
		</table>
	</form>
</body>
</html>