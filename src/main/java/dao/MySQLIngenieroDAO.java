package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.IngenieroDTO;
import interfaces.IngenieroDAO;
import utils.MySqlDBConnection;

public class MySQLIngenieroDAO implements IngenieroDAO {

   @Override
   public List<IngenieroDTO> listarIngeniero() {
      List<IngenieroDTO> data = new ArrayList<IngenieroDTO>();
      IngenieroDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
         cn = MySqlDBConnection.getConnection();
         String sql = "select i.cod_ingeniero, i.nom_ingeniero, i.ape_ingeniero, i.dni_ingeniero , i.sueldo, "
         		+ "u.cod_universidad, u.nom_universidad, e.cod_especialidad, e.nom_especialidad "
         		+ "from tb_ingeniero i "
         		+ "inner join tb_universidad u on i.cod_universidad = u.cod_universidad "
         		+ "inner join tb_especialidad e on i.cod_especialidad = e.cod_especialidad";
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new IngenieroDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setNombre(rs.getString(2));
            obj.setApellido(rs.getString(3));
            obj.setDni(rs.getString(4));
            obj.setSueldo(rs.getDouble(5));
            obj.setCodUniversidad(rs.getInt(6));
            obj.setNomUniversidad(rs.getString(7));
            obj.setCodEspecialidad(rs.getInt(8));
            obj.setNomEspecialidad(rs.getString(9));
            data.add(obj);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return data;
   }

   @Override
   public IngenieroDTO buscarIngeniero(int cod) {
      IngenieroDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
    	 cn = MySqlDBConnection.getConnection();
         String sql = "select * from tb_ingeniero where cod_ingeniero=?";
         pstm = cn.prepareStatement(sql);
         pstm.setInt(1, cod);
         rs = pstm.executeQuery();

         if (rs.next()) {
            obj = new IngenieroDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setNombre(rs.getString(2));
            obj.setApellido(rs.getString(3));
            obj.setDni(rs.getString(4));
            obj.setSueldo(rs.getDouble(5));
            obj.setCodUniversidad(rs.getInt(6));
            obj.setCodEspecialidad(rs.getInt(7));
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return obj;
   }
	
   @Override
   public int registrarIngeniero(IngenieroDTO obj) {
      int estado = -1;
      Connection cn = null;
      PreparedStatement pstm = null;

      try {
    	 cn = MySqlDBConnection.getConnection();
         String sql = "insert into tb_ingeniero values(null,?,?,?,?,?,?)";
         pstm = cn.prepareStatement(sql);
         pstm.setString(1, obj.getNombre());
         pstm.setString(2, obj.getApellido());
         pstm.setString(3, obj.getDni());
         pstm.setDouble(4, obj.getSueldo());
         pstm.setInt(5, obj.getCodUniversidad());
         pstm.setInt(6, obj.getCodEspecialidad());
         estado = pstm.executeUpdate();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return estado;
   }
	
	@Override
	   public int actualizarIngeniero(IngenieroDTO obj) {
	      int estado = -1;
	      Connection cn = null;
	      PreparedStatement pstm = null;

	      try {
	    	 cn = MySqlDBConnection.getConnection();
	         String sql = "update tb_ingeniero set nom_ingeniero=?, ape_ingeniero=?, dni_ingeniero=?, "
	         		+ "sueldo=?, cod_universidad=?, cod_especialidad=? where cod_ingeniero=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getNombre());
	         pstm.setString(2, obj.getApellido());
	         pstm.setString(3, obj.getDni());
	         pstm.setDouble(4, obj.getSueldo());
	         pstm.setInt(5, obj.getCodUniversidad());
	         pstm.setInt(6, obj.getCodEspecialidad());
	         pstm.setInt(7, obj.getCodigo());
	         estado = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;
	   }
	
	@Override
	   public int eliminarIngeniero(int cod) {
	      int estado = -1;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      
	      try {
	         cn = MySqlDBConnection.getConnection();
	         String sql = "delete from tb_ingeniero where cod_ingeniero=?";
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