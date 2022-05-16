package ����ҵ;
import java.lang.*;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class List extends Object {
	static Scanner read = new Scanner(System.in);
	static Node<String> head;
	String str;
	int n=0,st=0;
	
	public List(){
		this.head=new Node<String>();
	}
	
	public String toSting(int su) {
		String str = "";
		n+=1;
		switch (su) {
			case 1:	for (Node<String> p=this.head.next; p!=null;p=p.next) {
						str += (n++)+"�ŷ��ü۸�Ϊ:"+p.str.toString()+"Ԫ"+(p.next!=null?" , ":"");
					}
					n=0;
					return str;
			case 2:	for (Node<String> p=this.head.next; p!=null;p=p.next) {
						str += (n++)+"�ŵ��ڼ۸�Ϊ:"+p.str.toString()+"Ԫ"+(p.next!=null?" , ":"");
					}
					n=0;
					return str;
			case 3:	for (Node<String> p=this.head.next; p!=null;p=p.next) {
						str += (n++)+"�Ų�Ʒ�۸�Ϊ:"+p.str.toString()+"Ԫ"+(p.next!=null?" , ":"");
					}
					n=0;
					return str;	
			case 4: for (Node<String> p=this.head.next; p!=null;p=p.next) {
						str += (n++)+"��������Ϊ:"+p.str.toString()+(p.next!=null?" , ":"");
					}
					n=0;
					return str;	
		}
		return null;	
	}
	
	public String toSting(int su,int array[]) {
		String str = "";
		Node<String> p = this.head.next;
		switch (su) {
			case 1:	for (int i=0;i<array.length && p!=null;i++,p=p.next) {
						str += (array[i]+1)+"�ŷ��ü۸�Ϊ:"+p.str.toString()+"Ԫ"+(p.next!=null?" , ":"");
					}
					n=0;
					return str;
			case 2:	for (int i=0;i<array.length && p!=null;i++,p=p.next) {
						str += (array[i]+1)+"�ŵ��ڼ۸�Ϊ:"+p.str.toString()+"Ԫ"+(p.next!=null?" , ":"");
					}
					n=0;
					return str;
			case 3:	for (int i=0;i<array.length && p!=null;i++,p=p.next) {
						str += (array[i]+1)+"�Ų�Ʒ�۸�Ϊ:"+p.str.toString()+"Ԫ"+(p.next!=null?" , ":"");
					}
					n=0;
					return str;
		}
		return null;	
	}
	
	public int[] sort() {						//ͬʱ��������������ð������,��������õ�����ı����
		Node<String> tail=null,cur=null;
		int array[]=new int[20],j,num,sum;
		cur=this.head.next;
		for (Node<String> p=this.head.next;p!=null;p=p.next) {
			array[st]=st;
			st+=1;
		}
		for (int i=0;i<array.length-1 && cur.next!=tail;i++) {
			for (j=0;j<array.length-1-i && cur.next!=tail;j++) {
				num=Integer.parseInt(cur.str.toString());
				sum=Integer.parseInt(cur.next.str.toString());
				if (num>sum) {
					str=cur.str;
					cur.str=cur.next.str;
					cur.next.str=str;
					st=array[j];
					array[j]=array[j+1];
					array[j+1]=st;
				}
				cur=cur.next;
			}
			tail=cur;
			cur=this.head.next;
		}
		st=0;
//		while (cur.next!=tail) {
//			while (cur.next!=tail) {
//				num=Integer.parseInt(cur.str.toString());
//				sum=Integer.parseInt(cur.next.str.toString());
//				if (num>sum) {
//					str=cur.str;
//					cur.str=cur.next.str;
//					cur.next.str=str;
//				}
//				cur=cur.next;
//			}
//			tail=cur;
//			cur=this.head.next;
//		}
		return array;
	}
	
	public String random_pe(int sum) {
		int st=0,num,i=0;
		String str = null,stm;
		Random rom=new Random();
		if (sum==1) str="����";
		if (sum==2) str="����";
		if (sum==3) str="��Ʒ";
		for (Node<String> p=this.head.next;p!=null;p=p.next) {
			st+=1;
		}
		num = rom.nextInt(st)+1;
		for (Node<String> p=this.head.next;p!=null;p=p.next) {
			i++;
			if (i==num) {
				LocalDate today = LocalDate.now();
				stm = i+"��"+str+"�۸�"+p.str.toString()+"Ԫ";
				str = "������: "+num+"��"+str+"�۸�:"+p.str.toString()+"Ԫ";
				System.out.println(str);
				return stm;
			}
		}
		return null;
	}
	
	public Node<String> insert(int i,String x) {  //����
		if (x==null) return null;
			Node<String> front=this.head;
		for (int j=0;front.next!=null&&j<i;j++) {
			front=front.next;
		}
		front.next=new Node<String>(x,front.next);
		return front.next;
	}
		 
	public String remove(int i) {      //ɾ��
		Node<String> front=this.head;
		for (int j=0;front.next!=null && j<i;j++) {
			front=front.next;
		}
		if (i>0 && front.next!=null) {
			String x=front.next.str;
			front.next=front.next.next;
			return x;
		}
		return null;
	}
		 
	public Node<String> change(int i,String x) {  //�޸�
		if (x==null) return null;
		Node<String> front=this.head;
		for (int j=0;front.next!=null&&j<i;j++) {
			front=front.next;
		}
		front.str=x;
		return front.next;
	}
		 
	public Node<String> search(String key) {   //����
		int i=0,num;
		Node<String> front=this.head;
		num=Integer.parseInt(key);
		while ((i++)!=num) {
			front = front.next;
		}
			return front;
	}
	
	static void select(List gist,int num,int su) {
		switch(num) {
		case 1:	Interface.remined();
				gist.insert(read.nextInt(), read.next());		//д���ļ�
				System.out.println(gist.toSting(su));
				Filer.writer_file(gist,su,null);
				break;
		case 2:	Interface.remined();
				gist.remove(read.nextInt());
				System.out.println(gist.toSting(su));
				Filer.writer_file(gist,su,null);
				break;
		case 3:	Interface.remined();
				gist.change(read.nextInt(), read.next());
				System.out.println(gist.toSting(su));
				Filer.writer_file(gist,su,null);
				break;
		case 4:	Interface.remined();
				Node<String> nist=new Node<String>();
				nist=gist.search(read.next());
				System.out.println(nist.ToString(su));
				break;
		}
	}
}

class Node<String>{
	public String str;
	public Node<String> next;
	public Node(String str,Node<String> next) {
		this.str=str;
		this.next=next;
	}
	public Node() {
		this(null,null);
	}
	public String ToString(int su) {
		String st = null;
		if (su==1) st=(String) "����";
		if (su==2) st=(String) "����";
		if (su==3) st=(String) "��Ʒ";
		
		return (String) ( st+":"+this.str.toString());
	}
}
