package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.SolicitudDTO;
import interfaces.SolicitudDAO;
import utils.MySqlDBConnection;

public class MySQLSolicitudDAO implements SolicitudDAO{

	@Override
	public List<SolicitudDTO> listarSolicitud() {
		List<SolicitudDTO> data = new ArrayList<SolicitudDTO>();
		SolicitudDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	       cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tabla_Solicitud";
	       pstm = cn.prepareStatement(sql);
	       rs = pstm.executeQuery();
	
	       while (rs.next()) {
	          obj = new SolicitudDTO();
	          obj.setId(rs.getInt(1));
	          obj.setCodigo(rs.getString(2));
	          obj.setIdSolicitante(rs.getInt(3));
	          obj.setMotivo(rs.getString(4));
	          obj.setFecha(rs.getString(5));
	          obj.setIdAlmacen(rs.getInt(6));
	          obj.setIdUsuario(rs.getInt(7));
	          obj.setIdEstado(rs.getInt(8));
	          data.add(obj);
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return data;
	}

	@Override
	public int registrarSolicitud(SolicitudDTO obj) {
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	        String sql = "insert into tabla_Solicitud values(null,?,?,?,?,?,?,?)";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setInt(2, obj.getIdSolicitante());
	        pstm.setString(3, obj.getMotivo());
	        pstm.setString(4, obj.getFecha());
	        pstm.setInt(5, obj.getIdAlmacen());
	        pstm.setInt(6, obj.getIdUsuario());
	        pstm.setInt(7, obj.getIdEstado());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int actualizarSolicitud(SolicitudDTO obj) {
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	    	String sql = "update tabla_Solicitud set cod_solicitud=?, id_solicitante=?, motivo=?, "
	         		+ "fecha_propuesta=?, id_almacen=?, id_usuario=?, id_master_status=? where id_solicitud=?";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setInt(2, obj.getIdSolicitante());
	        pstm.setString(3, obj.getMotivo());
	        pstm.setString(4, obj.getFecha());
	        pstm.setInt(5, obj.getIdAlmacen());
	        pstm.setInt(6, obj.getIdUsuario());
	        pstm.setInt(7, obj.getIdEstado());
	        pstm.setInt(8, obj.getId());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int eliminarSolicitud(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
      
		try {
			cn = MySqlDBConnection.getConnection();
			String sql = "delete from tabla_Solicitud where id_solicitud=?";
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
	public SolicitudDTO buscarSolicitud(int cod) {
		SolicitudDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;

	    try {
	    	cn = MySqlDBConnection.getConnection();
	        String sql = "select * from tabla_Solicitud where id_solicitud=?";
	        pstm = cn.prepareStatement(sql);
	        pstm.setInt(1, cod);
	        rs = pstm.executeQuery();

	        if (rs.next()) {	        	
	        	obj = new SolicitudDTO();
		        obj.setId(rs.getInt(1));
		        obj.setCodigo(rs.getString(2));
		        obj.setIdSolicitante(rs.getInt(3));
		        obj.setMotivo(rs.getString(4));
		        obj.setFecha(rs.getString(5));
		        obj.setIdAlmacen(rs.getInt(6));
		        obj.setIdUsuario(rs.getInt(7));
		        obj.setIdEstado(rs.getInt(8));;
	        }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return obj;
	}

}
