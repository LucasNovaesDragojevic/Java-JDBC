package br.com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.jdbc.factory.ConnectionFactory;

public class TestaListagem 
{
	public static void main(String[] args) throws SQLException 
	{
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("SELECT ID, NOME, DESCRICAO FROM produto");
		stm.execute();
		ResultSet rs = stm.getResultSet();
		
		while (rs.next())
		{
			int id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String descricao = rs.getString("DESCRICAO");
			
			System.out.println(id + " " + nome + " " + descricao);
		}
		
		connection.close();
	}
}
