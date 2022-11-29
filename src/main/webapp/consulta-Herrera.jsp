<%@page import="beans.EspecialidadDTO"%>
<%@page import="beans.IngenieroDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utils.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Ingenieros</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<jsp:include page="cabecera.jsp" />
		<div class="row">
			<div class="col">
				<div class="col-auto">
					<a href="registrarIngeniero.jsp" class="btn btn-success">Nuevo Ingeniero</a>
				</div>
			</div>
		</div>
		<br>
		<table
			class="table table-bordered table-striped table-hover align-middle text-center">
			<thead>
				<tr>
					<th>CÓDIGO</th>
					<th>NOMBRE</th>
					<th>APELLIDO</th>
					<th>DNI</th>
					<th>SUELDO</th>
					<th>UNIVERSIDAD</th>
					<th>ESPECIALIDAD</th>
					<th colspan="2">ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<IngenieroDTO> lista = (ArrayList<IngenieroDTO>)request.getAttribute("data");
						if (lista != null) {
							for (IngenieroDTO xPro : lista) {
								out.println("<tr>");
								out.println("<td>" + xPro.getCodigo() + "</td>");
								out.println("<td>" + xPro.getNombre() + "</td>");
								out.println("<td>" + xPro.getApellido() + "</td>");
								out.println("<td>" + xPro.getDni() + "</td>");
								out.println("<td>" + xPro.getSueldo() + "</td>");
								out.println("<td>" + xPro.getNomUniversidad() + "</td>");
								out.println("<td>" + xPro.getNomEspecialidad() + "</td>");
								out.println("<td align='center'><a href='ServletIngeniero?tipo=buscar&cod=" + xPro.getCodigo() + "'>"
								+ "<img title='Editar' src='img/edit.png' width='16px'></a></td>");
								out.println("<td align='center'><a href='ServletIngeniero?tipo=eliminar&cod=" + xPro.getCodigo() + "'>"
								+ "<img	title='Eliminar' src='img/delete.png' width='16px'></a></td>");
								out.println("</tr>");
							}
						}
				%>
			</tbody>
		</table>
		<hr>
		<div class="row">
			<div class="col">
				<div class="col-auto">
					<%	EspecialidadDTO especialidad = (EspecialidadDTO)request.getAttribute("especialidad"); %>
					<div>Cantidad de Ingenieros en la especialidad de <%=especialidad.getNombre()%> : 
						<%= Utils.ingenierosPorEspecialidad(lista, especialidad.getCodigo()) %>
					</div>
					<div>Suma de Sueldos de los Ingenieros en la especialidad de <%=especialidad.getNombre()%> :
						<%= Utils.sumaSueldosPorEspecialidad(lista, especialidad.getCodigo()) %>
					</div>
				</div>
			</div>
			
		</div>
	</div>
</body>
<%
if (request.getAttribute("message") != null) {
	String message = (String) request.getAttribute("message");
	out.println("<script>");
	out.println("window.addEventListener('load', function(){");
	out.println("alert('" + message + "')");
	out.println("})");
	out.println("</script>");
}
%>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous">
</script>
</html>