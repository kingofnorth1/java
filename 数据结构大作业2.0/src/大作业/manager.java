package ����ҵ;

import java.util.Scanner;

public class manager {
	static Scanner read = new Scanner(System.in);
	List list_ct=Filer.reader_file(1);		//��ȡ�����ļ�
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
			System.out.println("�Ƿ������(��q�˳�,��������ֵ����)");
			if (read.next()=="q") System.exit(0);;
			su=Interface.longong_ma1();
		}
		
	}
}
