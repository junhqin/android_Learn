package com.example.interface_implement;

public class InterfaceDemo {
	public static void main(String[] args) {
		Edible stuff = new Chicken();
		Edible1 stuff1 = new Broccoli();
		eat(stuff);
		stuff = new Duck();
		eat(stuff);
		stuff = new Broccoli();
		eat(stuff);
		sleep(stuff1);
	}
	public static void eat(Edible stuff) {
		System.out.println(stuff.howToEat());
	}
	public static void sleep(Edible1 stuff1) {
		System.out.println(stuff1.howToSleep());
	}
}
interface Edible {
	String howToEat();
}
interface Edible1 {
	String howToSleep();
}
class Chicken implements Edible {
	public String howToEat() {
		return "Chicken";
	}
}
class Duck implements Edible {
	public String howToEat() {
		return "Duck";
	}
}
class Broccoli implements Edible, Edible1 {
	public String howToEat() {
		return "Broccoli";
	}
	public String howToSleep() {
		return "Sleep";
	}
}