package com.example.loopClause;
public class WhileClause {
	public static void main(String[] args) {
		int i=0; int sum=0;
		while(i<=100)
		{
			i++;
			if(i%2==0)
				sum+=i;
		}
		System.out.println("1-100之间的偶数和为："+sum);
	}
}
