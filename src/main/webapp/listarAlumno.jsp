<%@ page import="java.util.List"%>
<%@ page import="entidad.Alumno"%>
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
	List<Alumno> da = (List<Alumno>) request.getAttribute("data");
	%>
	<h2 align="center">Listado de alumnos</h2>
	<table border="2" align="center" width="75%">
		<tr>
			<th>Codigo</th>
			<th>Nombre</th>
			<th>Paterno</th>
			<th>Materno</th>
			<th>Edad</th>
			<th colspan="2">Acciones</th>
		</tr>
		<%
		if (da != null) {
			for (Alumno a : da) {
		%>
		<tr>
			<td><%=a.getCodigo()%></td>
			<td><%=a.getNombre()%></td>
			<td><%=a.getPaterno()%></td>
			<td><%=a.getMaterno()%></td>
			<td><%=a.getEdad()%></td>
			<td colspan="2" align="center"><a
				href="ServletAlumno?tipo=buscar&txt_cod=<%=a.getCodigo()%>"> <img
					title="Editar" src="img/edit.png" width="16px">
			</a> <a href="ServletAlumno?tipo=eliminar&txt_cod=<%=a.getCodigo()%>"> <img
					title="Eliminar" src="img/delete.png" width="16px">
			</a></td>
		</tr>
		<%
		}
		}
		%>
	</table>
	<a href="registrarAlumno.jsp">+ Nuevo Registro</a>
</body>
</html>