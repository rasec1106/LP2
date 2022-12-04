package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.UsuarioDTO;
import interfaces.UsuarioDAO;
import utils.MySqlDBConnection;

public class MySQLUsuarioDAO implements UsuarioDAO{

	@Override
	public List<UsuarioDTO> listarUsuario() {
		List<UsuarioDTO> data = new ArrayList<UsuarioDTO>();
		UsuarioDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	       cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tabla_Usuario";
	       pstm = cn.prepareStatement(sql);
	       rs = pstm.executeQuery();
	
	       while (rs.next()) {
	          obj = new UsuarioDTO();
	          obj.setId(rs.getInt(1));
	          obj.setCodigo(rs.getString(2));
	          obj.setDni(rs.getString(3));
	          obj.setNombres(rs.getString(4));
	          obj.setApellidoPaterno(rs.getString(5));
	          obj.setApellidoMaterno(rs.getString(6));
	          obj.setEmail(rs.getString(7));
	          obj.setDireccion(rs.getString(8));
	          obj.setUrlImagen(rs.getString(9));
	          obj.setCargo(rs.getString(10));
	          obj.setUsuario(rs.getString(11));
	          obj.setClave(rs.getString(12));
	          data.add(obj);
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return data;
	}

	@Override
	public int registrarUsuario(UsuarioDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarUsuario(UsuarioDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarUsuario(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UsuarioDTO buscarUsuario(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

}
