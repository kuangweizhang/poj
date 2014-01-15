/*
ID: kuangwe4
LANG: JAVA
TASK: kimbits
 */
package usaco;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

class kimbits {
	
	static long N = 0;
	static long L = 0;
	static long I = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("kimbits.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("kimbits.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Long.parseLong(st.nextToken());
		L = Long.parseLong(st.nextToken());
		I = Long.parseLong(st.nextToken());
		
		while(N > 0)
		{
			long k = getNumberOfPossibilities(N - 1, L);
			if(k < I || (N == 1 && I == 2))
			{
				out.print(1);
				I -= k;
				L--;
			}
			else {
				out.print(0);
			}
			N--;
		}
		out.println();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static long getNumberOfPossibilities(long n, long k)
	{
		int ans = 0;
		for(int i = 0; i <= k; i++)
		{
			ans += choose(n, i);
		}
		return ans;
	}
	
	private static long choose(long n, long k)
	{
		return factorial(n).divide(factorial(n - k)).divide(factorial(k)).longValue();
	}
	
	private static BigInteger factorial(long n)
	{
		BigInteger ans = BigInteger.ONE;
		for(int i = 1; i <= n; i++)
		{
			ans = ans.multiply(new BigInteger(Integer.toString(i)));
		}
		return ans;
	}
}