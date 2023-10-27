package com.example.flowControl;
public class FlowControlClause {
	public static void main(String[] args) {
		char a='d';
		switch(a)
		{
		case 'a':
			System.out.println("output is a!");
			break;
		case 'b':
			System.out.println("output is b!");
			break;
		case 'c':
			System.out.println("output is c!");
			break;
		case 'd':
			System.out.println("output is d!");
			break;
		default:
			System.out.println("output is e!");
			break;
		}
	}
}
