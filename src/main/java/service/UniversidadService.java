package service;

import java.util.List;

import beans.UniversidadDTO;
import dao.DAOFactory;
import interfaces.UniversidadDAO;
import utils.Constantes;

public class UniversidadService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   UniversidadDAO objPro = fabrica.getUniversidad();

   public List<UniversidadDTO> listaUniversidad() {
	      return objPro.listarUniversidad();
   }

}