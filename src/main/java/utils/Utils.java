package utils;

import java.util.ArrayList;
import beans.UsuarioDTO;

public class Utils {
	
	public static UsuarioDTO currentUser = null;
/*	
	public static int ingenierosPorEspecialidad(ArrayList<IngenieroDTO> lista, int codEspecialidad) {
		int contador = 0;
		for(IngenieroDTO ing:lista) {
			if(ing.getCodEspecialidad() == codEspecialidad) contador++;
		}
		return contador;
	}
	
	public static double sumaSueldosPorEspecialidad(ArrayList<IngenieroDTO> lista, int codEspecialidad) {
		double acumulador = 0;
		for(IngenieroDTO ing:lista) {
			if(ing.getCodEspecialidad() == codEspecialidad) {
				acumulador += ing.getSueldo();
			}
		}
		return acumulador;
	}
	*/
	public static UsuarioDTO getCurrentUser() {
		return currentUser;
	}
	
	public static void setCurrentUser(UsuarioDTO usuario) {
		currentUser = usuario;
	}
}
