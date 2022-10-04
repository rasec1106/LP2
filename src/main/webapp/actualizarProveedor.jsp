<%@ page import="entidad.Proveedor"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<title>Actualizar Proveedor</title>
<!-- CSS only -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<%
	Proveedor a = (Proveedor) request.getAttribute("registro");
	%>
	<div class="container d-flex justify-content-center">
		<div class="card mt-3" style="width: 75%;">
			<div class="card-header">Actualizar Proveedor</div>
			<div class="card-body">				
				<form action="ServletProveedor?tipo=actualizar" id="frmActualizar"
					method="post" onsubmit="return(validate())">
					<input type="hidden" name="codigo" value="<%=a.getCodigo()%>">
					<div class="row mb-2">
						<div class="col">
							<label for="razonSocial" class="form-label">Razon Social:</label>
							<input type="text" class="form-control required" name="txt_raz" value="<%=a.getRazonSocial()%>"
								id="razonSocial" placeholder="Ingrese Razon Social">
							<p id="validRazonSocial" class="text-danger"
								style="font-size: 12px;"></p>
						</div>
						<div class="col">
							<label for="ruc" class="form-label">Ruc:</label> <input
								type="text" class="form-control required" name="txt_ruc" value="<%=a.getRuc()%>"
								id="ruc" placeholder="Ingrese RUC">
							<p id="validRuc" class="text-danger" style="font-size: 12px;"></p>
						</div>
					</div>
					<div class="row mb-2">
						<div class="col">
							<label for="direccion" class="form-label">Direccion:</label> <input
								type="text" class="form-control required" name="txt_dir" value="<%=a.getDireccion()%>"
								id="direccion" placeholder="Ingrese Direccion">
							<p id="validDireccion" class="text-danger"
								style="font-size: 12px;"></p>
						</div>
					</div>
					<div class="row mb-2">
						<div class="col">
							<label for="nombre" class="form-label">Nombre:</label> <input
								type="text" class="form-control required" name="txt_nom" value="<%=a.getNombre()%>"
								id="nombre" placeholder="Ingrese Nombre de contacto">
							<p id="validNombre" class="text-danger" style="font-size: 12px;"></p>
						</div>
					</div>
					<div class="row mb-2">
						<div class="col">
							<label for="dni" class="form-label">Dni:</label> <input
								type="text" class="form-control required" name="txt_dni" value="<%=a.getDni()%>"
								id="dni" placeholder="Ingrese DNI de contacto">
							<p id="validDni" class="text-danger" style="font-size: 12px;"></p>
						</div>
						<div class="col">
							<label for="celular" class="form-label">Celular:</label> <input
								type="text" class="form-control required" name="txt_cel" value="<%=a.getCelular()%>"
								id="celular" placeholder="Ingrese numero de celular">
							<p id="validCelular" class="text-danger" style="font-size: 12px;"></p>
						</div>
					</div>
					<div class="row mb-2">
						<div class="col">
							<label for="fechaNacimiento" class="form-label">Fecha de
								Nacimiento:</label> <input type="text" class="form-control required"
								name="txt_fec" id="fechaNacimiento" value="<%=a.getFecNacimiento()%>"
								placeholder="Ingrese fecha de nacimiento en formato yyyy-mm-dd">
							<p id="validFecha" class="text-danger" style="font-size: 12px;"></p>
						</div>
					</div>
					<div class="row mb-2">
						<div class="col d-flex justify-content-center">
							<button type="submit" class="btn btn-success w-100">Actualizar</button>
						</div>
					</div>
				</form>
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