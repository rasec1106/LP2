package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDbConnection {
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/cibertec_t4nj?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","cleu1106Q!");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
