package bigwork;

import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//������

public class other {
	static String []str = new String[20];
	static ResultSet rs;
	static Statement sql = Connections.doConnections();
	public static String[] other1(){
		int i=0;
		try {
			rs = sql.executeQuery("SELECT * FROM ��ݹ�");
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
		File file = new File("D:\\eclipse���\\java�ļ�\\Ī�����ݽṹ����ҵ\\src\\bigwork\\�û�.txt");
		String str1 = "���������������δȡ��:";
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
		File file = new File("D:\\eclipse���\\java�ļ�\\Ī�����ݽṹ����ҵ\\src\\bigwork\\�û�.txt");
		try {
			Writer out= new FileWriter(file,true);
			BufferedWriter bufferWrite = new BufferedWriter(out);
			bufferWrite.write("����ȡ����:"+str+"��ʧЧ");
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
			rs = sql.executeQuery("select * from ��ݹ�");
			while (rs.next()) {
				String str = "��ں�:"+rs.getString(1)+" �ֻ���:"+rs.getString(2)+" ������:"+rs.getString(3)+" ȡ����:"+rs.getString(4)+" ���״̬:"+rs.getString(5)+" ��ڴ��ʱ��:"+rs.getString(6);
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
