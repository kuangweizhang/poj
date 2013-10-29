/*
ID: kuangwe4
LANG: JAVA
TASK: sprime
 */
package usaco;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class sprime {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(f.readLine());
		
		
		findsprime(0, n);
		
		for(Integer number : ans)
		{
			out.println(number);
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	static LinkedList<Integer> ans = new LinkedList<Integer>();
	
	public static void findsprime(int n, int digits)
	{
		if(Math.log10(n) + 1 >= digits)
		{
			ans.add(n);
			return;
		}
		
		for(int i = 1; i <= 9; i++)
		{
			if(i == 4||i == 6 || i== 8)
			{
				continue;
			}
			int newNumber = n*10+i;
			if(isPrime(newNumber))
			{
				findsprime(newNumber, digits);
			}
		}
	}
	
	
	static boolean isPrime(int n)
	{
		if(n == 1)
		{
			return false;
		}
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