/*
ID: kuangwe4
LANG: JAVA
TASK: lamps
 */
package usaco;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.swing.text.AbstractDocument.LeafElement;

class lamps {
	static LinkedList<Integer> mustOn = new LinkedList<Integer>();
	static LinkedList<Integer> mustOff = new LinkedList<Integer>();
	static int n;
	static int c;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("lamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		n = Integer.parseInt(f.readLine());
		c = Integer.parseInt(f.readLine());
		
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		while(true)
		{
			int k = Integer.parseInt(st.nextToken());
			if(k == -1)
			{
				break;
			}
			else {
				mustOn.add(k);
			}
		}
		
		st = new StringTokenizer(f.readLine());
		while(true)
		{
			int k = Integer.parseInt(st.nextToken());
			if(k == -1)
			{
				break;
			}
			else {
				mustOff.add(k);
			}
		}
		
		HashSet<Boolean[]> set = new HashSet<Boolean[]>();
		
		for(int i = 0; i <= 1; i++)
		{
			for(int j = 0; j <= 1; j++)
			{
				for(int k = 0; k <= 1; k++)
				{
					for(int l = 0; l <= 1; l++)
					{
						if(meet(i + j + k + l))
						{
							Boolean[] lamps = new Boolean[n];
							for(int p = 0; p < lamps.length; p++)
							{
								lamps[p] = true;
							}
							if(i == 1)
							{
								change1(lamps);
							}
							if(j == 1)
							{
								change2(lamps);
							}
							if(k == 1)
							{
								change3(lamps);
							}
							if(l == 1)
							{
								change4(lamps);
							}
							if(verify(lamps))
							{
								set.add(lamps);
							}
						}
					}
				}
			}
		}
		
		if(set.size() == 0)
		{
			out.println("IMPOSSIBLE");
			out.close();
			System.exit(0);
		}
		
		LinkedList<Boolean[]> list = new LinkedList<Boolean[]>();
		
		while(set.size() != 0)
		{
			Boolean[] min = null;
			for (Boolean[] booleans : set)
			{
				if(min == null)
				{
					min = booleans;
				}
				else {
					if(larger(min, booleans))
					{
						min = booleans;
					}
				}
			}
			list.addLast(min);
			set.remove(min);
		}
		
		
		for(int i = 0; i < list.size(); i++)
		{
			for(int j = 0; j < list.get(i).length - 1; j++)
			{
				out.print(print(list.get(i)[j]));
			}
			out.println(print(list.get(i)[n - 1]));
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static boolean larger(Boolean[] b1, Boolean[] b2)
	{
		for(int i = 0; i < b1.length; i++)
		{
			if(b1[i] && !b2[i])
			{
				return true;
			}
			if(!b1[i] && b2[i])
			{
				return false;
			}
		}
		return false;
	}
	
	private static int print(Boolean bool)
	{
		return bool ? 1 :0;
	}
	
	private static boolean meet(int k)
	{
		if(c <= 2)
		{
			return k==c;
		}
		else {
			if(c % 2 ==1)
			{
				return (k == 1)||(k == 3);
			}
			else {
				return (k == 0)||(k == 2)||(k == 4);
			}
		}
	}
	
	private static void change1(Boolean[] lights)
	{
		for(int i = 0; i < lights.length; i++)
		{
			if(lights[i])
			{
				lights[i] = false;
			}
			else {
				lights[i] = true;
			}
		}
	}
	
	private static void change2(Boolean[] lights)
	{
		for(int i = 0; i < lights.length; i+=2)
		{
			if(lights[i])
			{
				lights[i] = false;
			}
			else {
				lights[i] = true;
			}
		}
	}
	
	private static void change3(Boolean[] lights)
	{
		for(int i = 1; i < lights.length; i+=2)
		{
			if(lights[i])
			{
				lights[i] = false;
			}
			else {
				lights[i] = true;
			}
		}
	}
	
	private static void change4(Boolean[] lights)
	{
		for(int i = 0; i < lights.length; i+=3)
		{
			if(lights[i])
			{
				lights[i] = false;
			}
			else {
				lights[i] = true;
			}
		}
	}
	
	private static boolean verify(Boolean[] lights)
	{
		for (int k : mustOn)
		{
			if(!lights[k - 1])
			{
				return false;
			}
		}
		for (int k : mustOff)
		{
			if(lights[k - 1])
			{
				return false;
			}
		}
		return true;
	}
	
}