package br.com.forseti.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TesteLeitura {
	public static void main(String[] args) throws SQLException {		
		Connection conn = ConnectionFactory.create();
		PreparedStatement stmt = conn.prepareStatement("SELECT * FROM tb_log");
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			System.out.println("USUARIO: " + rs.getInt("id_usuario"));
		}
		
		conn.close();
	}
}
