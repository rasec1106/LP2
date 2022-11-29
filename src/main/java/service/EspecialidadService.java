package service;

import java.util.List;

import beans.EspecialidadDTO;
import dao.DAOFactory;
import interfaces.EspecialidadDAO;
import utils.Constantes;

public class EspecialidadService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   EspecialidadDAO objPro = fabrica.getEspecialidad();

   public List<EspecialidadDTO> listaEspecialidad() {
	      return objPro.listarEspecialidad();
   }
   
   public EspecialidadDTO buscaEspecialidad(int cod) {
	      return objPro.buscarEspecialidad(cod);
	   }
   
}