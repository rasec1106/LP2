<%@page import="beans.ProductoDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="cabecera.jsp" />
	<table border="2" align="center" width="75%">
		<tr>
			<th>CÓDIGO</th>
			<th>DESCRIPCIÓN</th>
			<th>PRECIO</th>
			<th>STOCK</th>
			<th>MARCA</th>
			<th colspan="2">ACCIONES</th>
		</tr>
		<%
		ArrayList<ProductoDTO> lista = (ArrayList<ProductoDTO>) request.getAttribute("data");
		if (lista != null) {
			for (ProductoDTO xPro : lista) {
				out.println("<tr>");
				out.println("<td>" + xPro.getCodigo() + "</td>");
				out.println("<td>" + xPro.getDescripcion() + "</td>");
				out.println("<td>" + xPro.getPrecio() + "</td>");
				out.println("<td>" + xPro.getStock() + "</td>");
				out.println("<td>" + xPro.getNomMarca() + "</td>");
				out.println("<td align='center'><a href='ServletProducto?tipo=buscar&cod=" + xPro.getCodigo() + "'>"
				+ "<img src='img/edit.png' title='Editar'></a></td>");
				out.println("<td align='center'><a href='ServletProducto?tipo=eliminar&cod=" + xPro.getCodigo() + "'>"
				+ "<img src='img/delete.png' title='Eliminar'></a></td>");
				out.println("</tr>");
			}
		}
		%>
	</table>
</body>
</html>