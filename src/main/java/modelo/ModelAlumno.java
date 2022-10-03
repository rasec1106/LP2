package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entidad.Alumno;
import utils.MySqlDbConnection;

public class ModelAlumno {
	
	public List<Alumno> listar(){
		Alumno alu = null;
		List<Alumno> data = new ArrayList<Alumno>();
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "select * from tb_alumno";
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery();
			while(rs.next()) {
				alu = new Alumno();
				alu.setCodigo(rs.getInt(1));
				alu.setNombre(rs.getString(2));
				alu.setPaterno(rs.getString(3));
				alu.setMaterno(rs.getString(4));
				alu.setEdad(rs.getInt(5));
				data.add(alu);
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
	
	public Alumno buscar(int code){
		Alumno alu = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "select * from tb_alumno where cod_alu=?";
			pstm = cn.prepareStatement(sql);
			pstm.setInt(1, code);
			rs = pstm.executeQuery();
			if(rs.next()) {
				alu = new Alumno();
				alu.setCodigo(rs.getInt(1));
				alu.setNombre(rs.getString(2));
				alu.setPaterno(rs.getString(3));
				alu.setMaterno(rs.getString(4));
				alu.setEdad(rs.getInt(5));
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
		return alu;
	}
	
	public int registrar(Alumno a){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "insert into tb_alumno values(null,?,?,?,?)";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, a.getNombre());
			pstm.setString(2, a.getPaterno());
			pstm.setString(3, a.getMaterno());
			pstm.setInt(4, a.getEdad());
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
	
	public int actualizar(Alumno a){
		int estado = -1;
		Connection cn = null;
		PreparedStatement pstm = null;
		try {
			cn= MySqlDbConnection.getConnection();
			String sql = "update tb_alumno set nom_alu=?, ape_pat_alu=?, ape_mat_alu=?, edad_alu=? where cod_alu=?";
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, a.getNombre());
			pstm.setString(2, a.getPaterno());
			pstm.setString(3, a.getMaterno());
			pstm.setInt(4, a.getEdad());
			pstm.setInt(5, a.getCodigo());
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
			String sql = "delete from tb_alumno where cod_alu=?";
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
