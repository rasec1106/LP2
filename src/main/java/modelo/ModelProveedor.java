package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entidad.Proveedor;
import utils.MySqlDbConnection;

public class ModelProveedor {
	
	public List<Proveedor> listar(){
		Proveedor prov = null;
		List<Proveedor> data = new ArrayList<Proveedor>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "select * from tb_proveedor";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				prov = new Proveedor();
				prov.setCodigo(rs.getInt(1));
				prov.setRazonSocial(rs.getString(2));
				prov.setRuc(rs.getString(3));
				prov.setDireccion(rs.getString(4));
				prov.setDni(rs.getString(5));
				prov.setNombre(rs.getString(6));
				prov.setCelular(rs.getString(7));
				prov.setFecNacimiento(rs.getString(8));
				data.add(prov);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	public Proveedor buscar(int code){
		Proveedor prov = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "select * from tb_proveedor where codigo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, code);
			rs = pstm.executeQuery();
			if(rs.next()) {
				prov = new Proveedor();
				prov.setCodigo(rs.getInt(1));
				prov.setRazonSocial(rs.getString(2));
				prov.setRuc(rs.getString(3));
				prov.setDireccion(rs.getString(4));
				prov.setDni(rs.getString(5));
				prov.setNombre(rs.getString(6));
				prov.setCelular(rs.getString(7));
				prov.setFecNacimiento(rs.getString(8));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return prov;
	}
	
	public int registrar(Proveedor p){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "insert into tb_proveedor values(null,?,?,?,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, p.getRazonSocial());
			pstm.setString(2, p.getRuc());
			pstm.setString(3, p.getDireccion());
			pstm.setString(4, p.getDni());
			pstm.setString(5, p.getNombre());
			pstm.setString(6, p.getCelular());
			pstm.setString(7, p.getFecNacimiento());
			estado = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	public int actualizar(Proveedor p){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "update tb_proveedor set razonSocial=?, ruc=?, direccion=?, dni=?, nombre=?, celular=?, fecNacimiento=? where codigo=?";
			pstm = cn.prepareStatement(sql);			
			pstm.setString(1, p.getRazonSocial());
			pstm.setString(2, p.getRuc());
			pstm.setString(3, p.getDireccion());
			pstm.setString(4, p.getDni());
			pstm.setString(5, p.getNombre());
			pstm.setString(6, p.getCelular());
			pstm.setString(7, p.getFecNacimiento());
			pstm.setInt(8, p.getCodigo());
			estado = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
	
	public int eliminar(int code){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "delete from tb_proveedor where codigo=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, code);
			estado = pstm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		return estado;
	}
}
