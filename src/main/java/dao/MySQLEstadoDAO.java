package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import beans.EstadoDTO;
import interfaces.EstadoDAO;
import utils.MySqlDBConnection;

public class MySQLEstadoDAO implements EstadoDAO{

	@Override
	public List<EstadoDTO> listarEstado() {
		List<EstadoDTO> data = new ArrayList<EstadoDTO>();
		EstadoDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	       cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tabla_MasterStatus";
	       pstm = cn.prepareStatement(sql);
	       rs = pstm.executeQuery();
	
	       while (rs.next()) {
	          obj = new EstadoDTO();
	          obj.setId(rs.getInt(1));
	          obj.setNombre(rs.getString(2));
	          obj.setDescripcion(rs.getString(3));
	          data.add(obj);
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return data;
	}

}
