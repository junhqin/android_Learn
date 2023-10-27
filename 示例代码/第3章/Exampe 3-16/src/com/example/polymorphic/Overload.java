package com.example.polymorphic;

public class Overload {
	public static void main(String[] args) {
		Flower flower = new Flower(8); 
		flower.info(); 
		flower.info("overloading method"); 
		new Flower(); 
	} 
}
class Flower{ 
	int height; 
	Flower(){ 
		System.out.println("Plantinga seeding"); 
		height = 0;
	} 
	Flower(int initialHeight){ 
		height = initialHeight; 
		System.out.println("Creating New Flower that  is " + height + " feet tall."); 
	} 
	public int info(){ 
		System.out.println("Flower is " + height + " feet tall."); 
		return 0;
	} 
	void info(String str){ 
		System.out.println(str+":Flower  " + height + " feet tall."); 
	} 
} 