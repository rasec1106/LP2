package service;

import java.util.List;
import beans.EquipoDTO;
import dao.DAOFactory;
import interfaces.EquipoDAO;
import utils.Constantes;

public class EquipoService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   EquipoDAO objPro = fabrica.getEquipo();

   public List<EquipoDTO> listaEquipo() {
	      return objPro.listarEquipo();
   }
   
   public List<EquipoDTO> buscarPrecio(double precio) {
	      return objPro.buscarPorPrecio(precio);
   }

   public EquipoDTO buscaEquipo(int cod) {
      return objPro.buscarEquipo(cod);
   }

   public int registraEquipo(EquipoDTO obj) {
      return objPro.registrarEquipo(obj);
   }

   public int actualizaEquipo(EquipoDTO obj) {
      return objPro.actualizarEquipo(obj);
   }

   public int eliminaEquipo(int cod) {
      return objPro.eliminarEquipo(cod);
   }
}