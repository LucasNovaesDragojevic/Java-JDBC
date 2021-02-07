package br.com.jdbc.model;

import java.util.ArrayList;
import java.util.List;

public class Categoria 
{
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<>();
	
	public Categoria(Integer id, String nome) 
	{
		this.id = id;
		this.nome = nome;
	}
	
	@Override
	public String toString()
	{
		return "Categoria: " + id + " " + nome;
	}

	public Integer getId() 
	{
		return this.id;
	}

	public String getNome() 
	{
		return this.nome;
	}
	
	public void adicionar(Produto produto)
	{
		produtos.add(produto);
	}

	public List<Produto> getProdutos() 
	{
		return this.produtos;
	}
}
