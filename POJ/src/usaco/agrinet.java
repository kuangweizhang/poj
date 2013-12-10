/*
ID: kuangwe4
LANG: JAVA
TASK: agrinet
 */
package usaco;

import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

class agrinet {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("agrinet.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("agrinet.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(f.readLine());
		int[][] map = new int[n][n];
		int ic = 0;
		int jc = 0;
		while(true)
		{
			StringTokenizer st = new StringTokenizer(f.readLine());
			while(st.hasMoreTokens())
			{
				map[ic][jc] = Integer.parseInt(st.nextToken());
				jc++;
				if(jc == n)
				{
					jc = 0;
					ic++;
				}
			}
			if(ic == n)
			{
				break;
			}
		}
		
		int[] D = new int[n];
		for(int i = 0; i < n; i++)
		{
			D[i] = Integer.MAX_VALUE;
		}
		D[0] = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		int sum = 0;
		for(int i = 0; i < n; i++)
		{
			int minvalue = Integer.MAX_VALUE;
			int minindex = -1;
			for(int j = 0; j < n; j++)
			{
				if(!visited.contains(j) && D[j] < minvalue)
				{
					minindex = j;
					minvalue = D[j];
				}
			}
			for(int j = 0; j < n; j++)
			{
				if(map[minindex][j] < D[j])
				{
					D[j] = map[minindex][j];
				}
			}
			sum += minvalue;
			visited.add(minindex);
		}
		
		out.println(sum);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}