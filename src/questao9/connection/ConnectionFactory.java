package questao9.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection recuperarConexao() throws SQLException {
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3305/compass?useTimezone=true&serverTime=UTC", "developer", "12345678");
	}
}
