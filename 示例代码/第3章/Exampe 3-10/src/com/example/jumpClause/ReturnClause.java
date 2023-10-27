package com.example.jumpClause;
public class ReturnClause {
	public static void main(String[] args) {
		ReturnClause rc=new ReturnClause();
		rc.test1();
		System.out.println(rc.test2());
	}
	public void test1() { 
		System.out.println("---------无返回值类型的return语句测试--------"); 
		for (int i = 1; ; i++) { 
			if (i == 4) return; 
			System.out.println("i = " + i); 
		} 
	} 
	public String test2(){ 
		System.out.println("---------有返回值类型的return语句测试--------"); 
		return "返回一个字符串"; 
	} 
}
