function validate(){
	let razonSocial = document.getElementById("razonSocial").value;
	let ruc = document.getElementById("ruc").value;
	let direccion = document.getElementById("direccion").value;
	let nombre = document.getElementById("nombre").value;
	let dni = document.getElementById("dni").value;
	let celular = document.getElementById("celular").value;
	let fechaNacimiento = document.getElementById("fechaNacimiento").value;
	
	let estado = true;	
	clearValidationFields();
	
	if(razonSocial.length > 100 || razonSocial.length < 6){
		document.getElementById("validRazonSocial").innerHTML="El campo debe contener entre 6 y 100 caracteres";
		estado = false;
	}
	if(! /^\d{11}$/.test(ruc)){
		document.getElementById("validRuc").innerHTML="El RUC tiene un formato invalido. (deben ser 11 numeros)";
		estado = false;		
	}
	if(direccion.length > 200 || direccion.length < 10){
		document.getElementById("validDireccion").innerHTML="El campo debe contener entre 10 y 200 caracteres";
		estado = false;
	}
	if(nombre.length > 50 || nombre.length < 6){
		document.getElementById("validNombre").innerHTML="El campo debe contener entre 6 y 50 caracteres";
		estado = false;
	}
	if(! /^\d{8}$/.test(dni)){
		document.getElementById("validDni").innerHTML="El DNI tiene un formato invalido. (deben ser 8 numeros)";
		estado = false;		
	}
	if(! /^\d{9}$/.test(celular)){
		document.getElementById("validCelular").innerHTML="El celular debe contener 9 digitos";
		estado = false;		
	}else if(celular.charAt(0) != '9'){
		document.getElementById("validCelular").innerHTML="El celular debe comenzar por 9...";
		estado = false;		
	}
	if(! /^[1-2]\d{3}-[0-1]\d-[0-3]\d$/.test(fechaNacimiento)){
		document.getElementById("validFecha").innerHTML="El formato de fecha es incorrecto. (debe ser yyyy-mm-dd)";
		estado = false;		
	}
	
	if(estado){
		alert("Se ingreso correctamente un nuevo registro");
	}
	
	return estado;
}

function clearValidationFields(){
	document.getElementById("validRazonSocial").innerHTML="";
	document.getElementById("validRuc").innerHTML="";
	document.getElementById("validDireccion").innerHTML="";
	document.getElementById("validNombre").innerHTML="";
	document.getElementById("validDni").innerHTML="";
	document.getElementById("validCelular").innerHTML="";
	document.getElementById("validFecha").innerHTML="";
}