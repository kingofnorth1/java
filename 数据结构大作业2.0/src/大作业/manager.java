package 大作业;

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
			System.out.println("是否继续？(按q退出,输入任意值继续)");
			if (read.next()=="q") System.exit(0);;
			su=Interface.longong_ma1();
		}
		
	}
}
