package ����ҵ;

import java.util.Scanner;

public class manager {
	static Scanner read = new Scanner(System.in);
	int su,num;
	List list;
	public manager() {
		su=Interface.longong_ma1();
		while (true) {
			switch (su) {
				case 1: num=Interface.longon_ma();
						List.select(Filer.reader_file(1), num, su);break;
				case 2:	num=Interface.longon_ma();
						List.select(Filer.reader_file(2), num, su);break;
				case 3:	num=Interface.longon_ma();
						List.select(Filer.reader_file(3), num, su);break;
			}
			System.out.println("�Ƿ������(��q�˳�,��������ֵ����)");
			if (read.next()=="q") System.exit(0);;
			su=Interface.longong_ma1();
		}
		
	}
}
