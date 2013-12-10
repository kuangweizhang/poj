/*
ID: kuangwe4
LANG: JAVA
TASK: comehome
 */
package usaco;

import java.io.*;
import java.util.HashSet;

class comehome {
	
	static int[][] T = new int[52][52];
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("comehome.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("comehome.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		for(int i = 0; i < 52; i++)
		{
			for(int j = 0; j < 52; j++)
			{
				if(i == j)
				{
					T[i][j] = 0;
				}
				else {
					T[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		int n = Integer.parseInt(f.readLine());
		for(int i = 1; i <= n; i++)
		{
			String[] line = f.readLine().split(" ");
			int index1 = getIndex(line[0].charAt(0));
			int index2 = getIndex(line[1].charAt(0));
			int d = Integer.parseInt(line[2]);
			if(T[index1][index2] > d)
			{
				T[index1][index2] = d;
				T[index2][index1] = d;
			}
		}
		
		int[] D = new int[52];
		for(int i = 0; i < 52; i++)
		{
			D[i] = Integer.MAX_VALUE;
		}
		D[51] = 0;
		HashSet<Integer> visited = new HashSet<Integer>();
		for(int i = 1; i < 52; i++)
		{
			int minIndex = -1;
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < 52; j++)
			{
				if(D[j] < min && !visited.contains(j))
				{
					min = D[j];
					minIndex = j;
				}
			}
			if(minIndex == -1)
			{
				break;
			}
			for(int k = 0; k < 52; k++)
			{
				if(T[minIndex][k] != Integer.MAX_VALUE && T[minIndex][k] + D[minIndex] < D[k])
				{
					D[k] = T[minIndex][k] + D[minIndex];
				}
			}
			visited.add(minIndex);
		}
		
		int ans = -1;
		int minCounter = Integer.MAX_VALUE;
		for(int i = 26; i < 51; i++)
		{
			if(D[i] < minCounter)
			{
				minCounter = D[i];
				ans = i;
			}
		}
		
		out.println((char)(ans - 26 + 65) + " " + minCounter);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	static int getIndex(char ch)
	{
		if(ch >= 'a' && ch <= 'z')
		{
			return (int)ch - 97;
		}
		else {
			return (int) ch - 65 + 26;
		}
	}
}