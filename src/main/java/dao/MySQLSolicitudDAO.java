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
	          obj.setMotivo(rs.getString(3));
	          obj.setFecha(rs.getString(4));
	          obj.setIdAlmacen(rs.getInt(5));
	          obj.setIdUsuario(rs.getInt(6));
	          obj.setIdEstado(rs.getInt(7));
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarSolicitud(SolicitudDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarSolicitud(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public SolicitudDTO buscarSolicitud(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

}
