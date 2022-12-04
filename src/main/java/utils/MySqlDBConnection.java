package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/proyecto_lp2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","cleu1106Q!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
