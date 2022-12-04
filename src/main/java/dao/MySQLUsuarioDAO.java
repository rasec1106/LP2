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
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	        String sql = "insert into tabla_Usuario values(null,?,?,?,?,?,?,?,?,?,?,?)";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setString(2, obj.getDni());
	        pstm.setString(3, obj.getNombres());
	        pstm.setString(4, obj.getApellidoPaterno());
	        pstm.setString(5, obj.getApellidoMaterno());
	        pstm.setString(6, obj.getEmail());
	        pstm.setString(7, obj.getDireccion());
	        pstm.setString(8, obj.getUrlImagen());
	        pstm.setString(9, obj.getCargo());
	        pstm.setString(10, obj.getUsuario());
	        pstm.setString(11, obj.getClave());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int actualizarUsuario(UsuarioDTO obj) {
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	    	String sql = "update tabla_Usuario set cod_usuario=?, dni=?, nombres=?, "
	         		+ "apellido_paterno=?, apellido_materno=?, email=?, direccion=?, "
	         		+ "url_imagen=?, cargo=?, usuario=?, clave=? where id_usuario=?";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setString(2, obj.getDni());
	        pstm.setString(3, obj.getNombres());
	        pstm.setString(4, obj.getApellidoPaterno());
	        pstm.setString(5, obj.getApellidoMaterno());
	        pstm.setString(6, obj.getEmail());
	        pstm.setString(7, obj.getDireccion());
	        pstm.setString(8, obj.getUrlImagen());
	        pstm.setString(9, obj.getCargo());
	        pstm.setString(10, obj.getUsuario());
	        pstm.setString(11, obj.getClave());
	        pstm.setInt(12, obj.getId());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int eliminarUsuario(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
      
		try {
			cn = MySqlDBConnection.getConnection();
			String sql = "delete from tabla_Usuario where id_usuario=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, cod);
			estado = pstm.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return estado;
	}

	@Override
	public UsuarioDTO buscarUsuario(int cod) {
		UsuarioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConnection.getConnection();
		    String sql = "select * from tabla_Usuario where id_usuario=?";
		    pstm = cn.prepareStatement(sql);
		    pstm.setInt(1, cod);
		    rs = pstm.executeQuery();
		
		    if (rs.next()) {
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
		     }
		}
		catch (Exception e) {
		   e.printStackTrace();
		}
		return obj;
	}

	@Override
	public UsuarioDTO loginUsuario(String usuario, String clave) {
		UsuarioDTO obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try {
			cn = MySqlDBConnection.getConnection();
		    String sql = "select * from tabla_Usuario where usuario=? and clave=?";
		    pstm = cn.prepareStatement(sql);
		    pstm.setString(1, usuario);
		    pstm.setString(2, clave);
		    rs = pstm.executeQuery();
		
		    if (rs.next()) {
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
		     }
		}
		catch (Exception e) {
		   e.printStackTrace();
		}
		return obj;
	}

}
