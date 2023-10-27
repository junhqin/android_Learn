package com.example.encapsulation;
public class Encapsulation {
	public static void main(String[] args) {
		Student st=new Student(22,"张三");
		System.out.println("学生的姓名是："+st.getName());
		System.out.println("学生的姓名是："+st.getAge());
	}
}
class Student
{
	private int age;
	private String name;

	public Student(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}


