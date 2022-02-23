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
	public static String[] zonghe1() {  //读取航班号
		try {
			rs = sql.executeQuery("SELECT * FROM 航班");
			while (rs.next()) {
				str[i++] = rs.getString(3);
			}
			return str;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	public static String zonghe2(String sr1,String sr2) {		//返回票数余额
		try {
			String sr = "select * from 航班 where 初始地='"+sr1+"'and 目的地='"+sr2+"';";
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
	public static void zonghe3(String str,String str1,String str2) {		//更新余额票数
		try {
			String sr = "update 航班 set 余票额='"+str+"' where 初始地='"+str1+"'and 目的地='"+str2+"';";
			
			int i = sql.executeUpdate(sr);
			if (i>0) {
				//写入成功
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public static String zonghe4() {				//读取候补序号
		try {
			rs = sql.executeQuery("SELECT * FROM 候补");
			while (rs.next()) {
				String str = rs.getString(7);
				return str;
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return null;
	}
	public static int zonghe4_1() {				//读取候补信息
		int i = 0;
		try {
			rs = sql.executeQuery("SELECT * FROM 候补");
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
			String st = "delete from 候补 where 初始地='"+str1+"'and 目的地='"+str2+"'and 姓名='"+str3+"'and 证件号='"+str4+"';";
			int i = sql.executeUpdate(st);
			if (i>0) {
				//写入成功
			}
		}
		catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	public static void zonghe5() {			//候补更新
		int sum = zonghe.zonghe4_1();
		for (int i=0 ;i<sum ;i++) {
//			System.out.println(str1[i]+"  "+str2[i]+"   "+str3[i]);
			int num = Integer.parseInt(zonghe.zonghe2(str1[i],str2[i]));
			if (num != 0) {
				try {
					String sr = "insert into 普通人员 values " + "('"+str1[i]+"','"+str2[i]+"','"+str4[i]+"','"+str5[i]+"','"+str3[i]+"','"+"1"+"','"+people.today+"')";
					int i1 = sql.executeUpdate(sr);
					if (i1>0) {
						String j = (num-1) + "";
						zonghe.zonghe3(j,str1[i],str2[i]);				//写入成功
						zonghe.zonghe4_2(str1[i],str2[i],str4[i],str5[i]);
					}
				}
				catch (SQLException e1) {
					
				}
			}
		}
	}
	public static List zonghe6() {				//链表信息读取
		List list = new List();
		int i = 0;
		try {
			rs = sql.executeQuery("select * from 航班");
			while (rs.next()) {
				String str = "初始地:"+rs.getString(1)+" 目的地:"+rs.getString(2)+" 航班号:"+rs.getString(3)+" 价格:"+rs.getString(4)+" 飞行时间:"+rs.getString(5)+" 余票额:"+rs.getString(6);
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
