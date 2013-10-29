/*
ID: kuangwe4
LANG: JAVA
TASK: numtri
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class numtri {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;

		int n = Integer.parseInt(f.readLine());
		int[][] tri = new int[n+1][n+1];
		for(int i = 1; i <= n; i++)
		{
			st = new StringTokenizer(f.readLine());
			for(int j = 1; j <= i; j++)
			{
				tri[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int line = n - 1; line >= 1; line--)
		{
			for(int col = 1; col <= line; col++)
			{
				tri[line][col] += max(tri[line + 1][col], tri[line + 1][col + 1]);
			}
		}
		out.println(tri[1][1]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	static int max(int a, int b)
	{
		if(a>b)
		{
			return a;
		}
		else {
			return b;
		}
	}
}

