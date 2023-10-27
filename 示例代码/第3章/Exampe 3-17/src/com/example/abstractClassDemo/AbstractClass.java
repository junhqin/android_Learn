package com.example.abstractClassDemo;

public class AbstractClass {
	public static void main(String args[]) {
		Dog d = new Dog("wangwang", 5);
		d.move();
		d.getname();
		d.getage();
	}
}
abstract class Animal {
	String name;
	Animal(String name) { // 非抽象方法
		this.name = name;
	}
	void getname() { // 非抽象方法
		System.out.println("Animal's name is" + name);
	}
	abstract void move(); // 抽象方法，用abstract 修饰
}
class Dog extends Animal {
	int age;
	Dog(String name, int age) {
		super(name);
		this.age = age;
	}
	void move() {
		System.out.println("Dog  is running!");
	}
	void getage() {
		System.out.println("Dog is" + age + "  years  old");
	}
}