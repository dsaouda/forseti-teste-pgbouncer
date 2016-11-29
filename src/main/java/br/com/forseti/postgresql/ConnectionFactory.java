package br.com.forseti.postgresql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

final public class ConnectionFactory {
	
	private ConnectionFactory() {}
	
	private final static String DATABASE = "admin";
	private final static String URL_PGBOUNCER = "jdbc:postgresql://192.168.33.10:16432/" + DATABASE;
	private final static String URL = "jdbc:postgresql://192.168.33.10:25432/" + DATABASE;
	private final static String USUARIO = "admin";
	private final static String SENHA = "123";
	
	public static Connection create() {
		try {
			return DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static Connection createPgBouncer() {
		try {
			return DriverManager.getConnection(URL_PGBOUNCER, USUARIO, SENHA);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
