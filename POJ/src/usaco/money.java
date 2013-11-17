/*
ID: kuangwe4
LANG: JAVA
TASK: money
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class money {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("money.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("money.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int V = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] W = new int[V + 1];
		
		st = new StringTokenizer(f.readLine());
		for(int i = 1; i <= V; i++)
		{
			if(!st.hasMoreTokens())
			{
				st = new StringTokenizer(f.readLine());
			}
			W[i] = Integer.parseInt(st.nextToken());
			
		}
		
		long[][] dp = new long[V + 1][N + 1];
		
		for(int i = 0; i <= V; i++)
		{
			dp[i][0] = 1;
		}
//		dp[0][0] = 1;
		
		for(int i = 1; i <= V; i++)
		{
			for(int j = 1; j <= N; j++)
			{
				for(int k = 0; j-k*W[i] >= 0; k++)
				{
					dp[i][j] += dp[i - 1][j - k*W[i]];
				}
			}
		}
		
		out.println(dp[V][N]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}