package com.example.jumpClause;
public class ContinueClause {
	public static void main(String[] args) {
		int k=0;boolean b;
		outer:for(int i=100;i<=200;i++)
		{
			b=true;
			for(int j=2;j<i;j++)
			{
				if(i%j==0)
				{
					b=false;
					continue outer;			
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
