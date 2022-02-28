package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.event.*;

//添加信息类

public class addcourier extends JFrame implements ActionListener{
	JLabel output1,output2;
	JTextField text1,text2;
	JComboBox<String> comBox1,comBox2;
	JButton button1,button2;
	String[] str1 = new String[10];
	String[] str2 = new String[] {"生鲜","常用","其他"};
	LocalDate today = LocalDate.now();
	ResultSet rs;
	Statement sql = Connections.doConnections();
	public addcourier() {
		setLayout(new FlowLayout(1,500,8));
    	setBounds(350,400,800,350);
    	str1 = other.other1();
		output1 = new JLabel("手机号:");
		output2 = new JLabel("取件码:");
		text1 = new JTextField(20);
		text2 = new JTextField(20);
		comBox1 = new JComboBox<String>(str1);
		comBox2 = new JComboBox<String>(str2);
		button1 = new JButton("确定");
		button2 = new JButton("取消");
		add(comBox1);
		add(comBox2);
		add(output1);
		add(text1);
		add(output2);
		add(text2);
		add(button1);
		add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String str3 = text1.getText();
		String str4 = text2.getText();
		String str5 = (String) comBox1.getSelectedItem();
		String str6 = (String) comBox2.getSelectedItem();
		if (e.getSource()==button1) {
			System.out.println(str6);
			try {
				String str8 = "有";
				String str7 = "update 快递柜 set 手机号='"+str3+"', 格口类别='"+str6+"', 取件码='"+str4+"', 格口状态='"+str8+"', 格口存放时间='"+today+"' where 格口号='"+str5+"';";
				int i = sql.executeUpdate(str7);
				if (i>0) {
					new addcourier();
				}
				else {
					JOptionPane.showMessageDialog(null,"写入失败","写入失败,重新写入",JOptionPane.WARNING_MESSAGE);
				}
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			dispose();
		}
		else if (e.getSource()==button2) {
			new courier();
			dispose();
		}
	}
}
