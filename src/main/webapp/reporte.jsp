<%@page import="service.IngenieroService"%>
<%@page import="beans.IngenieroDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- 
	Nuestro servidor necesita otras 2 librerias adicionales para poder funcionar correctamente
	Estas librerias se encuentran en la carpeta WEB-INF/lib
-->
<%
	ArrayList<IngenieroDTO> datos = (ArrayList<IngenieroDTO>) new IngenieroService().listaIngeniero();
	pageContext.setAttribute("ingenieros", datos);
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reporte Ingenieros</title>
</head>
<body>
	<div class="container">
		<jsp:include page="cabecera.jsp" />
		<h1>Reporte de Ingenieros</h1>	
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
				</tr>
			</thead>
			<tbody>
				<c:forEach var="ingeniero" items="${ingenieros}">
					<tr>
						<td>${ingeniero.codigo}</td>
						<td>${ingeniero.nombre}</td>
						<td>${ingeniero.apellido}</td>
						<td>${ingeniero.dni}</td>
						<td>${ingeniero.sueldo}</td>
						<td>${ingeniero.nomUniversidad}</td>
						<td>${ingeniero.nomEspecialidad}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>