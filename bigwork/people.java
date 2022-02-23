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
	static String[] listdate = new String[] {"北京", "上海", "广州", "深圳", "杭州", "天津", "成都", "南京", "西安", "武汉"};
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
    	button1 = new JButton("查询");
    	button2 = new JButton("订票");
    	button3 = new JButton("退票");
    	button4 = new JButton("订票记录");
    	button5 = new JButton("显示全部");
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
				rs = sql.executeQuery("SELECT * FROM 航班");
				while (rs.next()) {
					if (str1.equals(rs.getString(1)) && str2.equals(rs.getString(2)) && str3.equals(rs.getString(3))) {
						textshow.append("始发地:" + rs.getString(1) + " 目的地:" + rs.getString(2) + " 航班号:" + rs.getString(3) + " 价格:" + rs.getString(4) + " 飞行时间:" + rs.getString(5) + " 余票额:" + rs.getString(6)+"\n");
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
					String str = "insert into 普通人员 values"+"(\'"+str1+"\',\'"+str2+"\',\'"+peoplelongin.ID+"\',\'"+peoplelongin.pw+"\',\'"+str3+"\',\'"+"1"+"\',\'"+today+"\')";
					int i = sql.executeUpdate(str);
					if (i>0) {
						new people();					//写入成功
					}
					else {
						JOptionPane.showMessageDialog(null,"写入失败","写入失败,重新写入",JOptionPane.WARNING_MESSAGE);
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
				JOptionPane.showMessageDialog(null,"候补","无多余机票,已添加候补",JOptionPane.WARNING_MESSAGE);
				int num1 = Integer.parseInt(zonghe.zonghe4())+1;
				try {
					String str = "insert into 候补 values"+"(\'"+str1+"\',\'"+str2+"\',\'"+peoplelongin.ID+"\',\'"+peoplelongin.pw+"\',\'"+str3+"\',\'"+today+"\',\'"+num1+"\')";
					int i = sql.executeUpdate(str);
					if (i>0) {
						new people();					//写入成功
					}
					else {
						JOptionPane.showMessageDialog(null,"写入失败","写入失败,重新写入",JOptionPane.WARNING_MESSAGE);
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
				String str = "delete from 普通人员 where 姓名='"+peoplelongin.ID+"'and 证件号='"+peoplelongin.pw+"';";
				int i = sql.executeUpdate(str);
				if (i>0) {
					new people();					//写入成功
				}
				else {
					JOptionPane.showMessageDialog(null,"写入失败","写入失败,重新写入",JOptionPane.WARNING_MESSAGE);
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
				rs = sql.executeQuery("select * from 普通人员");
				textshow.append("***********订票记录************\n");
				while (rs.next()) {
					if (rs.getString(3).equals(peoplelongin.ID)) {
						textshow.append("初始地:"+rs.getString(1)+" 目的地:"+rs.getString(2)+" 姓名:"+rs.getString(3)+" 证件号:"+
								rs.getString(4)+" 航班号:"+rs.getString(5)+" 票数:"+rs.getString(6)+" 日期:"+rs.getString(7)+"\n");
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
			textshow.append("***********显示全部************\n");
			for(int j=0;j<sum;j++) {
	    		textshow.append(list.str[j]+"\n");
	    	}
			textshow.append("****************************\n");
		}
	}
	
}
