<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico">

<title>Login</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link href="signin.css" rel="stylesheet">
</head>

<body class="text-center">
	<div class="container d-flex justify-content-center">
		<div class="card mt-3" style="width: 50%;">
			<div class="card-header">Acceder al sistema</div>
			<div class="row g-0">
				<div class="col-md-4">
					<img
						src="data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAOEAAADhCAMAAAAJbSJIAAAAkFBMVEUAO13///8AMlgAN1zk6e0ALlXc4+eYp7MAOV3X3+QAKFF2jJ3V3+ZshpkjUW/7/f21w80AL1UAIE0AJU8AM1ceTWwAI07G0df3+vwVR2emtsAAJ1AAH06/ytM3WXVFZX0IQGGGm6pcdoyBk6Nje5Hs8fKjs71BYXxWbINZboUAGUlrh5ptgJOLn60gUnGaq7g+11aGAAAEP0lEQVR4nO3bDXeaOhwGcEiMDcEXEETwBSyW6na7y/f/dgMloK4U0d1rsj2/c7pzUqknz/6QBA2GAQAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAfw0SzGaCypYvZuuVL1ucBevA5bLJvHXA6PUbqI7ZQ3O6id1Ty00WpmmNxalFt8vMzHJaRWSvAzN05v7nb6Qqb2keJaRskfTUykUZim+zY2tEjhGFc2xlsVZV9KtIZnYsGw2r5r5M4TlVK2dFi4yr1mj23D73IzZVt820OPmILVvLMvB2WrXCoGitFvLFiHe9rUK8oez2rrgS3R+ytVgVJ+leJjSPFR2c/2doQ9SF+ShruJMtp6ghn9c19IpDPUu+GOtUwzrTtCwTj2SIt7JMdSanqKjBZIEzra5DYzY6dXt8nC7Y66m1mZVlonFVQuM4soqhhidp0W/qFOPnQM6AYldMEOE7O7XI3pqa08XkFInzTXHoMGVP6uq9uJgfEurKJuPJIRLyQiMs/hbXqxgqJt/2hPz/fXwU98+ncE79yxd566EAAJ04Z4xzyj/9uf4Vb35d/Cv0mDFI9D4c3MeyhQYrN5LIW6V7bNSvIo8eCWia78pHZC8PBTTDSPXJv7lvupPyC3AxejDhP6ovUB9OONYlYWYNe9ItobMmvbBoqltC0e/v6BwJVYGEbZBQHUjYBgnVgYRtkFAdSNgGCdWBhG2QUB11wtmffo8/Gtv9yL0N2iS8GxI+HRIiIRI+n0xo/XjpJ9ctofOd9SK0m/H/glUbEl6pE2rzDemmb8JYmxpW3+MvvH5/R5NqLFX/e/xql/6g555m8lEl3Ku+F4O9nzoa9jzZ6v38E9V3RdUPiMSE9hHI2huqJ6T7KuEumvTxb1athZTfEyUfarqX+ru+DPbYpqg31YfS5tmK+4Rb1S/D8kKcdgdp1XcafYrA6g7SSvkVTcm1u4O0CXuu9Z6EyT20mXWj+lm+XP2RtFRvog0jdtPH3d/lQ6VTDcaZEieyiBa5pceifjwx1+MkLa7E5onKoPNgzg7y6Gz73/ftN2H1B27Ldeexzexi63EVlvy47rXT8QSFONR7+zfdBVcHa2aMReS2H8eD+oQ2M30qWJo5Tc/TWVsZ3W1zmJmovyI9x8nZAnwTrT7pPXfX9tl9yFivEpbPjJ4v3pyYsctC+ozbg7MjdjosSC9R4+IbDOs1dj1G/AJhwotS5+I+cqfTKCNRcnWnONi87D7SQ2q/Lq2r22R79eze3oWz3LxJlnwx3KrNS2/5SGNB9BpFL1xMBy0FtD09ltstuEi+/twm32p7hkpk1Z4xzA0dHovt5Hvzl+GvH96Ei7EmTzbfgDIR286wGXYGVv4WeTp8JnM7TgTbTpJ0PH5L93NDMI3Hz3acU58Q4lP+J1x8AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAABwv59QJkp2Ke+UqwAAAABJRU5ErkJggg=="
						class="img-fluid rounded-start" alt="...">
				</div>
				<div class="col-md-8">
					<div class="card-body">
						<form action="ServletUsuario?tipo=login" id="frmregistrar"
							method="post">
							<div class="row mb-2">
								<div class="col row">
									<label for="usuario" class="col-sm-4 col-form-label">Usuario:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control required"
											name="txt_usr" id="usuario" placeholder="Ingrese Usuario">
										<p id="validUsuario" class="text-danger"
											style="font-size: 12px;"></p>
									</div>
								</div>
							</div>
							<div class="row mb-2">
								<div class="col row">
									<label for="clave" class="col-sm-4 col-form-label">Password:</label>
									<div class="col-sm-8">
										<input type="text" class="form-control required"
											name="txt_clv" id="clave" placeholder="Ingrese Clave">
										<p id="validClave" class="text-danger"
											style="font-size: 12px;"></p>
									</div>
								</div>
							</div>
							<div class="row mb-2">
								<div class="col">
									<input type="submit" class="btn btn-success w-100"
										value="Login">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div class="row g-0">
					<div class="col">
					<a href="registrarUsuario.jsp">Nuevo en el sistema? Registrate!!!</a>
					</div>
			</div>
		</div>
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
</html>
