<%@page import="beans.EquipoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<jsp:include page="cabecera.jsp" />
	
	<form action="ServletEquipo?tipo=buscarpre" id="frmbuscarpre"
		method="post" class="row g-4">
		<div class="col-auto">
			<input type="text" name="txt_precio" class="form-control"
				placeholder="Ingrese precio">
		</div>
		<div class="col-auto">
			<input type="submit" value="Consultar" class="btn btn-primary">
		</div>
	</form>
	<br>
	<div class="col-auto" align="left">
	<form action="ServletEquipo?tipo=listar" id="frmlistar" method="post">
		<button class="btn btn-danger">Mostrar Lista</button>
	</form>
	</div>
	<table border="2" align="center" width="75%">
		<tr>
			<th>CÓDIGO</th>
			<th>DESCRIPCIÓN</th>
			<th>PRECIO</th>
			<th>STOCK</th>
			<th>MARCA</th>
			<th>PAIS</th>
			<th colspan="2">ACCIONES</th>
		</tr>
		<%
		ArrayList<EquipoDTO> lista = (ArrayList<EquipoDTO>) request.getAttribute("data");
			if (lista != null) {
				for (EquipoDTO xPro : lista) {
			out.println("<tr>");
			out.println("<td>" + xPro.getCodigo() + "</td>");
			out.println("<td>" + xPro.getDescripcion() + "</td>");
			out.println("<td>" + xPro.getPrecio() + "</td>");
			out.println("<td>" + xPro.getStock() + "</td>");
			out.println("<td>" + xPro.getNomMarca() + "</td>");
			out.println("<td>" + xPro.getNomPais() + "</td>");
			out.println("<td align='center'><a href='ServletEquipo?tipo=buscar&cod=" + xPro.getCodigo() + "'>"
			+ "<img src='img/edit.png' title='Editar'></a></td>");
			out.println("<td align='center'><a href='ServletEquipo?tipo=eliminar&cod=" + xPro.getCodigo() + "'>"
			+ "<img src='img/delete.png' title='Eliminar'></a></td>");
			out.println("</tr>");
				}
			}
		%>
	</table>
</body>
<%
	if(request.getAttribute("message") != null){
		String message = (String) request.getAttribute("message");
		out.println("<script>");
		out.println("window.addEventListener('load', function(){");
		out.println("alert('"+message+"')");
		out.println("})");
		out.println("</script>");
	}
%>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
</html>