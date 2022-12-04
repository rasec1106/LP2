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
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	        String sql = "insert into tabla_Almacen values(null,?,?,?,?)";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setString(2, obj.getDireccion());
	        pstm.setString(3, obj.getTelefono());
	        pstm.setDouble(4, obj.getMetrosCuadrados());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int actualizarAlmacen(AlmacenDTO obj) {
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	    	String sql = "update tabla_Almacen set cod_almacen=?, direccion=?, telefono=?, "
	         		+ "metros_cuadrados=? where id_almacen=?";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setString(2, obj.getDireccion());
	        pstm.setString(3, obj.getTelefono());
	        pstm.setDouble(4, obj.getMetrosCuadrados());
	        pstm.setInt(5, obj.getId());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int eliminarAlmacen(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
      
		try {
			cn = MySqlDBConnection.getConnection();
			String sql = "delete from tabla_Almacen where id_almacen=?";
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
	public AlmacenDTO buscarAlmacen(int cod) {
		AlmacenDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	       cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tabla_Almacen where id_almacen=?";
	       pstm = cn.prepareStatement(sql);
	       pstm.setInt(1, cod);
	       rs = pstm.executeQuery();
	
	       while (rs.next()) {
	          obj = new AlmacenDTO();
	          obj.setId(rs.getInt(1));
	          obj.setCodigo(rs.getString(2));
	          obj.setDireccion(rs.getString(3));
	          obj.setTelefono(rs.getString(4));
	          obj.setMetrosCuadrados(rs.getDouble(5));
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return obj;
	}

}
