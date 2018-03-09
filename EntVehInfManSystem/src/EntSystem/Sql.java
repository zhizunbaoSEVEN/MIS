package EntSystem;
import java.sql.*;
public class Sql {
	public static Connection getConnection() throws SQLException,java.lang.ClassNotFoundException{
		String url = "jdbc:mysql://localhost:3306/StaCarInf";
		Class.forName("com.mysql.jdbc.Driver");
		String userName = "root";
		String password = "123";
		Connection con = DriverManager.getConnection(url, userName, password);
		return con;
	}
}
