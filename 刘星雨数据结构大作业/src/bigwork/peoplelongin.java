package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.*;

public class peoplelongin extends JFrame implements ActionListener{
	static String ID,pw;
	static JLabel in1,in2;
	static JButton button1,button2,button3;
	static JTextField input1,input2;
	public peoplelongin() {
		setLayout(new FlowLayout(1,500,1));
    	setBounds(350,400,800,350);
    	in1 = new JLabel("姓名");
    	add(in1);
    	input1 = new JTextField(20);
    	add(input1);
    	in2 = new JLabel("证件号");
    	add(in2);
    	input2 = new JTextField(20);
    	add(input2);
    	button1 = new JButton("确定");
    	add(button1);
    	button1.addActionListener(this);
    	button2 = new JButton("取消");
    	add(button2);
    	button2.addActionListener(this);
    	button3 = new JButton("注册");
    	add(button3);
    	button3.addActionListener(this);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		ID = input1.getText();
		pw = input2.getText();
		if (e.getSource()==button1) {
			try {
				check.checknum(0);
				dispose();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if(e.getSource()==button2){
			new longin();
			dispose();
		}
		else if(e.getSource()==button3){
			new register();
			dispose();
		}
	}
}
