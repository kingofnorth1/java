package ����ҵ;
import java.io.*;
import java.util.*;

class Filer {
	static Scanner read = new Scanner(System.in);				//д���ļ�
	static File file = null;
	static String str;
	static int i=0;
	static File file_1=new File("D:\\eclipse���\\java�ļ�\\����Ա.txt");
	static File file_2=new File("D:\\eclipse���\\java�ļ�\\��ͨ��Ա.txt");		
	static File file_3=new File("D:\\eclipse���\\java�ļ�\\����.txt");			//��ȡ�� ��
	static File file_4=new File("D:\\eclipse���\\java�ļ�\\����.txt");
	static File file_5=new File("D:\\eclipse���\\java�ļ�\\��Ʒ.txt");
	static File file_6=new File("D:\\eclipse���\\java�ļ�\\�����¼.txt");
	public static void longinFile() {
		String str;
		int sum,sum1;
		try {
			Reader in = new FileReader(file_1);
			Reader in1 = new FileReader(file_2);
			BufferedReader bufferRead = new BufferedReader(in);
			BufferedReader bufferRead1 = new BufferedReader(in1);
			Interface.longon();
			switch(read.nextInt()) {
				case 1: while ((str=bufferRead.readLine())!= null) {
							sum = Integer.parseInt(str);
							sum1 = Integer.parseInt(bufferRead.readLine());
							if (sum==Interface.checkan()&&sum1==Interface.checkid()) {
								System.out.println("������ȷ");
								new manager();
								continue;
							}
							else System.out.println("�������");
						}break;
				case 2: while ((str=bufferRead1.readLine())!= null) {
							sum = Integer.parseInt(str);
							sum1 = Integer.parseInt(bufferRead.readLine());
							if (sum==Interface.checkan()&&sum1==Interface.checkid()) {
								System.out.println("������ȷ");
								new people();
								continue;
							}
							else System.out.println("�������");
						}break;
			}
			bufferRead1.close();
			bufferRead.close();
			in1.close();
			in.close();
		}
		catch (IOException e){
			System.out.println(e.toString());
		}
	}
	public static List reader_file(int num) {
		String regex="\\D{2}\\d{1}:";
		List list=new List();
		if (num==1) file=file_3; 
		if (num==2) file=file_4; 
		if (num==3) file=file_5; 
		if (num==1 | num==2 | num == 3) {
			try {
				Reader in=new FileReader(file);
				BufferedReader bufferRead=new BufferedReader(in);
				while ((str=bufferRead.readLine())!=null) {
					str=str.replaceAll(regex, "");
					list.insert(i++, str);
				}
				bufferRead.close();
				in.close();
				return list;
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		if (num==4) {
			file=file_6;
			try {
				String regex1="\\d{4}-\\d{2}\\-\\d{2}\\D{2}\\d{1}:";
				Reader in=new FileReader(file);
				BufferedReader bufferRead=new BufferedReader(in);
				while ((str=bufferRead.readLine())!=null) {
					str=str.replaceAll(regex1, "");
					list.insert(i++, str);
				}
				bufferRead.close();
				in.close();
				return list;
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		return null;
	}
	public static List reader_file_1(int num) {
		String regex="\\D{2}\\d{1}:\\D{2}-";
		List list=new List();
		if (num==1) file=file_3; 
		if (num==2) file=file_4; 
		if (num==3) file=file_5; 
		if (num==1 | num==2 | num == 3) {
			try {
				Reader in=new FileReader(file);
				BufferedReader bufferRead=new BufferedReader(in);
				while ((str=bufferRead.readLine())!=null) {
					str=str.replaceAll(regex, "");
					list.insert(i++, str);
				}
				bufferRead.close();
				in.close();
				return list;
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
		return null;
	}
	
	public static void writer_file(List list,int num,String stm) {
		int i=1; 
		if (num==1 || num==2 || num==3) {
			if (num==1) file=file_3;
			if (num==2) file=file_4; 
			if (num==3) file=file_5;
			try {
				Writer out=new FileWriter(file,true);
				BufferedWriter bufferWrite=new BufferedWriter(out);
				while (list.head.next!=null) {
					String str = null;
					if (num==1) str="����";
					if (num==2) str="����";
					if (num==3) str="��Ʒ";
					str += (i++)+":"+list.head.next.str.toString();
					bufferWrite.write(str);
					bufferWrite.newLine();
					list.head=list.head.next;
				}
				bufferWrite.close();
				out.close();
			}
			catch(IOException e) {
				System.out.println(e.toString());
			}
		}
		if (num==4) {
			if (num==4) file=file_6;
			try {
				Writer out=new FileWriter(file,true);
				BufferedWriter bufferWrite=new BufferedWriter(out);
				bufferWrite.write(stm);
				bufferWrite.newLine();
				bufferWrite.close();
				out.close();
			}
			catch (IOException e) {
				System.out.println(e.toString());
			}
		}
	}
}

