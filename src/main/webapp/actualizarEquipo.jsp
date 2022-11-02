<%@page import="service.MarcaService"%>
<%@page import="service.PaisService"%>
<%@page import="beans.EquipoDTO"%>
<%@page import="beans.MarcaDTO"%>
<%@page import="beans.PaisDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Actualizar Equipo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
</head>
<body>
	<div class="container">
		<jsp:include page="cabecera.jsp" />
		<%
		EquipoDTO obj = (EquipoDTO) request.getAttribute("equipo");
		%>

		<div class="container d-flex justify-content-center">
			<div class="card mt-3" style="width: 50%;">
				<div class="card-header">Actualizar Equipo</div>
				<div class="card-body">
					<form action="ServletEquipo?tipo=actualizar" id="frmactualizar"
						method="post">
						<input type="hidden" name="txt_cod"
							value="${requestScope.equipo.codigo}">
						<div class="row mb-2">
							<div class="col row">
								<label for="descripcion" class="col-sm-4 col-form-label">Descripcion:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control required" name="txt_des"
										id="descripcion" placeholder="Ingrese Descripcion"
										value="${requestScope.equipo.descripcion}">
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="precio" class="col-sm-4 col-form-label">Precio:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control required" name="txt_pre"
										id="precio" placeholder="Ingrese Precio"
										value="${requestScope.equipo.precio}">
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="stock" class="col-sm-4 col-form-label">Stock:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control required" name="txt_stock"
										id="stock" placeholder="Ingrese Stock"
										value="${requestScope.equipo.stock}">
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="marca" class="col-sm-4 col-form-label">Marca:</label>
								<div class="col-sm-8">
									<select class="form-select" name="cbo_marca" id="marca">
									<%
										List<MarcaDTO> marcas = new MarcaService().listaMarca();
										String estadoMarca = "";
										for (MarcaDTO marca : marcas) {
											if (obj.getCodMarca() == marca.getCodigo()) {
												estadoMarca = "selected";
											} else {
												estadoMarca = "";
											}
										%>
										<option value="<%=marca.getCodigo()%>" <%=estadoMarca%>>
											<%=marca.getNombre()%></option>
										<%
										}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="pais" class="col-sm-4 col-form-label">Pais:</label>
								<div class="col-sm-8">
									<select class="form-select" name="cbo_pais" id="pais">
									<%
										List<PaisDTO> paises = new PaisService().listaPais();
										String estadoPais = "";
										for (PaisDTO pais : paises) {
											if (obj.getCodPais() == pais.getCodigo()) {
												estadoPais = "selected";
											} else {
												estadoPais = "";
											}
										%>
										<option value="<%=pais.getCodigo()%>" <%=estadoPais%>>
											<%=pais.getNombre()%></option>
										<%
										}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col">
								<input type="submit" class="btn btn-success w-100" value="Actualizar">
							</div>
						</div>
						
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
</html>