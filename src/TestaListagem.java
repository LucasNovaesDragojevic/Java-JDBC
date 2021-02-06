import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaListagem 
{
	public static void main(String[] args) throws SQLException 
	{
		ConnectionFactory criaConexao = new ConnectionFactory();
		Connection connection = criaConexao.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("SELECT ID, NOME, DESCRICAO FROM produto");
		ResultSet rs = stm.getResultSet();
		
		while (rs.next())
		{
			int id = rs.getInt("ID");
			String nome = rs.getString("NOME");
			String descricao = rs.getString("DESCRICAO");
			
			System.out.println(id);
			System.out.println(nome);
			System.out.println(descricao);
		}
		
		connection.close();
	}
}
