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
		System.out.println("老虎吃肉。");
	};
}
class Sheep extends Animal
{
	public void eat(){
		System.out.println("羊吃青草。");
	};
}
class Chicken extends Animal
{
	public void eat(){
		System.out.println("鸡吃饲料。");
	};
}
class TestInstance
{
	public void doSomething(Animal a)
	{
		if(a instanceof Tiger)
			System.out.println("这是老虎的实例");
		else if(a instanceof Sheep)
			System.out.println("这是羊的实例");
		else if(a instanceof Chicken)
			System.out.println("这是鸡的实例");
		else 
			System.out.println("这是动物的实例");
	}
}


