package bigwork;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import bigwork.Connections;

public class check {
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public static void checknum(int num) throws SQLException {
		if (sql!=null) {
			if (num == 0) {
				String str= "select * from ��ͨ��Ա��¼�� where ����=\'"+peoplelongin.ID+"\'and ֤����=\'"+peoplelongin.pw+"\'";
				rs = sql.executeQuery(str);
				if (rs.next()) {
					new people();
				}
				else {
					JOptionPane.showMessageDialog(null,"��¼ʧ��","��¼ʧ��,���µ�¼",JOptionPane.WARNING_MESSAGE);
					new longin();
				}
			}
			else if (num == 1){
				String str= "select * from ����Ա where ����=\'"+adminlongin.ID+"\'and ����֤����=\'"+adminlongin.pw+"\'";
				rs = sql.executeQuery(str);
				if (rs.next()) {
					new admin();
				}
				else {
					JOptionPane.showMessageDialog(null,"��¼ʧ��","��¼ʧ��,���µ�¼",JOptionPane.WARNING_MESSAGE);
					new longin();
				}
			}
		}
	}
}
