package service;

import java.util.List;

import beans.PaisDTO;
import dao.DAOFactory;
import interfaces.PaisDAO;
import utils.Constantes;

public class PaisService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   PaisDAO objPro = fabrica.getPais();

   public List<PaisDTO> listaPais() {
	      return objPro.listarPais();
   }
   
}