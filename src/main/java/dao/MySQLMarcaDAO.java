package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.MarcaDTO;
import interfaces.MarcaDAO;
import utils.MySqlDBConnection;

public class MySQLMarcaDAO implements MarcaDAO {

   @Override
   public List<MarcaDTO> listarMarca() {
      List<MarcaDTO> data = new ArrayList<MarcaDTO>();
      MarcaDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
         cn = MySqlDBConnection.getConnection();
         String sql = "select * from tb_marca";
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new MarcaDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setNombre(rs.getString(2));
            obj.setCategoria(rs.getString(3));
            data.add(obj);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return data;
   }
}