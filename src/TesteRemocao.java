import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteRemocao 
{

	public static void main(String[] args) throws SQLException
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("delete from loja_virtual.produto where id > 4");
		int linhaModificadas = stm.getUpdateCount();
		
		System.out.println("Quantidade de linhas modificadas: " + linhaModificadas);
		
		connection.close();
	}

}
