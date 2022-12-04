package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://18.207.63.198:3306/proyecto_LP2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "cibertec","cibertec123");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
