package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.*;
import javax.swing.event.*;

//���Ա������

public class courier extends JFrame implements ActionListener{
	JButton button1,button2,button3;
	JTextArea output1;
	static String str,str1,str2,regex;
	static int num1,num2;
	static LocalDate today = LocalDate.now();
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public courier() {
		setLayout(new FlowLayout(1,50,1));
    	setBounds(350,400,800,350);
    	button1 = new JButton("��ѯ");
    	button2 = new JButton("��ӿ��");
    	button3 = new JButton("ȡ���");
    	output1 = new JTextArea(9,50);
    	add(button1);
    	add(button2);
    	add(button3);
    	add(output1);
    	button1.addActionListener(this);
    	button2.addActionListener(this);
    	button3.addActionListener(this);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==button1) {
			try {
				rs = sql.executeQuery("select * from ��ݹ�");
				output1.append("*************************\n");
				while (rs.next()) {
					output1.append("��ں�:"+rs.getString(1)+" �ֻ���:"+rs.getString(2)+" ������:"+rs.getString(3)+" ȡ����:"+rs.getString(4)+" ���״̬:"+
							rs.getString(5)+" ��ڴ��ʱ��:"+rs.getString(6)+"\n");
					if (rs.getString(6)!=null) {
						regex = "\\d{4}-\\d{2}-";
						str = rs.getString(6);
						str = str.replaceAll(regex, "");
						DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						str1 = today.format(fmt);
						str1 = str1.replaceAll(regex, "");
						num1 = Integer.parseInt(str);
						num2 = Integer.parseInt(str1);
						if (num2 - num1 >= 1) {
							JOptionPane.showMessageDialog(null,"�������","��ݹ�:"+rs.getString(1)+"�ſ��24Сʱ��δȡ��",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				output1.append("*************************\n");
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource()==button2) {
			new addcourier();
			dispose();
		}
		else if (e.getSource()==button3) {
			new getcourier();
			dispose();
		}
	}
}
