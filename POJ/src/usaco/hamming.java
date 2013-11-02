/*
ID: kuangwe4
LANG: JAVA
TASK: hamming
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class hamming {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());

		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int max = (int) Math.pow(2, b);
		int[] ans = new int[n];
		ans[0] = 0;
		int anscount = 1;
		
		for(int i = 1; i < max; i++)
		{
			if(anscount == n)
			{
				break;
			}
			boolean found = true;
			for (int j = 0; j <= anscount - 1; j++)
			{
				if (hammingd(i, ans[j]) < d)
				{
					found = false;
					break;
				}
			}
			if(found)
			{
				ans[anscount] = i;
				anscount++;
			}
		}
		
		int outputCounter = 0;
		for(int i = 0; i < n - 1; i++)
		{
			if(outputCounter == 9)
			{
				outputCounter = 0;
				out.println(ans[i]);
				continue;
			}
			out.print(ans[i] + " ");
			outputCounter++;
		}
		out.println(ans[n - 1]);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	static int hammingd(int a, int b)
	{
		int counter = 0;
		int c = a^b;
		
		while (c != 0)
		{
			if(c%2 == 1)
			{
				counter++;
			}
			c /=2 ;
		}
		return counter;
	}
}