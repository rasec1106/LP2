<%@page import="service.UniversidadService"%>
<%@page import="service.EspecialidadService"%>
<%@page import="beans.IngenieroDTO"%>
<%@page import="beans.UniversidadDTO"%>
<%@page import="beans.EspecialidadDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registrar Ingeniero</title>
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

		<div class="container d-flex justify-content-center">
			<div class="card mt-3" style="width: 50%;">
				<div class="card-header">Registrar Ingeniero</div>
				<div class="card-body">
					<form action="ServletIngeniero?tipo=registrar" id="frmregistrar"
						method="post" onsubmit="return(validate())">
						<div class="row mb-2">
							<div class="col row">
								<label for="nombre" class="col-sm-4 col-form-label">Nombre:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control required" name="txt_nom"
										id="nombre" placeholder="Ingrese Nombre">
									<p id="validNombre" class="text-danger" style="font-size: 12px;"></p>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="apellido" class="col-sm-4 col-form-label">Apellido:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control required" name="txt_ape"
										id="apellido" placeholder="Ingrese Apellido">
									<p id="validApellido" class="text-danger" style="font-size: 12px;"></p>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="dni" class="col-sm-4 col-form-label">Dni:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control required" name="txt_dni"
										id="dni" placeholder="Ingrese Dni">
									<p id="validDni" class="text-danger" style="font-size: 12px;"></p>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="sueldo" class="col-sm-4 col-form-label">Sueldo:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control required" name="txt_sue"
										id="sueldo" placeholder="Ingrese Sueldo">
									<p id="validSueldo" class="text-danger" style="font-size: 12px;"></p>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="universidad" class="col-sm-4 col-form-label">Universidad:</label>
								<div class="col-sm-8">
									<select class="form-select" name="cbo_uni" id="universidad">
									<%
									List<UniversidadDTO> universidades = new UniversidadService().listaUniversidad();
									for (UniversidadDTO universidad : universidades) {										
									%>
										<option value="<%=universidad.getCodigo()%>">
											<%=universidad.getNombre()%></option>
										<%
										}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col row">
								<label for="pais" class="col-sm-4 col-form-label">Especialidad:</label>
								<div class="col-sm-8">
									<select class="form-select" name="cbo_esp" id="especialidad">
									<%
									List<EspecialidadDTO> especialidades = new EspecialidadService().listaEspecialidad();
									for (EspecialidadDTO especialidad : especialidades) {
									%>
										<option value="<%=especialidad.getCodigo()%>">
											<%=especialidad.getNombre()%></option>
										<%
										}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row mb-2">
							<div class="col">
								<input type="submit" class="btn btn-success w-100" value="Registrar">
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
<script type="text/javascript" src="./js/validation.js"></script>
</html>