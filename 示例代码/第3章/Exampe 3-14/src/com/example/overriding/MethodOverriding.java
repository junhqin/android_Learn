package com.example.overriding;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

public class MethodOverriding {
	public static void main(String[] args) {
		Jack jack=new Jack("Jack");
		jack.showName();
		Mary mary=new Mary("Mary");
		mary.showName();
	}
}
class Base
{
	public String name;
	public Base(String name)
	{
		this.name=name;
	}
	protected void showName() {
		System.out.println("父类showName( )方法："+name);
	}
}
class Jack extends Base
{
	public Jack(String name) {
		super(name);
	}
	public void showName() {
		System.out.println("子类Jack调用showName( )方法："+name);
	}
}
class Mary extends Base
{
	public Mary(String name) {
		super(name);
	}
	 protected void showName() {
		System.out.println("子类Mary调用showName( )方法："+name);
	}
}



