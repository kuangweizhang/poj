/*
ID: kuangwe4
LANG: JAVA
TASK: inflate
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class inflate {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("inflate.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("inflate.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int t = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] points = new int[n];
		int[] time = new int[n];
		
		for(int i = 0; i < n; i++)
		{
			st = new StringTokenizer(f.readLine());
			points[i] = Integer.parseInt(st.nextToken());
			time[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] max = new int[t + 1];
		
		for(int i = 1; i <= t; i++)
		{
			int maxscore = Integer.MIN_VALUE;
			for(int j = 0; j < n; j++)
			{
				if(i - time[j] >= 0 && max[i - time[j]] + points[j] > maxscore)
				{
					maxscore = max[i - time[j]] + points[j];
				}
			}
			if(i - 1 >= 0 && maxscore < max[i - 1])
			{
				maxscore = max[i - 1];
			}
			max[i] = maxscore;
		}
		
		out.println(max[t]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}