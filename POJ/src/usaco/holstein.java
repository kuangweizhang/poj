/*
ID: kuangwe4
LANG: JAVA
TASK: holstein
 */
package usaco;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;


class holstein {
	static int v;
	static int g;
	static int[] vs;
	static int[][] gs;
	static LinkedList<Integer> ans = new LinkedList<Integer>();
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		v = Integer.parseInt(f.readLine());
		
		vs = new int[v + 1];
		StringTokenizer st = new StringTokenizer(f.readLine());
		for(int i = 1; i <= v; i++)
		{
			vs[i] = Integer.parseInt(st.nextToken());
			ans.add(2000);
		}
		ans.add(2000);
		g = Integer.parseInt(f.readLine());
		gs = new int[g + 1][v + 1];
		for(int i = 1; i <= g; i++)
		{
			st = new StringTokenizer(f.readLine());
			for(int j = 1; j <= v; j++)
			{
				gs[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(1, new LinkedList<Integer>(), new int[v + 1]);
		
		out.print(ans.size());
		for(Integer theans : ans)
		{
			out.print(" " + theans);
		}
		out.println();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static void search(int k, LinkedList<Integer> step, int[] sum)
	{
		boolean found = true;
		for(int i = 1; i <= v; i++)
		{
			if(sum[i] < vs[i])
			{
				found = false;
				break;
			}
		}
		if(found)
		{
			if (step.size() < ans.size())
			{
				ans = (LinkedList<Integer>) step.clone();
			}
			if(step.size() == ans.size())
			{
				for(int counter = 0; counter < step.size(); counter++)
				{
					if(step.get(counter) < ans.get(counter))
					{
						ans = (LinkedList<Integer>) step.clone();
						break;
					}
				}
			}
			return;
		}
		if(k > g)
		{
			return;
		}
		for(int i = 1; i <= v; i++)
		{
			sum[i] += gs[k][i]; 
		}
		step.addLast(k);
		search(k + 1, step, sum);
		for(int i = 1; i <= v; i++)
		{
			sum[i] -= gs[k][i]; 
		}
		step.removeLast();
		search(k + 1, step, sum);
	}
	
}