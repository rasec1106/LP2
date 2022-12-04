<%@page import="beans.SolicitudDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utils.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listar Solicitudes</title>
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
					<a href="registrarSolicitud.jsp" class="btn btn-success">Nueva Solicitud</a>
				</div>
			</div>
		</div>
		<br>
		<table
			class="table table-bordered table-striped table-hover align-middle text-center">
			<thead>
				<tr>
					<th>ID</th>
					<th>CODIGO</th>
					<th>SOLICITANTE</th>
					<th>MOTIVO</th>
					<th>FECHA</th>
					<th>ALMACEN</th>
					<th>ASIGNADO</th>
					<th>ESTADO</th>
					<th colspan="3">ACCIONES</th>
				</tr>
			</thead>
			<tbody>
				<%
				ArrayList<SolicitudDTO> lista = (ArrayList<SolicitudDTO>)request.getAttribute("data");
						if (lista != null) {
							for (SolicitudDTO xPro : lista) {
								out.println("<tr>");
								out.println("<td>" + xPro.getId() + "</td>");
								out.println("<td>" + xPro.getCodigo() + "</td>");
								out.println("<td>" + xPro.getIdSolicitante() + "</td>");
								out.println("<td>" + xPro.getMotivo() + "</td>");
								out.println("<td>" + xPro.getFecha() + "</td>");
								out.println("<td>" + xPro.getIdAlmacen() + "</td>");
								out.println("<td>" + xPro.getIdUsuario() + "</td>");
								out.println("<td>" + xPro.getIdEstado() + "</td>");
								out.println("<td align='center'><a href='ServletSolicitud?tipo=buscar&cod=" + xPro.getCodigo() + "'>"
								+ "Gestionar</a></td>");
								out.println("<td align='center'><a href='ServletSolicitud?tipo=eliminar&cod=" + xPro.getCodigo() + "'>"
								+ "Reporte</a></td>");
								out.println("<td align='center'><a href='ServletSolicitud?tipo=eliminar&cod=" + xPro.getCodigo() + "'>"
								+ "Stock</a></td>");
								out.println("</tr>");
							}
						}
				%>
			</tbody>
		</table>
		<% 
		if(lista.size() == 0){
			out.println("<div style=\"margin:auto; text-align: center;\"> No existen registros </div>");
		}
		%>
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