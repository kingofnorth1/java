package 大作业;

import java.util.Scanner;

public class people {
	static Scanner read = new Scanner(System.in);
	int num;
	String str;
	int array[]=new int[9];
	List list;
	List list_ct=Filer.reader_file(1);		//读取返回文件
	List list_gm=Filer.reader_file(2);
	List list_vg=Filer.reader_file(3);
	List list_re=Filer.reader_file(4);
	
	public people() {
		int num=Interface.longon_pe();
		while (true) {
			switch (num) {
			case 1:	num=Interface.longong_ma1();
					array=sort(num);
					System.out.println(list.toSting(num,array));
					break;
			case 2:	num=Interface.longong_ma1();
					sele(num);
					str=list.random_pe(num);   				//写入随机数据
					Filer.writer_file(list, 4, str);
					break;
			case 3: list=list_re;
			System.out.println(list.toSting(4));
					break;
			}
			System.out.println("是否继续？(按q退出,输入任意值继续)");
			if (read.next()=="q") break;
			num=Interface.longon_pe();
		}
	}
	
	public int[] sort(int n){
		if (n==1) list=list_ct;
		if (n==2) list=list_gm;
		if (n==3) list=list_vg;
		array=list.sort();
//		System.out.println(list.toSting(1));
		return array;
	}
	
	public void sele(int n){
		if (n==1) list=list_ct;
		if (n==2) list=list_gm;
		if (n==3) list=list_vg;
	}
}
