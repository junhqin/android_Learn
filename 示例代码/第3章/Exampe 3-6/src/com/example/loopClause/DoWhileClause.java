package com.example.loopClause;
public class DoWhileClause {
	public static void main(String[] args) {
		int i=0; int sum=0;
		do
		{
			i++;
			if(i%2==0)
			sum+=i;
		}
		while(i<=100);
		System.out.println("1-100之间的偶数和为："+sum);
	}
}
