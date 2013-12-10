/*
ID: kuangwe4
LANG: JAVA
TASK: cowtour
 */
package usaco;

import java.io.*;

class cowtour {
	static int[] x;
	static int[] y;
	
	static double dist(int i, int j)
	{
		return Math.sqrt((x[i] - x[j])*(x[i] - x[j]) + 
				(y[i] - y[j])*(y[i] - y[j]));
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("cowtour.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("cowtour.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(f.readLine());
		x = new int[161];
		y = new int[161];
		double[] mmax = new double[161];
		double[][] map = new double[161][161];
		
		for(int i = 1; i <= n; i++)
		{
			String[] line = f.readLine().split(" ");
			x[i] = Integer.parseInt(line[0]);
			y[i] = Integer.parseInt(line[1]);
		}

		for(int i = 1; i <= n; i++)
		{
			String st = f.readLine();
			for(int j = 1; j <= n; j++)
			{
				if(st.charAt(j - 1) == '1')
				{
					map[i][j] = dist(i, j);
				}
				else {
					map[i][j] = Double.MAX_VALUE;
				}
				if(i == j)
				{
					map[i][j] = 0;
				}
			}
		}
		
		for(int k = 1; k <= n; k++)
		{
			for(int i = 1; i <= n; i++)
			{
				for(int j = 1; j <=n; j++)
				{
					if(map[i][k] != Double.MAX_VALUE && map[k][j] != Double.MAX_VALUE && map[i][k] + map[k][j] < map[i][j])
					{
						map[i][j] = map[i][k] + map[k][j];
					}
				}
			}
		}
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(map[i][j] != Double.MAX_VALUE && map[i][j] > mmax[i])
				{
					mmax[i] = map[i][j];
				}
			}
		}
		double result = Double.MAX_VALUE;
		
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= n; j++)
			{
				if(map[i][j] == Double.MAX_VALUE)
				{
					if(dist(i,j) + mmax[i] + mmax[j] < result)
					{
						result = dist(i,j) + mmax[i] + mmax[j];
					}
				}
			}
		}
		
		for(int i = 1; i <= n; i++)
		{
			if(mmax[i] > result)
			{
				result = mmax[i];
			}
		}
		
		out.printf("%.6f",result);
		out.println();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}