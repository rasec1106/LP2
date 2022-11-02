package utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlDBConnection {
	public static Connection getConnection() {
		Connection cn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection("jdbc:mysql://localhost/BD_HerreraVillacorta_CesarHumberto?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cn;
	}
}
