package br.com.fiap.connectiom;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Cria uma conexão com o banco
public class ConnectionFactory {
	
	public Connection conectar() {
		try {
//			JDBC é uma especificação do java para conexão com banco de dados
//			Para acessar um banco remoto enivamos o endereço do banco, usuário e senha
		return DriverManager.getConnection("jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL", "user", "senha");
	}catch(SQLException e) {
		e.printStackTrace();
	}
		
	return null;
	}
}

