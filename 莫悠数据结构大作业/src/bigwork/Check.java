package bigwork;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import bigwork.Connections;

public class Check {
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public static void checknum() throws SQLException {
		if (sql!=null) {
			String str= "select * from ¿ìµÝÔ±µÇÂ¼ where ÐÕÃû=\'"+courierlongin.ID+"\'and ÃÜÂë=\'"+courierlongin.pw+"\'";
			rs = sql.executeQuery(str);
			if (rs.next()) {
				new courier();
			}
			else {
				JOptionPane.showMessageDialog(null,"µÇÂ¼Ê§°Ü","µÇÂ¼Ê§°Ü,ÖØÐÂµÇÂ¼",JOptionPane.WARNING_MESSAGE);
				new courierlongin();
			}
		}
	}
}

