package bigwork;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class List {
	public Node<String> head;
	static String[] str = new String[20];
	public List(){
		this.head=new Node<String>();
	}
	public int showtext_list() {
		int i = 0;
		for (Node<String> p=this.head.next;p!=null;p=p.next) {
			str[i++] = p.str.toString();
		}
		return i;
	}
	public Node<String> insert(int i,String x) {  //增加
		if (x==null) return null;
			Node<String> front=this.head;
		for (int j=0;front.next!=null&&j<i;j++) {
			front=front.next;
		}
		front.next=new Node<String>(x,front.next);
		return front.next;
	}
		 
	public String remove(int i) {      //删除
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
		 
	public Node<String> change(int i,String x) {  //修改
		if (x==null) return null;
		Node<String> front=this.head;
		for (int j=0;front.next!=null&&j<i;j++) {
			front=front.next;
		}
		front.str=x;
		return front.next;
	}
		 
	public Node<String> search(String key) {   //查找
		int i=0,num;
		Node<String> front=this.head;
		num=Integer.parseInt(key);
		while ((i++)!=num) {
			front = front.next;
		}
			return front;
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
		if (su==1) st=(String) "饭堂";
		if (su==2) st=(String) "档口";
		if (su==3) st=(String) "菜品";
		
		return (String) ( st+":"+this.str.toString());
	}
}
