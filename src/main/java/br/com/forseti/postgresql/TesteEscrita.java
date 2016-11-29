package br.com.forseti.postgresql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//ALGUNS TESTES
//COM PG
//Tempo gasto: 1504 ms
//Tempo gasto: 903 ms
//Tempo gasto: 1267 ms
//Tempo gasto: 835 ms
//Tempo gasto: 686 ms
//Tempo gasto: 715 ms
//Tempo gasto: 752 ms
//Tempo gasto: 751 ms
//Tempo gasto: 898 ms
//Tempo gasto: 700 ms

//SEM PG
//Tempo gasto: 1138 ms
//Tempo gasto: 1068 ms
//Tempo gasto: 989 ms
//Tempo gasto: 963 ms
//Tempo gasto: 932 ms
//Tempo gasto: 941 ms
//Tempo gasto: 968 ms
//Tempo gasto: 895 ms
//Tempo gasto: 942 ms
//Tempo gasto: 879 ms

public class TesteEscrita {
	private static final int ITERACAO = 10;
	private static final int TAMANHO_TESTE = 100;
	private static final int PGBOUNCER = 1;
	private static final int POSTGRES = 2;
	private static final int tipoConexao = POSTGRES;	

	public static void main(String[] args) throws SQLException {
		Truncate.main(args);
		
		for (int j = 1; j<=ITERACAO; j++) {			
			long inicio = System.currentTimeMillis();

			for(int i = 1; i <= TAMANHO_TESTE; i++) {
				Connection conn = getConnection();
				PreparedStatement stmt = conn.prepareStatement("INSERT INTO tb_log (id_cliente, id_usuario, nm_modulo, nm_evento, nm_controller, nm_action) VALUES (?,?,?,?,?,?)");
				stmt.setInt(1, i);
				stmt.setInt(2, i);
				stmt.setString(3, i + " modulo teste");
				stmt.setString(4, i + " evento teste");
				stmt.setString(5, i + " controller teste");
				stmt.setString(6, i + " action teste");		
				stmt.executeUpdate();
				conn.close();
			}		

			long fim = System.currentTimeMillis();			
			System.out.println("Tempo gasto: " + (fim - inicio) + " ms");			
		}
	}

	private static Connection getConnection() {
		switch(tipoConexao) {
		case PGBOUNCER:
			return ConnectionFactory.createPgBouncer();
		
		case POSTGRES:
		default:		
			return ConnectionFactory.create();

		}
	}
}
