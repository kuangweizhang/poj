/*
ID: kuangwe4
LANG: JAVA
TASK: palsquare
 */
package usaco;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

class palsquare {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("palsquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("palsquare.out")));
//		
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		int base = Integer.parseInt(f.readLine());
		
		for(int i = 1; i <= 300; i++)
		{
			if(palindorme(changebase(i*i, base)))
			{
				LinkedList<Character> list = changebase(i, base);
				for(int j = list.size() - 1; j >=0 ; j--)
				{
					out.print(list.get(j));
				}
				out.print(" ");
				for (Character ch : changebase(i*i, base)) {
					out.print(ch);
				}
				out.println();
			}
		}
		out.close();
		System.exit(0);
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