package com.example.inherit;
public class Inherit extends Base{
	public Inherit() {
		System.out.println("���๹�췽��Inherit()�� ");
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
		System.out.println("�޲ι��췽��Base( )��");
	}
	public String fly(String name,int distance)
	{
		return "��������Ϊ��"+name+",�����й��ķ��о���Ϊ��"+distance;
	}
}



