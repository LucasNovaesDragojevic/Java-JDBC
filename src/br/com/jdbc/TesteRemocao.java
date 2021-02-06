package br.com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.jdbc.factory.ConnectionFactory;

public class TesteRemocao 
{

	public static void main(String[] args) throws SQLException
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("delete from loja_virtual.produto where id > ?");
		stm.setInt(1, 2);
		stm.execute();
		int linhaModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificadas: " + linhaModificadas);
		
		connection.close();
	}

}
