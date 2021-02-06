import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TesteConexao 
{

	public static void main(String[] args) throws SQLException 
	{
		String url= "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
		Connection connection = DriverManager.getConnection(url, "alura", "alura");
		
		connection.close();

	}

}
