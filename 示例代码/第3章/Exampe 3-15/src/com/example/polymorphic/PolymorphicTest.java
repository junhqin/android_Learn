package com.example.polymorphic;

public class PolymorphicTest {
	public static void main(String[] args) {
		Animal aa;
		aa=new Tiger();
		aa.eat();
		aa=new Sheep();
		aa.eat();
		aa=new Chicken();
		aa.eat();
		TestInstance ti=new TestInstance();
		Sheep sh=new Sheep();
		ti.doSomething(sh);
		ti.doSomething((Chicken)aa);
	}
}
class Animal
{
	public void eat(){};
}
class Tiger extends Animal
{
	public void eat(){
		System.out.println("�ϻ����⡣");
	};
}
class Sheep extends Animal
{
	public void eat(){
		System.out.println("�����ݡ�");
	};
}
class Chicken extends Animal
{
	public void eat(){
		System.out.println("�������ϡ�");
	};
}
class TestInstance
{
	public void doSomething(Animal a)
	{
		if(a instanceof Tiger)
			System.out.println("�����ϻ���ʵ��");
		else if(a instanceof Sheep)
			System.out.println("�������ʵ��");
		else if(a instanceof Chicken)
			System.out.println("���Ǽ���ʵ��");
		else 
			System.out.println("���Ƕ����ʵ��");
	}
}


