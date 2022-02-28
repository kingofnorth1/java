package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.event.*;

//普通人取件类

public class people extends JFrame implements ActionListener{
	JLabel output1;
	JTextField text1;
	JButton button1,button2;
	ResultSet rs;
	Statement sql = Connections.doConnections();
	static String str4;
	public people() {
		setLayout(new FlowLayout(1,800,25));
    	setBounds(350,400,800,350);
    	output1 = new JLabel("取件码:");
    	text1 = new JTextField(20);
    	button1 = new JButton("确定");
    	button2 = new JButton("取消");
    	add(output1);
    	add(text1);
    	add(button1);
    	add(button2);
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String str1 = text1.getText();
		if (e.getSource()==button1) {
			try {
				rs = sql.executeQuery("select * from 快递柜");
				while (rs.next()) {
					if (rs.getString(4)!=null) {
						if (rs.getString(4).equals(str1)) {
							str4 = rs.getString(2);
							String str4 = "无";
							String str3 = "update 快递柜 set 手机号='"+null+"', 格口类别='"+null+"', 取件码='"+null+"', 格口状态='"+str4+"', 格口存放时间='"+null+"' where 取件码='"+str1+"';";
							int i = sql.executeUpdate(str3);
							if (i>0) {
								new people();
							}
							else {
								JOptionPane.showMessageDialog(null,"写入失败","写入失败,重新写入",JOptionPane.WARNING_MESSAGE);
							}
							dispose();
						}
					}
				}
			}
			catch (SQLException e1) {
				e1.toString();
			}
			try {
				ResultSet rs1;
				Statement sql1 = Connections.doConnections();
				rs1 = sql1.executeQuery("select * from 快递柜");
				while (rs1.next()) {
//					System.out.println(rs1.getString(2)+" "+str4);
					if (rs1.getString(2)!=null && str4!=null ) {
						if (str4.equals(rs1.getString(2))) {
							other.other2(rs1.getString(4));
						}
					}
				}
			}
			catch (SQLException e1) {
				e1.toString();
			}

		}
		else if (e.getSource()==button2){
			new longin();
			dispose();
		}
	}
}
