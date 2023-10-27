package com.example.jumpClause;
public class BreakClause {
	public static void main(String[] args) {
		int k=0;boolean b;
		for(int i=100;i<=200;i++)
		{
			b=true;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					b=false;
					break;			
				}
			}
			if(b)
			{
				System.out.print(i);
				System.out.print('\t');
				k++;
				if(k%5==0)
					System.out.println();
			}
		}	
	}
}
