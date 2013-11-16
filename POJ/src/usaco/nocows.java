/*
ID: kuangwe4
LANG: JAVA
TASK: nocows
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class nocows {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("nocows.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[200][200];
		A[1][1] = 1;
		
		for(int i = 3; i <= n; i += 2)
		{
			for(int j = 1; j <= i - 2; j+= 2)
			{
				for(int k1 = 1; k1 <= (j + 1)/2; k1++)
				{
					for(int k2 = 1; k2 <= (i - j)/2; k2++)
					{
						A[i][Math.max(k1, k2) + 1] += A[j][k1] * A[i - j - 1][k2];
						A[i][Math.max(k1, k2) + 1] %= 9901;
					}
				}
			}
		}
		out.println(A[n][k]);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}