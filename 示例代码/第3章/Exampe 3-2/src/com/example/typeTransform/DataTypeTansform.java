package com.example.typeTransform;
public class DataTypeTansform {
	public static void main(String[] args) {
		byte a=8;  
		short a1=a;    //�Զ�ת��
		char b='b';
		int b1=b;    //�Զ�ת��
		long c=b;   //�Զ�ת��
		int e=(int)32.85;    //ǿ������ת��
		long d=(long)2.78;   ///ǿ������ת��
		byte m=(byte)129;    //ǿ������ת��
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(e);
		System.out.println(d);
		System.out.println(m);
	}
}
