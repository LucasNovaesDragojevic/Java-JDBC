import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory 
{
	Connection recuperarConexao() throws SQLException
	{
		String url= "jdbc:mysql://localhost/loja_virtual?useTimezone=true&serverTimezone=UTC";
		return DriverManager.getConnection(url, "alura", "alura");
	}
}
