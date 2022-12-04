package service;

import java.util.List;
import beans.SolicitudDTO;
import dao.DAOFactory;
import interfaces.SolicitudDAO;
import utils.Constantes;

public class SolicitudService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   SolicitudDAO objPro = fabrica.getSolicitud();

   public List<SolicitudDTO> listaSolicitud() {
	      return objPro.listarSolicitud();
   }
   
   public int registraSolicitud(SolicitudDTO obj) {
      return objPro.registrarSolicitud(obj);
   }

   public int actualizaSolicitud(SolicitudDTO obj) {
      return objPro.actualizarSolicitud(obj);
   }

   public int eliminaSolicitud(int cod) {
      return objPro.eliminarSolicitud(cod);
   }

   public SolicitudDTO buscaSolicitud(int cod) {
      return objPro.buscarSolicitud(cod);
   }

}