<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-type" content="text/html" charset="UTF-8">
<title>Practica Calificada 03</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<jsp:include page="cabecera.jsp" />
		<div class="row my-5">
			<div class="col w-100 text-center">
				<h1>Practica Calificada 03 de Lenguajes de Programacion</h1>
			</div>
		</div>
		<div class="row my-5">
			<div class="col w-100 text-center">
				<h3>Alumno: Cesar Humberto Herrera Villacorta</h3>
			</div>
		</div>
		<div class="row justify-content-center">
			<div class="col-auto d-flex justify-content-center">
				<a href="ServletIngeniero?tipo=listar" class="btn btn-primary">Listar
					Ingenieros</a>

			</div>
			<div class="col-auto d-flex justify-content-center">
				<a href="#" class="btn btn-outline-primary disabled">Listar Universidades</a>
			</div>
			<div class="col-auto d-flex justify-content-center">
				<a href="#" class="btn btn-outline-primary disabled">Listar Especialidades</a>
			</div>
		</div>
	</div>
</body>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
	crossorigin="anonymous"></script>
</html>