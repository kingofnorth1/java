package ����ҵ;

import java.util.Scanner;

public class Interface {
	static Scanner read = new Scanner(System.in);
	static int checkan() {
		System.out.println("�������˺�:");
		int sum=read.nextInt();
		return sum;
	}
	
	static void remined() {
		System.out.println("��������������:");
	}
	
	static int checkid() {
		System.out.println("����������:");
		int sum=read.nextInt();
		return sum;
	}
	
	static void longon() {
		System.out.println("********");
		System.out.println("����Ա��¼1");
		System.out.println("��ͨ��Ա��¼2");
		System.out.println("*********");
	}
	
	static int longon_ma() {
		System.out.println("********");
		System.out.println("���ӡ�1");
		System.out.println("ɾ����2");
		System.out.println("�޸ġ�3");
		System.out.println("���ҡ�4");
		System.out.println("*********");
		int num;
		return num=read.nextInt();
	}
	
	static int longong_ma1() {
		System.out.println("********");
		System.out.println("���á�1");
		System.out.println("���ڡ�2");
		System.out.println("��Ʒ��3");
		System.out.println("*********");
		int num;
		return num=read.nextInt();
	}
	
	static int longon_pe() {
		System.out.println("********");
		System.out.println("�鿴�۸�1");
		System.out.println("���ѡ��2");
		System.out.println("�鿴��������3");
		System.out.println("*********");
		int num;
		return num=read.nextInt();
	}
}
