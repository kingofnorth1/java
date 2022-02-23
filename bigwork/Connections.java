package bigwork;

import java.sql.*;

public class Connections {
	public static Connection con;
	static Statement sql;
	public static Statement doConnections() {
		try {
			Class.forName("com.mysql.jc.jdbc.Driver");
		}
		catch(Exception e){}
		String uri = "jdbc:mysql://localhost:3306/航空客运订票系统?useSSL=true";
		String user = "root";
		String password = "123456";
		try {
			con = DriverManager.getConnection(uri,user,password);
			sql = con.createStatement();
			return sql;
		}
		catch(SQLException e) {}
		return null;
	}
}