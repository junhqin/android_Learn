package com.example.inherit;
public class SuperDemo extends Base{
	public SuperDemo() {
		super();
		System.out.println("子类构造方法Inherit()！ ");
	}
	public SuperDemo(String name,int distance) {
		super(name,distance);
		System.out.println("国家名字为："+name+",距离中国的飞行距离为："+distance);
		System.out.println(super.fly());
	}
	void testConstant()
	{
		System.out.println(super.location);
	}
	public static void main(String[] args) {
		SuperDemo sd1=new SuperDemo();
		SuperDemo sd2=new SuperDemo("Germany", 13000);
		sd1.testConstant();
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
	public Base(String countryName, int distance) {
		this.countryName = countryName;
		this.distance = distance;
		System.out.println("有参构造方法Base( )！");
	}
	public String fly()
	{
		return "fly()方法运行！";
	}
}



