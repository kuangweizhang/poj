/*
ID: kuangwe4
LANG: JAVA
TASK: subset
 */
package usaco;

import java.io.*;

class subset {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("subset.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		long n = Integer.parseInt(f.readLine());
		
		long sum = (1 + n)*n/4;
		if((1 + n)*n/2 % 2 == 1)
		{
			out.println(0);
			out.close();
			System.exit(0);
		}
		long[] counter = new long[(int) (sum + 1)];
		long[] copy;
		counter[0] = 1;
		
		for(long i = 1; i <= n; i++)
		{
			copy = counter.clone();
			for(int j = 0; j < counter.length; j++)
			{
				if(counter[j] != 0 && i + j < counter.length)
				{
					copy[(int) (j + i)] += counter[j]; 
				}
			}
			counter = copy;
		}
		
		out.println(counter[(int) sum] / 2);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}