package com.example.inherit;
public class SuperDemo extends Base{
	public SuperDemo() {
		super();
		System.out.println("���๹�췽��Inherit()�� ");
	}
	public SuperDemo(String name,int distance) {
		super(name,distance);
		System.out.println("��������Ϊ��"+name+",�����й��ķ��о���Ϊ��"+distance);
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
		System.out.println("�޲ι��췽��Base( )��");
	}
	public Base(String countryName, int distance) {
		this.countryName = countryName;
		this.distance = distance;
		System.out.println("�вι��췽��Base( )��");
	}
	public String fly()
	{
		return "fly()�������У�";
	}
}



