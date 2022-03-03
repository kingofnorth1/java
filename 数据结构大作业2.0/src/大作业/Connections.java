package 大作业;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connections {
	public static Connection con;
	static Statement sql;
	public static Statement doConnections() {
		try {
			Class.forName("com.mysql.jc.jdbc.Driver");
		}
		catch(Exception e){}
		String uri = "jdbc:mysql://localhost:3306/饭堂选菜系统?useSSL=true";
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