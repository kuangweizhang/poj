/*
ID: kuangwe4
LANG: JAVA
TASK: pprime
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class pprime
{
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
			int palindrome = d1;
			if (palindrome >= a && palindrome <=b && isPrime(palindrome))
        	{
        		out.println(palindrome);
        	}
		}
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
			int palindrome = d1*10 + d1;
			if (palindrome >= a && palindrome <=b && isPrime(palindrome))
        	{
        		out.println(palindrome);
        	}
		}
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
		    for (int d2 = 0; d2 <= 9; d2++) 
		    {
		    	int palindrome = d1*100 + d2*10 + d1;
		    	if (palindrome >= a && palindrome <=b && isPrime(palindrome))
	        	{
	        		out.println(palindrome);
	        	}
		    }
		}
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
		    for (int d2 = 0; d2 <= 9; d2++) 
		    {
		    	int palindrome = d1*1000 + d2*100 + d2*10 + d1;
		    	if (palindrome >= a && palindrome <=b && isPrime(palindrome))
	        	{
	        		out.println(palindrome);
	        	}
		    }
		}
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
		    for (int d2 = 0; d2 <= 9; d2++) 
		    {
		        for (int d3 = 0; d3 <= 9; d3++)
		        {
		        	int palindrome = 10000*d1 + 1000*d2 +100*d3 + 10*d2 + d1;
		        	if (palindrome >= a && palindrome <=b && isPrime(palindrome))
		        	{
		        		out.println(palindrome);
		        	}
		        }
		    }
		}
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
		    for (int d2 = 0; d2 <= 9; d2++) 
		    {
		        for (int d3 = 0; d3 <= 9; d3++)
		        {
		        	int palindrome = 100000*d1 + 10000*d2 +1000*d3 + 100*d3 + 10*d2 + d1;
		        	if (palindrome >= a && palindrome <=b && isPrime(palindrome))
		        	{
		        		out.println(palindrome);
		        	}
		        }
		    }
		}
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
		    for (int d2 = 0; d2 <= 9; d2++) 
		    {
		        for (int d3 = 0; d3 <= 9; d3++)
		        {
					for (int d4 = 0; d4 <= 9; d4++)
					{
						int palindrome = 1000000 * d1 + 100000 * d2 + 10000 * d3 + 1000
								* d4 + 100 * d3 + 10 * d2 + d1;
						if (palindrome >= a && palindrome <= b
								&& isPrime(palindrome))
						{
							out.println(palindrome);
						}
					}
		        }
		    }
		}
		
		for (int d1 = 1; d1 <= 9; d1+=2)
		{
		    for (int d2 = 0; d2 <= 9; d2++) 
		    {
		        for (int d3 = 0; d3 <= 9; d3++)
		        {
					for (int d4 = 0; d4 <= 9; d4++)
					{
						int palindrome = 10000000 * d1 + 1000000 * d2 + 100000 * d3 + 10000
								* d4 + 1000 * d4 + 100 * d3 + 10 * d2 + d1;
						if (palindrome >= a && palindrome <= b
								&& isPrime(palindrome))
						{
							out.println(palindrome);
						}
					}
		        }
		    }
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	static boolean isPrime(int n)
	{
		for (int i = 2; i <= Math.sqrt(n); i++)
		{
			if (n % i == 0)
			{
				return false;
			}
		}
		return true;
	}
}