package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.EspecialidadDTO;
import interfaces.EspecialidadDAO;
import utils.MySqlDBConnection;

public class MySQLEspecialidadDAO implements EspecialidadDAO {

   @Override
   public List<EspecialidadDTO> listarEspecialidad() {
      List<EspecialidadDTO> data = new ArrayList<EspecialidadDTO>();
      EspecialidadDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
         cn = MySqlDBConnection.getConnection();
         String sql = "select * from tb_especialidad";
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new EspecialidadDTO();
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

	@Override
	public EspecialidadDTO buscarEspecialidad(int cod) {
		EspecialidadDTO obj = null;
	    Connection cn = null;
	    PreparedStatement pstm = null;
	    ResultSet rs = null;
	
	    try {
	  	 cn = MySqlDBConnection.getConnection();
	       String sql = "select * from tb_especialidad where cod_especialidad=?";
	       pstm = cn.prepareStatement(sql);
	       pstm.setInt(1, cod);
	       rs = pstm.executeQuery();
	
	       if (rs.next()) {
	          obj = new EspecialidadDTO();
	          obj.setCodigo(rs.getInt(1));
	          obj.setNombre(rs.getString(2));
	       }
	    }
	    catch (Exception e) {
	       e.printStackTrace();
	    }
	    return obj;
	}

}