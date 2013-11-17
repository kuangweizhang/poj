/*
ID: kuangwe4
LANG: JAVA
TASK: concom
 */
package usaco;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class concom {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("concom.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("concom.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);

		int n = 100;
		int nk = Integer.parseInt(f.readLine());
		
		int[][] A = new int[n + 1][n + 1];
		
		for(int i = 1; i <= nk; i++)
		{
			StringTokenizer st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			A[a][b] = c;
		}
		
		for(int i = 1; i <= n; i++)
		{
			A[i][i] = 100;
			boolean found = true;
			HashSet<Integer> control = new HashSet<Integer>();
			control.add(i);
			int[] Ratio = new int[n + 1];
			Ratio = A[i].clone();
			while (found)
			{
				found = false;
				for (int j = 1; j <= n; j++)
				{
					if (Ratio[j] > 50 && !control.contains(j))
					{
						found = true;
						control.add(j);
						for (int k = 1; k <= n; k++)
						{
							Ratio[k] += A[j][k];
						}
						break;
					}
				}
			}
			for(int j = 1; j <= n; j++)
			{
				if(control.contains(j) && i != j)
				{
					out.println(i + " " + j);
				}
			}
		}

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}