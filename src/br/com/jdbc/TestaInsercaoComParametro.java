package br.com.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.jdbc.factory.ConnectionFactory;

public class TestaInsercaoComParametro
{

	public static void main(String[] args) throws SQLException 
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection connection = connectionFactory.recuperarConexao())
		{
			connection.setAutoCommit(false);
			
			try (PreparedStatement stm = connection.prepareStatement("insert into produto (nome, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS))
			{
				adicionarVariavel("Mouse", "Mouse wireless", stm);
				adicionarVariavel("Teclado", "Teclado com fio", stm);
				connection.commit();
			}
			catch (Exception e)
			{
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
				connection.rollback();
			}
		}
	}

	private static void adicionarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException 
	{
		stm.setString(1, nome);
		stm.setString(2, descricao);
		
		//if (nome.equals("Teclado")) throw new RuntimeException("Erro ao registrar.");
		
		stm.execute();
		
		try (ResultSet rs = stm.getGeneratedKeys())
		{
			while (rs.next())
			{
				System.out.println(rs.getInt(1));
			}
		}
	}
}
