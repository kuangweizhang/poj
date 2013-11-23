/*
ID: kuangwe4
LANG: JAVA
TASK: fracdec
 */
package usaco;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class fracdec
{
	public static void main(String[] args) throws IOException
	{
		 BufferedReader f = new BufferedReader(new FileReader("fracdec.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new
		 FileWriter("fracdec.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int intpart = N / D;

		N -= intpart * D;
		LinkedList<Integer> list = new LinkedList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		while (true)
		{
			if (N == 0)
			{
				break;
			}
			list.add((N * 10) / D);
			map.put(N, list.size() - 1);
			N = N*10 - list.getLast() * D;
			if (map.containsKey(N))
			{
				break;
			}
		}
		
		StringBuilder ansBuilder = new StringBuilder();

		if (N == 0)
		{
			if(list.size() == 0)
			{
				list.add(0);
			}
			ansBuilder.append(intpart);
			ansBuilder.append(".");
			for (Integer integer : list)
			{
				ansBuilder.append(integer);
			}
		}
		else
		{
			ansBuilder.append(intpart);
			ansBuilder.append(".");
			int index = 0;
			for (Integer integer : list)
			{
				if (index == map.get(N))
				{
					ansBuilder.append("(");
				}
				ansBuilder.append(integer);
				index++;
			}
			ansBuilder.append(")");
		}

		int counter = 0;
		for (int i = 0; i < ansBuilder.length(); i++)
		{
			out.print(ansBuilder.charAt(i));
			counter++;
			if (counter == 76)
			{
				out.println();
				counter = 0;
			}
		}
		out.println();

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}