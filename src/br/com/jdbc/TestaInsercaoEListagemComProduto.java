package br.com.jdbc;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.jdbc.dao.ProdutoDAO;
import br.com.jdbc.factory.ConnectionFactory;
import br.com.jdbc.model.Produto;

public class TestaInsercaoEListagemComProduto 
{
	public static void main(String[] args) throws SQLException 
	{
		Produto comoda = new Produto("Comoda", "Cômoda vertical");
		
		try (Connection connection = new ConnectionFactory().recuperarConexao())
		{
			ProdutoDAO produtoDAO = new ProdutoDAO(connection);
			produtoDAO.salvar(comoda);
			List<Produto> produtos = produtoDAO.listar();
			produtos.forEach(System.out::println);
		}
	}
}
