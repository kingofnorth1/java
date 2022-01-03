package 大作业;

import java.util.Scanner;

public class Interface {
	static Scanner read = new Scanner(System.in);
	static int checkan() {
		System.out.println("请输入账号:");
		int sum=read.nextInt();
		return sum;
	}
	
	static void remined() {
		System.out.println("请输入所需数字:");
	}
	
	static int checkid() {
		System.out.println("请输入密码:");
		int sum=read.nextInt();
		return sum;
	}
	
	static void longon() {
		System.out.println("********");
		System.out.println("管理员登录1");
		System.out.println("普通人员登录2");
		System.out.println("*********");
	}
	
	static int longon_ma() {
		System.out.println("********");
		System.out.println("增加、1");
		System.out.println("删除、2");
		System.out.println("修改、3");
		System.out.println("查找、4");
		System.out.println("*********");
		int num;
		return num=read.nextInt();
	}
	
	static int longong_ma1() {
		System.out.println("********");
		System.out.println("饭堂、1");
		System.out.println("档口、2");
		System.out.println("菜品、3");
		System.out.println("*********");
		int num;
		return num=read.nextInt();
	}
	
	static int longon_pe() {
		System.out.println("********");
		System.out.println("查看价格、1");
		System.out.println("随机选择、2");
		System.out.println("查看随机结果、3");
		System.out.println("*********");
		int num;
		return num=read.nextInt();
	}
}
