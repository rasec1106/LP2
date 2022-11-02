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
}