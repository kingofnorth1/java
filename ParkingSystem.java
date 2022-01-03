//package java��ҵ;
import java.util.ArrayList;
import java.util.Scanner;

interface IParking {
	// ��ӡ������
	public void print();
	// ����Ƿ��� carType ��Ӧ��ͣ��λ
	// ���û�пճ�λ���뷵�� false �����򽫸ó�ͣ�복λ������ true
	public boolean addCar(int carType);
	// ��������������Ĳ�������ʽ�������ĵ�����
	public static IParams parse() throws Exception{
		
		return new sut();
	};
}	

interface IParams {
	// ��ȡ��λ
	public int getBig();
	// ��ȡ�г�λ
	public int getMedium();
	// ��ȡС��λ
	public int getSmall();
	// ��ȡͣ�����У����� [1 2 2 3] ��ʾ ����ͣһ���󳵣��г����г���С��
	public ArrayList<Integer> getPlanParking();
}


class sut implements IParams{
	static ArrayList<Integer> plan =new ArrayList<Integer>(); 
	Scanner input = new Scanner(System.in);
	// ��ȡ��λ
	public int getBig() {
		return input.nextInt();
	};
	// ��ȡ�г�λ
	public int getMedium() {
		return input.nextInt();
	};
	// ��ȡС��λ
	public int getSmall() {
		return input.nextInt();
	};
	// ��ȡͣ�����У����� [1 2 2 3] ��ʾ ����ͣһ���󳵣��г����г���С��
	public ArrayList<Integer> getPlanParking(){
		for (int i=0;i<4;i++) {
			plan.add(input.nextInt());
		}
		return plan;
	};
}

public class ParkingSystem implements IParking{
	int []count = new int[4];
	String []sum = new String[4];
	static int a=0;

	public static void main(String[] args) throws Exception {
        IParams params = IParking.parse();//ParkingSystem.parse();
        ParkingSystem ps = new ParkingSystem(params.getBig(), params.getMedium(),params.getSmall());
        ArrayList<Integer> plan = params.getPlanParking();
        for (int i = 0; i < plan.size(); i++) {
            ps.addCar(plan.get(i));
        }
        ps.print();
    }
	public ParkingSystem(int big, int medium, int small) {
		count[1]=big;
		count[2]=medium;
		count[3]=small;
	}

	public void print() {
		a=0;
		for(int i=0;i<sum.length;i++) {
			System.out.printf("%s\t",sum[a++]);
		}
		System.out.println();
		
	}

	public boolean addCar(int carType) {
		if (count[carType]-1>=0) {
			count[carType]--;
			sum[a++]="true";
			return true;
		}
		sum[a++]="false";
		return false; 
	}
}


