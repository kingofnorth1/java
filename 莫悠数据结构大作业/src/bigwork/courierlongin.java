package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;

//快递员登录类

public class courierlongin extends JFrame implements ActionListener{
	JLabel output1,output2;
	JButton button1,button2;
	JTextField text1,text2;
	static String ID,pw;
	public courierlongin() {
		setLayout(new FlowLayout(1,800,25));
    	setBounds(350,400,800,350);
    	output1 = new JLabel("姓名:");
    	output2 = new JLabel("密码:");
    	button1 = new JButton("确定");
    	button2 = new JButton("取消");
    	text1 = new JTextField(20);
    	text2 = new JTextField(20);
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
		ID = text1.getText();
		pw = text2.getText();
		if (e.getSource()==button1) {
			try {
				Check.checknum();
				dispose();
			}
			catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		else if (e.getSource()==button2) {
			new longin();
			dispose();
		}
	}
}
