package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.event.*;

public class admin extends JFrame implements ActionListener{
	JComboBox<String> comBox1,comBox2;
	JTextField text1,text2,text3,text4;
	JLabel input1,input2,input3,input4;
	JButton button1;
	String str1,str2,str3,str4,str5,str6;
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	static String[] listdate = new String[] {"����", "�Ϻ�", "����", "����", "����", "���", "�ɶ�", "�Ͼ�", "����", "�人"};
	public admin() {
		setLayout(new FlowLayout(1,500,1));
    	setBounds(350,400,800,350);
    	comBox1 = new JComboBox<String>(listdate);
    	comBox2 = new JComboBox<String>(listdate);
    	text1 = new JTextField(20);
    	text2 = new JTextField(20);
    	text3 = new JTextField(20);
    	text4 = new JTextField(20);
    	input1 = new JLabel("�����:");
    	input2 = new JLabel("�۸�:");
    	input3 = new JLabel("����ʱ��:");
    	input4 = new JLabel("��Ʊ��:");
    	button1 = new JButton("ȷ��¼��");
    	add(input1);
    	add(text1);
    	add(input2);
    	add(text2);
    	add(input3);
    	add(text3);
    	add(input4);
    	add(text4);
    	add(comBox1);
    	add(comBox2);
    	add(button1);
    	button1.addActionListener(this);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		str1 = (String) comBox1.getSelectedItem();
		str2 = (String) comBox2.getSelectedItem();
		str3 = text1.getText();
		str4 = text2.getText();
		str5 = text3.getText();
		str6 = text4.getText();
		if (e.getSource()==button1) {
			String st = "insert into ���� values " + "('"+str1+"','"+str2+"','"+str3+"','"+str4+"','"+str5+"','"+str6+"')";
			try {
				int i = sql.executeUpdate(st);
				if (i>0) {
					new admin();
				}
				else {
					JOptionPane.showMessageDialog(null,"д��ʧ��","д��ʧ��,����д��",JOptionPane.WARNING_MESSAGE);
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			dispose();
		}
	}
	
}
