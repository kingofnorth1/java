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
				String str= "select * from 普通人员登录表 where 姓名=\'"+peoplelongin.ID+"\'and 证件号=\'"+peoplelongin.pw+"\'";
				rs = sql.executeQuery(str);
				if (rs.next()) {
					new people();
				}
				else {
					JOptionPane.showMessageDialog(null,"登录失败","登录失败,重新登录",JOptionPane.WARNING_MESSAGE);
					new longin();
				}
			}
			else if (num == 1){
				String str= "select * from 管理员 where 姓名=\'"+adminlongin.ID+"\'and 工作证件号=\'"+adminlongin.pw+"\'";
				rs = sql.executeQuery(str);
				if (rs.next()) {
					new admin();
				}
				else {
					JOptionPane.showMessageDialog(null,"登录失败","登录失败,重新登录",JOptionPane.WARNING_MESSAGE);
					new longin();
				}
			}
		}
	}
}
