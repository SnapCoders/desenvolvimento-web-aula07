package br.com.desenvolvimentoweb.factory;

import java.util.Base64;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConnectionFactory {
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection obtemConexao() throws SQLException {
		String servidor = "localhost";
		String porta = "3306";
		String database = "paises";
		String password = new String(Base64.getDecoder().decode("OUttIzQ3bUs="));
		
		return DriverManager
				.getConnection("jdbc:mysql://"+ servidor + ":" + porta + "/" + database +
						"?useTimezone=true&serverTimezone=UTC", "root", password);
	}
}
