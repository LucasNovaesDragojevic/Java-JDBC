package br.com.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.jdbc.dao.CategoriaDAO;
import br.com.jdbc.factory.ConnectionFactory;
import br.com.jdbc.model.Categoria;
import br.com.jdbc.model.Produto;

public class TestaListagemCategoria 
{

	public static void main(String[] args) throws SQLException 
	{
		try (Connection connection = new ConnectionFactory().recuperarConexao())
		{
			CategoriaDAO categoriaDAO = new CategoriaDAO(connection);
			List<Categoria> listaCategoria;
			listaCategoria = categoriaDAO.listarComProdutos();
			listaCategoria.forEach(System.out::println);
			
			System.out.println();
			
			listaCategoria.stream().forEach(categoria -> {
				for (Produto produto : categoria.getProdutos()) {
					System.out.println(categoria.getNome() + " - " + produto.getNome());
				}
			});
		}
	}

}
