package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.ProductoDTO;
import interfaces.ProductoDAO;
import utils.MySqlDBConnection;

public class MySQLProductoDAO implements ProductoDAO {

	@Override
	public List<ProductoDTO> listarProducto() {
		List<ProductoDTO> data = new ArrayList<ProductoDTO>();
		ProductoDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	       cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tabla_Producto";
	       pstm = cn.prepareStatement(sql);
	       rs = pstm.executeQuery();
	
	       while (rs.next()) {
	          obj = new ProductoDTO();
	          obj.setId(rs.getInt(1));
	          obj.setCodigo(rs.getString(2));
	          obj.setNombre(rs.getString(3));
	          obj.setCategoria(rs.getString(4));
	          obj.setPrecio(rs.getDouble(5));
	          data.add(obj);
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return data;
	}

	@Override
	public int registrarProducto(ProductoDTO obj) {
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	        String sql = "insert into tabla_Producto values(null,?,?,?,?)";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setString(2, obj.getNombre());
	        pstm.setString(3, obj.getCategoria());
	        pstm.setDouble(4, obj.getPrecio());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int actualizarProducto(ProductoDTO obj) {
		int estado = -1;
	    Connection cn = null;
	    PreparedStatement pstm = null;

	    try {	    	
	    	cn = MySqlDBConnection.getConnection();
	    	String sql = "update tabla_Producto set cod_barra=?, nombre_producto=?, categoria=?, "
	         		+ "precio=? where id_producto=?";
	        pstm = cn.prepareStatement(sql);
	        pstm.setString(1, obj.getCodigo());
	        pstm.setString(2, obj.getNombre());
	        pstm.setString(3, obj.getCategoria());
	        pstm.setDouble(4, obj.getPrecio());
	        pstm.setInt(5, obj.getId());
	        estado = pstm.executeUpdate();
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return estado;
	}

	@Override
	public int eliminarProducto(int cod) {
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
      
		try {
			cn = MySqlDBConnection.getConnection();
			String sql = "delete from tabla_Producto where id_producto=?";
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
	public ProductoDTO buscarProducto(int cod) {
		ProductoDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	       cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tabla_Producto where id_producto=?";
	       pstm = cn.prepareStatement(sql);
	       pstm.setInt(1, cod);
	       rs = pstm.executeQuery();
	
	       while (rs.next()) {
	          obj = new ProductoDTO();
	          obj.setId(rs.getInt(1));
	          obj.setCodigo(rs.getString(2));
	          obj.setNombre(rs.getString(3));
	          obj.setCategoria(rs.getString(4));
	          obj.setPrecio(rs.getDouble(5));
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return obj;
	}

}
