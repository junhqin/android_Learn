package com.example.loopClause;
public class ForClause {
	public static void main(String[] args) {
		int sum=0;
		for(int i=0;i<=100;i++)
		{
			if(i%2==0)
			sum+=i;
		}
		System.out.println("1-100之间的偶数和为："+sum);
	}
}
