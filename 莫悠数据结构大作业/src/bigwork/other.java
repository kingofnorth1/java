package bigwork;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//其他类

public class other {
	static String []str = new String[20];
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public static String[] other1(){
		int i=0;
		try {
			rs = sql.executeQuery("SELECT * FROM 快递柜");
			while (rs.next()) {
				str[i++] = rs.getString(1);
			}
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void other2(String str) {
		File file = new File("D:\\eclipse软件\\java文件\\莫悠数据结构大作业\\src\\bigwork\\用户.txt");
		String str1 = "您还有其他快递尚未取件:";
		try {
			Writer out= new FileWriter(file,true);
			BufferedWriter bufferWrite = new BufferedWriter(out);
			bufferWrite.write(str1+str);
			bufferWrite.newLine();
			bufferWrite.close();
			out.close();
		}
		catch (Exception e) {
			e.toString();
		}
	}
	
	public static void other3(String str) {
		File file = new File("D:\\eclipse软件\\java文件\\莫悠数据结构大作业\\src\\bigwork\\用户.txt");
		try {
			Writer out= new FileWriter(file,true);
			BufferedWriter bufferWrite = new BufferedWriter(out);
			bufferWrite.write("您的取件码:"+str+"已失效");
			bufferWrite.newLine();
			bufferWrite.close();
			out.close();
		}
		catch (Exception e) {
			e.toString();
		}
	}
	
	public static List other4() {
		List list = new List();
		int i = 0;
		try {
			rs = sql.executeQuery("select * from 快递柜");
			while (rs.next()) {
				String str = "格口号:"+rs.getString(1)+" 手机号:"+rs.getString(2)+" 格口类别:"+rs.getString(3)+" 取件码:"+rs.getString(4)+" 格口状态:"+rs.getString(5)+" 格口存放时间:"+rs.getString(6);
				list.insert(i, str);
			}
			return list;
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
