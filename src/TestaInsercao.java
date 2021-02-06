import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestaInsercao
{

	public static void main(String[] args) throws SQLException 
	{
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection connection = connectionFactory.recuperarConexao();
		
		Statement stm = connection.createStatement();
		stm.execute("insert into produto (nome, descricao) values ('mouse', 'mouse sem fio')", Statement.RETURN_GENERATED_KEYS);
		ResultSet rs = stm.getGeneratedKeys();
		
		while (rs.next())
		{
			int id = rs.getInt(1);
			System.out.println(id);
		}
		connection.close();
	}

}
