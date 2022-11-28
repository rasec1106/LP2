<%@page import="beans.IngenieroDTO"%>
<%@page import="java.util.ArrayList"%>
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
				<form action="ServletEquipo?tipo=buscarpre" id="frmbuscarpre"
					method="post" class="row d-flex align-items-end">
					<div class="col">
						<label for="precio" class="form-label">Buscar por precio
							(mayor o igual):</label> <input id="precio" type="text" name="txt_precio"
							class="form-control" placeholder="Ingrese precio">
					</div>
					<div class="col">
						<input type="submit" value="Consultar" class="btn btn-primary">
					</div>
				</form>
			</div>
			<div class="col d-flex align-items-end justify-content-end">
				<form action="ServletEquipo?tipo=listar" id="frmlistar"
					method="post"
					class="row d-flex align-items-end justify-content-end">
					<div class="col-auto">
						<button class="btn btn-success">Mostrar Lista</button>
					</div>
				</form>
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
				ArrayList<IngenieroDTO> lista = (ArrayList<IngenieroDTO>) request.getAttribute("data");
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
								out.println("<td align='center'><a href='ServletEquipo?tipo=buscar&cod=" + xPro.getCodigo() + "'>"
								+ "<img title='Editar' src='img/edit.png' width='16px'></a></td>");
								out.println("<td align='center'><a href='ServletEquipo?tipo=eliminar&cod=" + xPro.getCodigo() + "'>"
								+ "<img	title='Eliminar' src='img/delete.png' width='16px'></a></td>");
								out.println("</tr>");
							}
						}
				%>
			</tbody>
		</table>
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