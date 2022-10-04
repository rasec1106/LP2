<%@ page import="java.util.List"%>
<%@ page import="entidad.Proveedor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Proveedores</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
	<%
	List<Proveedor> da = (List<Proveedor>) request.getAttribute("data");
	%>
	<div class="container">
	
	<h2 align="center" class="mt-5">Listado de Proveedores</h2>	
	<a href="registrarProveedor.jsp" class="btn btn-success my-2">Nuevo Registro</a>
	<table class="table table-bordered table-striped table-hover align-middle text-center">
	<thead>
		<tr>
			<th scope="col">Codigo</th>
			<th scope="col">Razon Social</th>
			<th scope="col">Ruc</th>
			<th scope="col">Direccion</th>
			<th scope="col">Dni</th>
			<th scope="col">Nombre</th>
			<th scope="col">Celular</th>
			<th scope="col">Fecha de Nacimiento</th>
			<th  scope="col" colspan="2">Acciones</th>
		</tr>
		</thead>
		<tbody>
		<%
		if (da != null) {
			for (Proveedor a : da) {
		%>
		<tr>
			<td><%=a.getCodigo()%></td>
			<td><%=a.getRazonSocial()%></td>
			<td><%=a.getRuc()%></td>
			<td><%=a.getDireccion()%></td>
			<td><%=a.getDni()%></td>
			<td><%=a.getNombre()%></td>
			<td><%=a.getCelular()%></td>
			<td><%=a.getFecNacimiento()%></td>
			<td colspan="2" align="center"><a
				href="ServletProveedor?tipo=buscar&codigo=<%=a.getCodigo()%>"> <img
					title="Editar" src="img/edit.png" width="16px">
			</a> <a href="ServletProveedor?tipo=eliminar&codigo=<%=a.getCodigo()%>"> <img
					title="Eliminar" src="img/delete.png" width="16px">
			</a></td>
		</tr>
		<%
		}
		}
		%>
		</tbody>
	</table>
	</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3" crossorigin="anonymous"></script>
</html>