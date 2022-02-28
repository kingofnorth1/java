package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.event.*;

//快递员取件类

public class getcourier extends JFrame implements ActionListener{
	JLabel output1;
	JTextField text1;
	JButton button1,button2,button3;
	JTextArea textshow;
	static List list = new List();
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public getcourier() {
		setLayout(new FlowLayout(1,50,5));
    	setBounds(350,400,800,350);
		output1 = new JLabel("快递柜号:");
		text1 = new JTextField(20);
		button1 = new JButton("确定");
		button2 = new JButton("取消");
		button3 = new JButton("查询");
		textshow = new JTextArea(9,75);
		add(output1);
		add(text1);
		add(textshow);
		add(button3);
		add(button1);
		add(button2);
		setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String str1 = text1.getText();
		String str5 = "无";
		String str3 = "update 快递柜 set 手机号='"+null+"', 格口类别='"+null+"', 取件码='"+null+"', 格口状态='"+str5+"', 格口存放时间='"+null+"' where 格口号='"+str1+"';";
		if (e.getSource()==button1) {
			try {
				rs = sql.executeQuery("select * from 快递柜");
				while (rs.next()) {
					if (rs.getString(1).equals(str1)) {
						Statement sql1 = Connections.doConnections();
						int i = sql1.executeUpdate(str3);
						if (i>0) {
							other.other3(rs.getString(4));
							new getcourier();
						}
						else {
							JOptionPane.showMessageDialog(null,"写入失败","写入失败,重新写入",JOptionPane.WARNING_MESSAGE);
						}
						dispose();
					}
				}
			}
			catch (SQLException e1) {
				e1.toString();
			}
		}
		else if (e.getSource()==button2){
			new courier();
			dispose();
		}
//		else if (e.getSource()==button3) {
//			try {
//				rs = sql.executeQuery("select * from 快递柜");
//				textshow.append("*************************\n");
//				while (rs.next()) {
//					textshow.append("格口号:"+rs.getString(1)+" 手机号:"+rs.getString(2)+" 格口类别:"+rs.getString(3)+" 取件码:"+rs.getString(4)+" 格口状态:"+
//							rs.getString(5)+" 格口存放时间:"+rs.getString(6)+"\n");
//				}
//				textshow.append("*************************\n");
//			}
//			catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//		}
		else if (e.getSource()==button3) {
			list = other.other4();
			int sum = list.showtext_list();
			textshow.append("***********显示全部************\n");
			for(int j=0;j<sum;j++) {
	    		textshow.append(list.str[j]+"\n");
	    	}
			textshow.append("****************************\n");
		}
	}
}
