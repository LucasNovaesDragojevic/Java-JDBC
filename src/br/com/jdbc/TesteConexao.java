package br.com.jdbc;
import java.sql.Connection;
import java.sql.SQLException;

import br.com.jdbc.factory.ConnectionFactory;

public class TesteConexao 
{

	public static void main(String[] args) throws SQLException 
	{
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		connection.close();
	}
}
