package com.example.jumpClause;
public class ReturnClause {
	public static void main(String[] args) {
		ReturnClause rc=new ReturnClause();
		rc.test1();
		System.out.println(rc.test2());
	}
	public void test1() { 
		System.out.println("---------�޷���ֵ���͵�return������--------"); 
		for (int i = 1; ; i++) { 
			if (i == 4) return; 
			System.out.println("i = " + i); 
		} 
	} 
	public String test2(){ 
		System.out.println("---------�з���ֵ���͵�return������--------"); 
		return "����һ���ַ���"; 
	} 
}
