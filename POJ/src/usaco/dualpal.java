/*
ID: kuangwe4
LANG: JAVA
TASK: dualpal
 */
package usaco;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class dualpal {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("dualpal.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("dualpal.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		
		while(n != 0)
		{
			s++;
			int counter = 0;
			for(int i = 2; i <= 10; i++)
			{
				if(palindorme(changebase(s, i)))
				{
					counter++;
				}
			}
			if(counter > 1)
			{
				out.println(s);
				n--;
			}
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static LinkedList<Character> changebase(int n, int base)
	{
		LinkedList<Character> retval = new LinkedList<Character>();
		while (n != 0)
		{
			retval.add(getDigit(n % base));
			n = n / base;
		}
		return retval;
	}
	
	public static char getDigit(int n)
	{
		if(n < 10)
		{
			String st = n + "";
			return st.charAt(0);
		}
		else {
			return ((char)(n - 10 + (int)'A'));
		}
	}
	
	public static boolean palindorme(LinkedList<Character> number)
	{
		while(!number.isEmpty())
		{
			if(number.getFirst() != number.getLast())
			{
				return false;
			}
			else
			{
				number.pollFirst();
				if(!number.isEmpty())
				{
					number.pollLast();
				}
			}
		}
		return true;
	}
}