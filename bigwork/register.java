package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;
import javax.swing.event.*;
public class register extends JFrame implements ActionListener{
	JTextField text1,text2;
	JLabel input1,input2;
	JButton button1,button2;
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public register() {
		setLayout(new FlowLayout(1,500,1));
    	setBounds(350,400,800,350);
    	text1 = new JTextField(20);
    	text2 = new JTextField(20);
    	input1 = new JLabel("姓名:");
    	input2 = new JLabel("证件号:");
    	button1 = new JButton("确认注册");
    	button2 = new JButton("返回上一步");
    	add(input1);
    	add(text1);
    	add(input2);
    	add(text2);
    	add(button1);
    	add(button2);
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		String str1 = text1.getText();
		String str2 = text2.getText();
		if (e.getSource()==button1) {
			try {
				String str = "insert into 普通人员登录表 values " + "('"+str1+"','"+str2+"')";
				int i = sql.executeUpdate(str);
				if (i>0) {
					new register();
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
			new peoplelongin();
			dispose();
		}
	}
	
}
