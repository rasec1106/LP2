package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDbConnection {
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.jdbcDriver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/cibertec_t4nj", "root","cleu1106");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
