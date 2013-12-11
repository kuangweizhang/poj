/*
ID: kuangwe4
LANG: JAVA
TASK: stamps
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class stamps {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("stamps.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("stamps.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int k = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] stamps = new int[n];
		int counter = 0;
		int maxstamp = 0;
		while(true)
		{
			st = new StringTokenizer(f.readLine());
			while(st.hasMoreTokens())
			{
				stamps[counter] = Integer.parseInt(st.nextToken());
				if(stamps[counter] > maxstamp)
				{
					maxstamp = stamps[counter];
				}
				counter++;
			}
			if(counter == n)
			{
				break;
			}
		}
		
		
		int[] D = new int[maxstamp * k + 1];
		for(int i = 0; i < D.length; i++)
		{
			D[i] = Integer.MAX_VALUE;
		}
		int i = 0;
		D[0] = 0;
		for(; i < D.length; i++)
		{
			if(D[i] == Integer.MAX_VALUE)
			{
				break;
			}
			if(D[i] < k)
			{
				for(int j = 0; j < n; j++)
				{
					if(i + stamps[j] < D.length && D[i + stamps[j]] > D[i] + 1)
					{
						D[i + stamps[j]] = D[i] + 1;
					}
				}
			}
		}
		
		out.println(i - 1);
		
		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}