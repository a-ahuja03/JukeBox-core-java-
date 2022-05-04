package jukebox;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Dbconnect {
	Connection con;
	public static Connection createConnection() throws SQLException
	{
		Connection con=DriverManager.getConnection("jdbc:MySql://localhost/jukebox1","root","root");
		return con;
	}

}
