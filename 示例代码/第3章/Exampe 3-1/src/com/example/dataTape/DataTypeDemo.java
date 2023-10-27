package com.example.dataTape;
public class DataTypeDemo {
	public static void main(String[] args) {
	 //byte a=129;   编译错误，byte类型最大为127
	  char b='b';
	  int c=b;
	  char e=\u0062;
	  char f=0142;
	  float d=2;
	  //float g=0.5;       编译错误
	  float k=0.5f;   //浮点型常量默认为double类型
	  System.out.println(c);
      System.out.println(d);
      System.out.println(e);
      System.out.println(f);
	}
}
