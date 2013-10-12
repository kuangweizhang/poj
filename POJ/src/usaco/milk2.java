/*
ID: kuangwe4
LANG: JAVA
TASK: milk2
 */

package usaco;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

class milk2 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(f.readLine());
		boolean[] table = new boolean[1000000];
		int mintime = Integer.MAX_VALUE;
		int maxtime = Integer.MIN_VALUE;
		for(int i = 0; i < n ; i++)
		{
			StringTokenizer st = new StringTokenizer(f.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			if (start < mintime)
			{
				mintime = start;
			}
			if (end > maxtime)
			{
				maxtime = end;
			}
			for(int j = start + 1; j <= end; j++)
			{
				table[j] = true;
			}
		}
		
		int maxYes = 0;
		int maxNo = 0;
		int counter = 1;
		for(int i = mintime + 2; i <= maxtime + 1; i++)
		{
			if(table[i] != table[i-1])
			{
				if(table[i-1])
				{
					if(counter > maxYes)
					{
						maxYes = counter;
					}
				}
				else {
					if(counter > maxNo)
					{
						maxNo = counter;
					}
				}
				counter = 1;
				continue;
			}
			else 
			{
				counter++;
			}
		}
		out.println(maxYes + " " + maxNo);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}
