package interfaces;

import java.util.List;

import beans.UsuarioDTO;

public interface UsuarioDAO {
	public List<UsuarioDTO> listarUsuario();
	public int registrarUsuario(UsuarioDTO obj);
	public int actualizarUsuario(UsuarioDTO obj);
	public int eliminarUsuario(int cod);
	public UsuarioDTO buscarUsuario(int cod);
	public UsuarioDTO loginUsuario(String usuario, String clave);
}
