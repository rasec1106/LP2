<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form>
		<fieldset style="width: 400px;">
			<legend>Registrar Empleado</legend>
			<table border="0" width="100%">
				<tr>
					<td>Nombres:</td>
					<td><input type="text" name="txt_nom" required autofocus
						placeholder="Ingresar nombre"></td>
				</tr>
				<tr>
					<td>Apellido Paterno:</td>
					<td><input type="text" name="txt_ape_pat" required autofocus
						placeholder="Ingresar paterno"></td>
				</tr>
				<tr>
					<td>Apellido Materno:</td>
					<td><input type="text" name="txt_ape_mat" required autofocus
						placeholder="Ingresar materno"></td>
				</tr>
				<tr>
					<td>Sexo:</td>
					<td><select name="cbo_sexo" style="width: 165px;">
							<option>Masculino</option>
							<option>Femenino</option>
					</select></td>
				</tr>
				<tr>
					<td>Dni:</td>
					<td><input type="text" name="txt_dni" required autofocus
						placeholder="Ingresar dni"></td>
				</tr>
				<tr>
					<td>Fecha Registro:</td>
					<td><input type="date" name="txt_fecha" required></td>
				</tr>
				<tr>
					<td>Telefono:</td>
					<td><input type="text" name="txt_telefono" required autofocus
						placeholder="Ingresar celular"></td>
				</tr>
				<tr>
					<td>Correo:</td>
					<td><input type="text" name="txt_correo" required autofocus
						placeholder="Ingresar correo"></td>
				</tr>
				<tr>
					<td>Tipo Empleado:</td>
					<td><select name="cbo_tipo" style="width: 165px;">
							<option>Secretaria</option>
							<option>Gerente</option>
					</select></td>
				</tr>
				<tr>
					<td>Direccion:</td>
					<td><input type="text" name="txt_direccion" required autofocus
						placeholder="Ingresar direccion"></td>
				</tr>
				<tr>
					<td>Distrito:</td>
					<td><select name="cbo_distrito" style="width: 165px;">
							<option>Comas</option>
							<option>SJL</option>
					</select></td>
				</tr>
				<tr>
					<td>Foto:</td>
					<td><input type="file" name="txt_foto"></td>
				</tr>
				<tr height="60px">
					<td colspan="2" align="center">
						<button type="submit" value="Grabar">
							<img src="img/diskette.png" width="16px"> Grabar
						</button>
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
</body>
</html>