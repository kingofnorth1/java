package bigwork;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class zonghe {
	static ResultSet rs;
	static int i=0;
	static String[] str = new String[20];
	static String[] str1 = new String[20];
	static String[] str2 = new String[20];
	static String[] str3 = new String[20];
	static String[] str4 = new String[20];
	static String[] str5 = new String[20];
	static Statement sql = Connections.doConnections();
	public static String[] zonghe1() {  //��ȡ�����
		try {
			rs = sql.executeQuery("SELECT * FROM ����");
			while (rs.next()) {
				str[i++] = rs.getString(3);
			}
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String zonghe2(String sr1,String sr2) {		//����Ʊ�����
		try {
			String sr = "select * from ���� where ��ʼ��='"+sr1+"'and Ŀ�ĵ�='"+sr2+"';";
			rs = sql.executeQuery(sr);
			while (rs.next()) {
				String str = rs.getString(6);
				return str;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	public static void zonghe3(String str,String str1,String str2) {		//�������Ʊ��
		try {
			String sr = "update ���� set ��Ʊ��='"+str+"' where ��ʼ��='"+str1+"'and Ŀ�ĵ�='"+str2+"';";
			
			int i = sql.executeUpdate(sr);
			if (i>0) {
				//д��ɹ�
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public static String zonghe4() {				//��ȡ�����
		try {
			rs = sql.executeQuery("SELECT * FROM ��");
			while (rs.next()) {
				String str = rs.getString(7);
				return str;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	public static int zonghe4_1() {				//��ȡ����Ϣ
		int i = 0;
		try {
			rs = sql.executeQuery("SELECT * FROM ��");
			while (rs.next()) {
				str1[i] = rs.getString(1);
				str2[i] = rs.getString(2);
				str3[i] = rs.getString(5);
				str4[i] = rs.getString(3);
				str5[i] = rs.getString(4);
				i++;
			}
			return i;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return (Integer) null;
	}
	public static void zonghe4_2(String str1,String str2,String str3,String str4) {
		try {
			String st = "delete from �� where ��ʼ��='"+str1+"'and Ŀ�ĵ�='"+str2+"'and ����='"+str3+"'and ֤����='"+str4+"';";
			int i = sql.executeUpdate(st);
			if (i>0) {
				//д��ɹ�
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public static void zonghe5() {			//�򲹸���
		int sum = zonghe.zonghe4_1();
		for (int i=0 ;i<sum ;i++) {
//			System.out.println(str1[i]+"  "+str2[i]+"   "+str3[i]);
			int num = Integer.parseInt(zonghe.zonghe2(str1[i],str2[i]));
			if (num != 0) {
				try {
					String sr = "insert into ��ͨ��Ա values " + "('"+str1[i]+"','"+str2[i]+"','"+str4[i]+"','"+str5[i]+"','"+str3[i]+"','"+"1"+"','"+people.today+"')";
					int i1 = sql.executeUpdate(sr);
					if (i1>0) {
						String j = (num-1) + "";
						zonghe.zonghe3(j,str1[i],str2[i]);				//д��ɹ�
						zonghe.zonghe4_2(str1[i],str2[i],str4[i],str5[i]);
					}
				}
				catch (SQLException e1) {
					
				}
			}
		}
	}
	public static List zonghe6() {				//������Ϣ��ȡ
		List list = new List();
		int i = 0;
		try {
			rs = sql.executeQuery("select * from ����");
			while (rs.next()) {
				String str = "��ʼ��:"+rs.getString(1)+" Ŀ�ĵ�:"+rs.getString(2)+" �����:"+rs.getString(3)+" �۸�:"+rs.getString(4)+" ����ʱ��:"+rs.getString(5)+" ��Ʊ��:"+rs.getString(6);
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
