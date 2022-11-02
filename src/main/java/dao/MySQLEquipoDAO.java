package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import beans.EquipoDTO;
import interfaces.EquipoDAO;
import utils.MySqlDBConnection;

public class MySQLEquipoDAO implements EquipoDAO {

   @Override
   public List<EquipoDTO> listarEquipo() {
      List<EquipoDTO> data = new ArrayList<EquipoDTO>();
      EquipoDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
         cn = MySqlDBConnection.getConnection();
         String sql = "select e.cod_equ, e.des_equ, e.pre_equ, e.stock_equ, m.nom_mar, p.nom_pais "
         		+ "from tb_equipo e "
         		+ "inner join tb_marca m on e.cod_mar = m.cod_mar "
         		+ "inner join tb_pais p on e.cod_pais = p.cod_pais";
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new EquipoDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setDescripcion(rs.getString(2));
            obj.setPrecio(rs.getDouble(3));
            obj.setStock(rs.getInt(4));
            obj.setNomMarca(rs.getString(5));
            obj.setNomPais(rs.getString(6));
            data.add(obj);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return data;
   }
   
   @Override
   public List<EquipoDTO> buscarPorPrecio(double precio) {
      List<EquipoDTO> data = new ArrayList<EquipoDTO>();
      EquipoDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
         cn = MySqlDBConnection.getConnection();
         String sql = "select e.cod_equ, e.des_equ, e.pre_equ, e.stock_equ, m.nom_mar, p.nom_pais "
         		+ "from tb_equipo e "
         		+ "inner join tb_marca m on e.cod_mar = m.cod_mar "
         		+ "inner join tb_pais p on e.cod_pais = p.cod_pais "
         		+ "where e.pre_equ >= "+precio;
         pstm = cn.prepareStatement(sql);
         rs = pstm.executeQuery();

         while (rs.next()) {
            obj = new EquipoDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setDescripcion(rs.getString(2));
            obj.setPrecio(rs.getDouble(3));
            obj.setStock(rs.getInt(4));
            obj.setNomMarca(rs.getString(5));
            obj.setNomPais(rs.getString(6));
            data.add(obj);
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return data;
   }

   @Override
   public EquipoDTO buscarEquipo(int cod) {
      EquipoDTO obj = null;
      Connection cn = null;
      PreparedStatement pstm = null;
      ResultSet rs = null;

      try {
    	 cn = MySqlDBConnection.getConnection();
         String sql = "select * from tb_equipo where cod_equ=?";
         pstm = cn.prepareStatement(sql);
         pstm.setInt(1, cod);
         rs = pstm.executeQuery();

         if (rs.next()) {
            obj = new EquipoDTO();
            obj.setCodigo(rs.getInt(1));
            obj.setDescripcion(rs.getString(2));
            obj.setPrecio(rs.getDouble(3));
            obj.setStock(rs.getInt(4));
            obj.setCodMarca(rs.getInt(5));
            obj.setCodPais(rs.getInt(6));
         }
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return obj;
   }
	
   @Override
   public int registrarEquipo(EquipoDTO obj) {
      int estado = -1;
      Connection cn = null;
      PreparedStatement pstm = null;

      try {
    	 cn = MySqlDBConnection.getConnection();
         String sql = "insert into tb_equipo values(null,?,?,?,?,?)";
         pstm = cn.prepareStatement(sql);
         pstm.setString(1, obj.getDescripcion());
         pstm.setDouble(2, obj.getPrecio());
         pstm.setInt(3, obj.getStock());
         pstm.setInt(4, obj.getCodMarca());
         pstm.setInt(4, obj.getCodPais());
         estado = pstm.executeUpdate();
      }
      catch (Exception e) {
         e.printStackTrace();
      }
      return estado;
   }
	
	@Override
	   public int actualizarEquipo(EquipoDTO obj) {
	      int estado = -1;
	      Connection cn = null;
	      PreparedStatement pstm = null;

	      try {
	    	 cn = MySqlDBConnection.getConnection();
	         String sql = "update tb_equipo set des_equ=?, pre_equ=?, stock_equ=?, cod_mar=?, cod_pais=? where cod_equ=?";
	         pstm = cn.prepareStatement(sql);
	         pstm.setString(1, obj.getDescripcion());
	         pstm.setDouble(2, obj.getPrecio());
	         pstm.setInt(3, obj.getStock());
	         pstm.setInt(4, obj.getCodMarca());
	         pstm.setInt(5, obj.getCodPais());
	         pstm.setInt(6, obj.getCodigo());
	         estado = pstm.executeUpdate();
	      }
	      catch (Exception e) {
	         e.printStackTrace();
	      }
	      return estado;
	   }
	
	@Override
	   public int eliminarEquipo(int cod) {
	      int estado = -1;
	      Connection cn = null;
	      PreparedStatement pstm = null;
	      
	      try {
	         cn = MySqlDBConnection.getConnection();
	         String sql = "delete from tb_equipo where cod_equ=?";
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