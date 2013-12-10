/*
ID: kuangwe4
LANG: JAVA
TASK: humble
 */
package usaco;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class humble {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("humble.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("humble.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(f.readLine());
		int[] num = new int[n];
		int[] positionPointer = new int[n];
		for(int i = 0; i < n ; i++)
		{
			num[i] = Integer.parseInt(st.nextToken());
		}
		int[] D = new int[k + 1];
		Arrays.sort(num);
		
		D[0] = 1;
		for (int i = 1; i <= k; i++)
		{
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < n; j++)
			{
				while(D[positionPointer[j]]*num[j] <= D[i - 1])
				{
					positionPointer[j]++;
				}
				if(D[positionPointer[j]]*num[j] < min)
				{
					min = D[positionPointer[j]]*num[j];
				}
			}
			D[i] = min;
		}
		
		out.println(D[k]);

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}