function validate(){
	let nombre = document.getElementById("nombre").value;
	let apellido = document.getElementById("apellido").value;
	let dni = document.getElementById("dni").value;
	let sueldo = document.getElementById("sueldo").value;
	
	let estado = true;	
	clearValidationFields();
	
	if(nombre.length > 50 || nombre.length < 3){
		document.getElementById("validNombre").innerHTML="El campo debe contener entre 3 y 25 caracteres";
		estado = false;
	}
	if(apellido.length > 50 || apellido.length < 3){
		document.getElementById("validApellido").innerHTML="El campo debe contener entre 3 y 25 caracteres";
		estado = false;
	}
	if(! /^\d{8}$/.test(dni)){
		document.getElementById("validDni").innerHTML="El DNI tiene un formato invalido. (deben ser 8 numeros)";
		estado = false;		
	}
	if(! /^\d+(\.\d{0,2}){0,1}$/.test(sueldo)){
		document.getElementById("validSueldo").innerHTML="El Sueldo debe ser un numero entero o un numero con hasta 2 decimales";
		estado = false;		
	}else{
		if(sueldo <= 0){
			document.getElementById("validSueldo").innerHTML="El Sueldo debe ser mayor a 0";
			estado = false;		
		}
	}					
	
	return estado;
}

function clearValidationFields(){
	document.getElementById("validNombre").innerHTML="";
	document.getElementById("validApellido").innerHTML="";
	document.getElementById("validDni").innerHTML="";
	document.getElementById("validSueldo").innerHTML="";
}