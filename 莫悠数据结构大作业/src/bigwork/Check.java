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
			String str= "select * from ���Ա��¼ where ����=\'"+courierlongin.ID+"\'and ����=\'"+courierlongin.pw+"\'";
			rs = sql.executeQuery(str);
			if (rs.next()) {
				new courier();
			}
			else {
				JOptionPane.showMessageDialog(null,"��¼ʧ��","��¼ʧ��,���µ�¼",JOptionPane.WARNING_MESSAGE);
				new courierlongin();
			}
		}
	}
}

