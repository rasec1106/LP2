package service;

import java.util.List;

import beans.MarcaDTO;
import dao.DAOFactory;
import interfaces.MarcaDAO;
import utils.Constantes;

public class MarcaService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   MarcaDAO objPro = fabrica.getMarca();

   public List<MarcaDTO> listaMarca() {
	      return objPro.listarMarca();
   }

}