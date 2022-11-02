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
         String sql = "select p.cod_pro, p.des_pro, p.pre_pro, p.stock_pro, m.nom_mar from tb_producto p inner join tb_marca m on p.cod_mar = m.cod_mar";
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new ProductoDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setDescripcion(rs.getString(2));
            obj.setPrecio(rs.getDouble(3));
            obj.setStock(rs.getInt(4));
            obj.setNomMarca(rs.getString(5));
            data.add(obj);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return data;
   }

   @Override
   public ProductoDTO buscarProducto(int cod) {
      ProductoDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
    	 cn = MySqlDBConnection.getConnection();
         String sql = "select * from tb_producto where cod_pro=?";
         pstm = cn.prepareStatement(sql);
         pstm.setInt(1, cod);
         rs = pstm.executeQuery();

         if (rs.next()) {
            obj = new ProductoDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setDescripcion(rs.getString(2));
            obj.setPrecio(rs.getDouble(3));
            obj.setStock(rs.getInt(4));
            obj.setNomMarca(rs.getString(5));
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return obj;
   }
	
   @Override
   public int registrarProducto(ProductoDTO obj) {
      int estado = -1;
      Connection cn = null;
      PreparedStatement pstm = null;

      try {
    	 cn = MySqlDBConnection.getConnection();
         String sql = "insert into tb_producto values(null,?,?,?,?)";
         pstm = cn.prepareStatement(sql);
         pstm.setString(1, obj.getDescripcion());
         pstm.setDouble(2, obj.getPrecio());
         pstm.setInt(3, obj.getStock());
         pstm.setInt(4, obj.getCodMarca());
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
	         String sql = "update tb_producto set des_pro=?, pre_pro=?, stock_pro=?, cod_mar=? where cod_pro=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getDescripcion());
	         pstm.setDouble(2, obj.getPrecio());
	         pstm.setInt(3, obj.getStock());
	         pstm.setInt(4, obj.getCodMarca());
	         pstm.setInt(5, obj.getCodigo());
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
	         String sql = "delete from tb_producto where cod_pro=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setInt(1, cod);
	         estado = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;
	   }
}