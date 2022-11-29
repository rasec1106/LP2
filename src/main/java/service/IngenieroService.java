package service;

import java.util.List;
import beans.IngenieroDTO;
import dao.DAOFactory;
import interfaces.IngenieroDAO;
import utils.Constantes;

public class IngenieroService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   IngenieroDAO objPro = fabrica.getIngeniero();

   public List<IngenieroDTO> listaIngeniero() {
	      return objPro.listarIngeniero();
   }
   
   public int registraIngeniero(IngenieroDTO obj) {
      return objPro.registrarIngeniero(obj);
   }

   public int actualizaIngeniero(IngenieroDTO obj) {
      return objPro.actualizarIngeniero(obj);
   }

   public int eliminaIngeniero(int cod) {
      return objPro.eliminarIngeniero(cod);
   }

   public IngenieroDTO buscaIngeniero(int cod) {
      return objPro.buscarIngeniero(cod);
   }
}