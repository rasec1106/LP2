package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.PaisDTO;
import interfaces.PaisDAO;
import utils.MySqlDBConnection;

public class MySQLPaisDAO implements PaisDAO {

   @Override
   public List<PaisDTO> listarPais() {
      List<PaisDTO> data = new ArrayList<PaisDTO>();
      PaisDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
         cn = MySqlDBConnection.getConnection();
         String sql = "select * from tb_pais";
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new PaisDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setNombre(rs.getString(2));
            obj.setContinente(rs.getString(3));
            data.add(obj);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return data;
   }

}