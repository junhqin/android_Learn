package com.example.typeTransform;
public class DataTypeTansform {
	public static void main(String[] args) {
		byte a=8;  
		short a1=a;    //自动转换
		char b='b';
		int b1=b;    //自动转换
		long c=b;   //自动转换
		int e=(int)32.85;    //强制类型转换
		long d=(long)2.78;   ///强制类型转换
		byte m=(byte)129;    //强制类型转换
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(e);
		System.out.println(d);
		System.out.println(m);
	}
}
