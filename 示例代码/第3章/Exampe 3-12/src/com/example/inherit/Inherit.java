package com.example.inherit;
public class Inherit extends Base{
	public Inherit() {
		System.out.println("子类构造方法Inherit()！ ");
	}

	public static void main(String[] args) {
		Inherit in=new Inherit();
		System.out.println(in.location);
		System.out.println(in.fly("France", 12000));
	}
}
class Base
{
	String location="Europe";
	String countryName;
	int distance;
	Base() {
		System.out.println("无参构造方法Base( )！");
	}
	public String fly(String name,int distance)
	{
		return "国家名字为："+name+",距离中国的飞行距离为："+distance;
	}
}



