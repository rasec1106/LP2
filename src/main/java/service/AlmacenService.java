package service;

import java.util.List;
import beans.AlmacenDTO;
import dao.DAOFactory;
import interfaces.AlmacenDAO;
import utils.Constantes;

public class AlmacenService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   AlmacenDAO objPro = fabrica.getAlmacen();

   public List<AlmacenDTO> listaAlmacen() {
	      return objPro.listarAlmacen();
   }
   
   public int registraAlmacen(AlmacenDTO obj) {
      return objPro.registrarAlmacen(obj);
   }

   public int actualizaAlmacen(AlmacenDTO obj) {
      return objPro.actualizarAlmacen(obj);
   }

   public int eliminaAlmacen(int cod) {
      return objPro.eliminarAlmacen(cod);
   }

   public AlmacenDTO buscaAlmacen(int cod) {
      return objPro.buscarAlmacen(cod);
   }

}