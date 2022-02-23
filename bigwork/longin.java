package bigwork;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class longin extends JFrame implements ActionListener{
    static JButton button1,button2;
    static JLabel input1,input2;
    public longin(){
    	setLayout(new FlowLayout(1,500,1));
    	setBounds(350,400,800,350);
    	setTitle("帅小伙龙虎航空系统");
    	input1 = new JLabel("欢迎帅小伙龙虎航空系统");
    	input1.setFont(new Font("黑体",Font.BOLD,45));
    	input1.setForeground(Color.blue);
    	input2 = new JLabel("请选择你的登录方式");
    	input2.setFont(new Font("黑体",Font.BOLD,40));
    	input2.setForeground(Color.red);
    	add(input1);
    	add(input2);
    	button1 = new JButton("普通用户查询");
    	button1.setFont(new Font("黑体",Font.BOLD,20));
    	add(button1);
    	button1.addActionListener(this);
    	button2 = new JButton("管理用户查询");
    	button2.setFont(new Font("黑体",Font.BOLD,20));
    	add(button2);
    	button2.addActionListener(this);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e) {
    	if (e.getSource()==button1) {
    		new peoplelongin();
    		dispose();
    	}
    	else if (e.getSource()==button2) {
    		new adminlongin();
    		dispose();
    	}
    }
    public static void main(String args[]) {
    	new longin();
    }
}
