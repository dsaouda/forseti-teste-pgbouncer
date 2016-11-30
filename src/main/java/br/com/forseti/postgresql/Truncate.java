package br.com.forseti.postgresql;

import java.sql.Connection;
import java.sql.SQLException;

public class Truncate {
	public static void main(String[] args) throws SQLException {		
		
		Connection conn = ConnectionFactory.createPorTipo();
		conn.prepareStatement("DROP TABLE IF EXISTS tb_log").execute();
		
		String ddl = "" 
		+ "CREATE TABLE tb_log ("
		+ "    id bigserial,"
		+ "    id_cliente integer not null,"
		+ "    id_usuario integer not null,"
		+ "    nm_modulo varchar(200) not null,"
		+ "    nm_evento varchar(200) not null,"
		+ "    nm_controller varchar(500) not null,"
		+ "    nm_action varchar(100) not null,"
		+ "    dt_cadastro timestamp(6) without time zone not null default NOW(),"
		+ "    CONSTRAINT tb_log_pkey PRIMARY KEY (id)"
		+ ")";
		
		conn.prepareStatement(ddl).execute();		
		System.out.println("truncate finalizado ... ");
	}
}
