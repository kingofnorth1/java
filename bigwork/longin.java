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
    	setTitle("˧С����������ϵͳ");
    	input1 = new JLabel("��ӭ˧С����������ϵͳ");
    	input1.setFont(new Font("����",Font.BOLD,45));
    	input1.setForeground(Color.blue);
    	input2 = new JLabel("��ѡ����ĵ�¼��ʽ");
    	input2.setFont(new Font("����",Font.BOLD,40));
    	input2.setForeground(Color.red);
    	add(input1);
    	add(input2);
    	button1 = new JButton("��ͨ�û���ѯ");
    	button1.setFont(new Font("����",Font.BOLD,20));
    	add(button1);
    	button1.addActionListener(this);
    	button2 = new JButton("�����û���ѯ");
    	button2.setFont(new Font("����",Font.BOLD,20));
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
