package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.UniversidadDTO;
import interfaces.UniversidadDAO;
import utils.MySqlDBConnection;

public class MySQLUniversidadDAO implements UniversidadDAO {

   @Override
   public List<UniversidadDTO> listarUniversidad() {
      List<UniversidadDTO> data = new ArrayList<UniversidadDTO>();
      UniversidadDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
         cn = MySqlDBConnection.getConnection();
         String sql = "select * from tb_universidad";
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new UniversidadDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setNombre(rs.getString(2));
            data.add(obj);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return data;
   }
}