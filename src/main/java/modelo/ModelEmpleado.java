package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entidad.Empleado;
import utils.MySqlDbConnection;

public class ModelEmpleado {
	
	public Empleado iniciarSesion(String username, String password) {
		Empleado obj = null;
		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;		
		try {
			String sql = "select * from tb_empleado where login_emp=? and clave_emp=?";
			cn = MySqlDbConnection.getConnection();
			pstm = cn.prepareStatement(sql);
			pstm.setString(1, username);
			pstm.setString(2, password);
			rs = pstm.executeQuery();
			if(rs.next()) {
				obj = new Empleado();
				obj.setCodigo(rs.getInt(1));
				obj.setNombre(rs.getString(2));
				obj.setApellidos(rs.getString(3));
				obj.setLogin(rs.getString(4));
				obj.setClave(rs.getString(5));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {				
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}		
		return obj;
	}
}
