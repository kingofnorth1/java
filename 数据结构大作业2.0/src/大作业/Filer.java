package 大作业;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.*;

import javax.swing.JOptionPane;

class Filer {
	static Scanner read = new Scanner(System.in);				//写入文件
	static File file = null;
	static String str;
	static int i=0;
	static File file_1=new File("D:\\eclipse软件\\java文件\\管理员.txt");
	static File file_2=new File("D:\\eclipse软件\\java文件\\普通人员.txt");		
	static File file_3=new File("D:\\eclipse软件\\java文件\\饭堂.txt");			//读取文 件
	static File file_4=new File("D:\\eclipse软件\\java文件\\档口.txt");
	static File file_5=new File("D:\\eclipse软件\\java文件\\菜品.txt");
	static File file_6=new File("D:\\eclipse软件\\java文件\\随机记录.txt");
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public static void longinFile(){
		String str;
		int sum,sum1;
		try {
			Interface.longon();
			switch(read.nextInt()) {
				case 1: sum = Interface.checkan();
						sum1 = Interface.checkid();
						String str1= "select * from 管理员登录 where 账号='"+sum+"'and 密码='"+sum1+"';";
						rs = sql.executeQuery(str1);
						if (rs.next()) {
							new manager();
						}
						else {
							JOptionPane.showMessageDialog(null,"登录失败","登录失败,重新登录",JOptionPane.WARNING_MESSAGE);
						}break;
				case 2: sum = Interface.checkan();
						sum1 = Interface.checkid();
						String str2= "select * from 普通用户登录 where 账号='"+sum+"'and 密码='"+sum1+"';";
						rs = sql.executeQuery(str2);
						if (rs.next()) {
							new people();
						}
						else {
							JOptionPane.showMessageDialog(null,"登录失败","登录失败,重新登录",JOptionPane.WARNING_MESSAGE);
						}break;
			}
		}
		catch (Exception e){
			System.out.println(e.toString());
		}
	}
	public static List reader_file(int num) {
		String regex="\\D{2}\\d{1}:";
		String regex1="\\d{4}-\\d{2}\\-\\d{2}\\D{2}\\d{1}:";
		String str2 = null,str1=null;
		List list=new List();
		if (num==1) str1 = "select * from 饭堂 where 平均价格!='"+str2+"';";
		if (num==2) str1 = "select * from 档口 where 平均价格!='"+str2+"';";
		if (num==3) str1 = "select * from 菜品 where 价格!='"+str2+"';";
		if (num==1 | num==2 | num == 3) {
			try {
				rs = sql.executeQuery(str1);
				while (rs.next()) {
					str=rs.getString(2);
					list.insert(i++, str);
				}
				return list;
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (num==4) {
			str1 = "select * from 随机记录";
			try {
				rs = sql.executeQuery(str1);
				while (rs.next()) {
					str=rs.getString(2);
					list.insert(i++, str);
				}
				return list;
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		return null;
	}
	
	public static void writer_file(List list,int num,String stm) {
		int i=0; 
		String str1=null;
		LocalDate today = LocalDate.now();
		if (num==1 || num==2 || num==3) {
			for (Node p=list.head;p!=null;p=p.next) {
				i+=1;
			}
			try {
				for (int j=1;j<i;j++) {
					String str = list.head.next.str.toString();
					if (num==1) str1 = "update 饭堂 set 平均价格='"+str+"' where 饭堂号='"+j+"';";
					if (num==2) str1 = "update 档口 set 平均价格='"+str+"' where 档口号='"+j+"';";
					if (num==3) str1 = "update 菜品 set 价格='"+str+"' where 菜品号='"+j+"';";
					int num1 = sql.executeUpdate(str1);
					list.head=list.head.next;
				}
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
		if (num==4) {
			String str5 = null;
			str1 = "select * from 随机记录";
			int num3 = 0;
			try {
				rs = sql.executeQuery(str1);
				while (rs.next()) {
					num3+=1;
				}
				System.out.println(num3);
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
			try {
				String str = stm;
				num3+=1;
				str1 = "insert into 随机记录 values" + "('"+num3+"','"+stm+"','"+today+"')";
				int num1 = sql.executeUpdate(str1);
			}
			catch (SQLException e) {
				System.out.println(e.toString());
			}
		}
	}
}

