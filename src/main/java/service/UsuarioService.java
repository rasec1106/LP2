package service;

import java.util.List;
import beans.UsuarioDTO;
import dao.DAOFactory;
import interfaces.UsuarioDAO;
import utils.Constantes;

public class UsuarioService {

   DAOFactory fabrica = DAOFactory.getDAOFactory(Constantes.ORIGEN_DE_DATOS_MYSQL);
   UsuarioDAO objPro = fabrica.getUsuario();

   public List<UsuarioDTO> listaUsuario() {
	      return objPro.listarUsuario();
   }
   
   public int registraUsuario(UsuarioDTO obj) {
      return objPro.registrarUsuario(obj);
   }

   public int actualizaUsuario(UsuarioDTO obj) {
      return objPro.actualizarUsuario(obj);
   }

   public int eliminaUsuario(int cod) {
      return objPro.eliminarUsuario(cod);
   }

   public UsuarioDTO buscaUsuario(int cod) {
      return objPro.buscarUsuario(cod);
   }
   
   public UsuarioDTO logueaUsuario(String usuario, String clave) {
	      return objPro.loginUsuario(usuario, clave);
	   }
}