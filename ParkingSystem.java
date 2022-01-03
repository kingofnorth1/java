//package java作业;
import java.util.ArrayList;
import java.util.Scanner;

interface IParking {
	// 打印输出结果
	public void print();
	// 检查是否有 carType 对应的停车位
	// 如果没有空车位，请返回 false ，否则将该车停入车位并返回 true
	public boolean addCar(int carType);
	// 解析命令行输入的参数（格式），如文档描述
	public static IParams parse() throws Exception{
		
		return new sut();
	};
}	

interface IParams {
	// 获取大车位
	public int getBig();
	// 获取中车位
	public int getMedium();
	// 获取小车位
	public int getSmall();
	// 获取停车序列，例如 [1 2 2 3] 表示 依次停一辆大车，中车，中车，小车
	public ArrayList<Integer> getPlanParking();
}


class sut implements IParams{
	static ArrayList<Integer> plan =new ArrayList<Integer>(); 
	Scanner input = new Scanner(System.in);
	// 获取大车位
	public int getBig() {
		return input.nextInt();
	};
	// 获取中车位
	public int getMedium() {
		return input.nextInt();
	};
	// 获取小车位
	public int getSmall() {
		return input.nextInt();
	};
	// 获取停车序列，例如 [1 2 2 3] 表示 依次停一辆大车，中车，中车，小车
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


