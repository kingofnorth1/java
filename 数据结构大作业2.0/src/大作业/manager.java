package 大作业;

import java.util.Scanner;

public class manager {
	static Scanner read = new Scanner(System.in);
	List list_ct=Filer.reader_file(1);		//读取返回文件
	List list_gm=Filer.reader_file(2);
	List list_vg=Filer.reader_file(3);
	int su,num;
	public manager() {
		su=Interface.longong_ma1();
		while (true) {
			switch (su) {
				case 1: num=Interface.longon_ma();
						List.select(list_ct, num, su);break;
				case 2:	num=Interface.longon_ma();
						List.select(list_gm, num, su);break;
				case 3:	num=Interface.longon_ma();
						List.select(list_vg, num, su);break;
			}
			System.out.println("是否继续？(按q退出,输入任意值继续)");
			if (read.next()=="q") System.exit(0);;
			su=Interface.longong_ma1();
		}
		
	}
}
