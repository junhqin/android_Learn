package com.example.abstractClassDemo;

public class AbstractMethod {
	public static void main(String args[]) {
		Audi_A6 a6=new Audi_A6();
		a6.startUp();
		a6.turbo();
		Audi_A8 a8=new Audi_A8();
		a8.startUp();
		a8.turbo();
	}
}

abstract class Car {
	public abstract void startUp();
}
abstract class Audi extends Car{
	public abstract void turbo();
}
class Audi_A6 extends Audi{
	public void startUp()    {
		System.out.println("调用了奥迪A6的启动功能！！！");
	}
	public void turbo()  {
		System.out.println("调用了奥迪A6的加速功能！！！");
	}
}
class Audi_A8 extends Audi{
	public void startUp(){
		System.out.println("调用了奥迪A8的启动功能！！！");
	}
	public void turbo(){
		System.out.println("调用了奥迪A8的加速功能！！！");
	}
}