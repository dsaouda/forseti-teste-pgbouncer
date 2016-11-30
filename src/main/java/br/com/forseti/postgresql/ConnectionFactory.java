package br.com.forseti.postgresql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

final public class ConnectionFactory {
	
	private static Properties config = new Properties();
	
	static {		
		try {
			InputStream stream = ConnectionFactory.class.getResourceAsStream("/config.properties");		
			config.load(stream);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}		
	}
	
	public static Connection createPorTipo() {		
		switch(tipoConexao()) {		
		case "pgbouncer": 
			return createPgBouncer();
			
		default:
			case "db": return create();		
		}
	}
	
	public static String tipoConexao() {
		return config.getProperty("use");
	}
		
	public static Connection create() {
		return createConnection("db");
	}
	
	public static Connection createPgBouncer() {
		return createConnection("pgbouncer");
	}
	
	private static Connection createConnection(String tipo) {
		try {
			return DriverManager.getConnection(config.getProperty(tipo + ".host"), config.getProperty(tipo + ".user"), config.getProperty(tipo + ".pass"));
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public static int tamanhoTeste() {		
		return Integer.parseInt(config.getProperty("tamanhoteste"));
	}

	public static int iteracao() {
		return Integer.parseInt(config.getProperty("iteracao"));
	}
	
}
