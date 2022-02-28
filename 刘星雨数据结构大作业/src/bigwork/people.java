package bigwork;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.*;
import javax.swing.event.*;

public class people extends JFrame implements ActionListener{
	static JComboBox<String> comBox1,comBox2,comBox3;
	static JButton button1,button2,button3,button4,button5;
	static JTextArea textshow;
	static String str1,str2,str3,str4;
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	static String[] listdate = new String[] {"����", "�Ϻ�", "����", "����", "����", "���", "�ɶ�", "�Ͼ�", "����", "�人"};
	static String[] listdate2 = new String[20];
	static List list = new List();
	static LocalDate today = LocalDate.now();
	public people() {
		listdate2 = zonghe.zonghe1();
		setLayout(new FlowLayout(1,50,1));
    	setBounds(350,400,800,350);
    	comBox1 = new JComboBox<String>(listdate);
    	comBox2 = new JComboBox<String>(listdate);
    	comBox3 = new JComboBox<String>(listdate2);
    	textshow = new JTextArea(20,50);
    	button1 = new JButton("��ѯ");
    	button2 = new JButton("��Ʊ");
    	button3 = new JButton("��Ʊ");
    	button4 = new JButton("��Ʊ��¼");
    	button5 = new JButton("��ʾȫ��");
    	add(comBox1);
    	add(comBox2);
    	add(comBox3);
    	add(button1);
    	button1.addActionListener(this);
    	add(button2);
    	button2.addActionListener(this);
    	add(button3);
    	button3.addActionListener(this);
    	add(button4);
    	button4.addActionListener(this);
    	add(button5);
    	button5.addActionListener(this);
    	add(textshow);
    	setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e) {
		str1 = (String) comBox1.getSelectedItem();
		str2 = (String) comBox2.getSelectedItem();
		str3 = (String) comBox3.getSelectedItem();
		if (e.getSource()==button1) {
			try {
				rs = sql.executeQuery("SELECT * FROM ����");
				while (rs.next()) {
					if (str1.equals(rs.getString(1)) && str2.equals(rs.getString(2)) && str3.equals(rs.getString(3))) {
						textshow.append("ʼ����:" + rs.getString(1) + " Ŀ�ĵ�:" + rs.getString(2) + " �����:" + rs.getString(3) + " �۸�:" + rs.getString(4) + " ����ʱ��:" + rs.getString(5) + " ��Ʊ��:" + rs.getString(6)+"\n");
					}
				}
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
		}
		else if (e.getSource()==button2) {
			int num = Integer.parseInt(zonghe.zonghe2(str1,str2));
			if (num > 0) {
				try {
					String str = "insert into ��ͨ��Ա values"+"(\'"+str1+"\',\'"+str2+"\',\'"+peoplelongin.ID+"\',\'"+peoplelongin.pw+"\',\'"+str3+"\',\'"+"1"+"\',\'"+today+"\')";
					int i = sql.executeUpdate(str);
					if (i>0) {
						new people();					//д��ɹ�
					}
					else {
						JOptionPane.showMessageDialog(null,"д��ʧ��","д��ʧ��,����д��",JOptionPane.WARNING_MESSAGE);
					}
					String j=(num-1) + "";
					zonghe.zonghe3(j,str1,str2);
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				dispose();
			}
			else if (num == 0) {
				JOptionPane.showMessageDialog(null,"��","�޶����Ʊ,����Ӻ�",JOptionPane.WARNING_MESSAGE);
				int num1 = Integer.parseInt(zonghe.zonghe4())+1;
				try {
					String str = "insert into �� values"+"(\'"+str1+"\',\'"+str2+"\',\'"+peoplelongin.ID+"\',\'"+peoplelongin.pw+"\',\'"+str3+"\',\'"+today+"\',\'"+num1+"\')";
					int i = sql.executeUpdate(str);
					if (i>0) {
						new people();					//д��ɹ�
					}
					else {
						JOptionPane.showMessageDialog(null,"д��ʧ��","д��ʧ��,����д��",JOptionPane.WARNING_MESSAGE);
					}
					String j=(num-1) + "";
					zonghe.zonghe3(j,str1,str2);
				}
				catch (SQLException e1) {
					e1.printStackTrace();
				}
				dispose();
				
			}
		}
		else if (e.getSource()==button3) {
			int num = Integer.parseInt(zonghe.zonghe2(str1,str2));
			try {
				String str = "delete from ��ͨ��Ա where ����='"+peoplelongin.ID+"'and ֤����='"+peoplelongin.pw+"';";
				int i = sql.executeUpdate(str);
				if (i>0) {
					new people();					//д��ɹ�
				}
				else {
					JOptionPane.showMessageDialog(null,"д��ʧ��","д��ʧ��,����д��",JOptionPane.WARNING_MESSAGE);
				}
				String j=(num+1) + "";
				zonghe.zonghe3(j,str1,str2);
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
			zonghe.zonghe5();
			dispose();
		}
		else if (e.getSource()==button4) {
			try{
				rs = sql.executeQuery("select * from ��ͨ��Ա");
				textshow.append("***********��Ʊ��¼************\n");
				while (rs.next()) {
					if (rs.getString(3).equals(peoplelongin.ID)) {
						textshow.append("��ʼ��:"+rs.getString(1)+" Ŀ�ĵ�:"+rs.getString(2)+" ����:"+rs.getString(3)+" ֤����:"+
								rs.getString(4)+" �����:"+rs.getString(5)+" Ʊ��:"+rs.getString(6)+" ����:"+rs.getString(7)+"\n");
					}
				}
				textshow.append("****************************\n");
			}
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		else if (e.getSource()==button5) {
			list = zonghe.zonghe6();
			int sum = list.showtext_list();
			textshow.append("***********��ʾȫ��************\n");
			for(int j=0;j<sum;j++) {
	    		textshow.append(list.str[j]+"\n");
	    	}
			textshow.append("****************************\n");
		}
	}
	
}
