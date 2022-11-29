package utils;

import java.util.ArrayList;
import beans.IngenieroDTO;

public class Utils {
	
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
}
