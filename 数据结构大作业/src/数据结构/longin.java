package 数据结构;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class longin extends JFrame implements ActionListener{
	JButton button1,button2;
	public longin(){
		setLayout(new FlowLayout(1,800,25));
    	setBounds(350,400,800,350);
    	button1 = new JButton("管理员登录");
    	button2 = new JButton("普通员登录");
    	button1.setFont(new Font("黑体",Font.BOLD,20));
    	button2.setFont(new Font("黑体",Font.BOLD,20));
    	add(button1);
    	add(button2);
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button1) {
//			new courierlongin();
			dispose();
		}
		else if (e.getSource()==button2) {
//			new people();
			dispose();
		}
	}
	public static void main(String arg[]) {
		new longin();
	}
}
