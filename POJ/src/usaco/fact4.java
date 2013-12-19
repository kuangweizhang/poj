/*
ID: kuangwe4
LANG: JAVA
TASK: fact4
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class fact4 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("fact4.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("fact4.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		int[] N = new int[1000];
		N[0] = 1;
		for(int i = 1; i <= n; i++)
		{
			for(int j = 0; j < N.length; j++)
			{
				N[j] *= i;
			}
			
			for(int k = 0; k < N.length - 1; k++)
			{
				N[k + 1] += N[k]/10;
				N[k] = N[k] % 10;
			}
		}
		
		for(int i = 0; i < 900; i++)
		{
			if(N[i] != 0)
			{
				out.println(N[i]);
				break;
			}
		}

		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}