package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.AlmacenDTO;
import interfaces.AlmacenDAO;
import utils.MySqlDBConnection;

public class MySQLAlmacenDAO implements AlmacenDAO{

	@Override
	public List<AlmacenDTO> listarAlmacen() {
		List<AlmacenDTO> data = new ArrayList<AlmacenDTO>();
		AlmacenDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	       cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tabla_Almacen";
	       pstm = cn.prepareStatement(sql);
	       rs = pstm.executeQuery();
	
	       while (rs.next()) {
	          obj = new AlmacenDTO();
	          obj.setId(rs.getInt(1));
	          obj.setCodigo(rs.getString(2));
	          obj.setDireccion(rs.getString(3));
	          obj.setTelefono(rs.getString(4));
	          obj.setMetrosCuadrados(rs.getDouble(5));
	          data.add(obj);
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return data;
	}

	@Override
	public int registrarAlmacen(AlmacenDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int actualizarAlmacen(AlmacenDTO obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int eliminarAlmacen(int cod) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AlmacenDTO buscarAlmacen(int cod) {
		// TODO Auto-generated method stub
		return null;
	}

}
