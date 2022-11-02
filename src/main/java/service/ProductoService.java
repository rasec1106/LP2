package service;

import java.util.List;
import beans.ProductoDTO;
import dao.DAOFactory;
import interfaces.ProductoDAO;
import utils.Constantes;

public class ProductoService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   ProductoDAO objPro = fabrica.getProducto();

   public List<ProductoDTO> listaProducto() {
      return objPro.listarProducto();
   }
}