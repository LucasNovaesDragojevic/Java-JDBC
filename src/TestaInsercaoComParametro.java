import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercaoComParametro
{

	public static void main(String[] args) throws SQLException 
	{
		String nome = "Mouse";
		String descricao = "Mouse wireless";
		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		PreparedStatement stm = connection.prepareStatement("insert into produto (nome, descricao) values (?, ?)", Statement.RETURN_GENERATED_KEYS);
		stm.setString(1, nome);
		stm.setString(2, descricao);
		stm.execute();
		
		ResultSet generatedKeys = stm.getGeneratedKeys();
		
		while (generatedKeys.next())
		{
			System.out.println(generatedKeys.getInt(1));
		}

		connection.close();
	}

}
