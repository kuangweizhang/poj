/*
ID: kuangwe4
LANG: JAVA
TASK: ratios
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class ratios {
	public static int ansm = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ratios.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ratios.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int[] goal = new int[3];
		for(int i = 0; i <= 2; i++)
		{
			goal[i] = Integer.parseInt(st.nextToken());
		}
		int[][] element = new int[3][3];
		
		for(int i = 0; i <= 2; i++)
		{
			st = new StringTokenizer(f.readLine());
			for(int j = 0; j <= 2; j++)
			{
				element[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int ansi = 0;
		int ansj = 0;
		int ansk = 0;
		int minSum = Integer.MAX_VALUE;
		for(int i = 0; i <= 100; i++)
		{
			for(int j = 0; j <= 100; j++)
			{
				for(int k = 0; k <= 100; k++)
				{
					int part0 = element[0][0] * i +
								element[1][0] * j +
								element[2][0] * k;
					
					int part1 = element[0][1] * i +
								element[1][1] * j +
								element[2][1] * k;
					
					int part2 = element[0][2] * i +
								element[1][2] * j +
								element[2][2] * k;
					int ratio = ratioSame(part0, goal[0], part1, goal[1], part2, goal[2]);
					if(
							ratio != -1 &&
							i + j + k < minSum &&
							i + j + k != 0)
					{
						minSum = i + j + k;
						ansi = i;
						ansj = j;
						ansk = k;
						ansm = ratio;
					}
				}
			}
		}
		
		
		if(ansi == 0 && ansj == 0 && ansk == 0)
		{
			out.println("NONE");
		}
		else {
			out.println(ansi + " " + ansj + " " + ansk + " " + ansm);
		}
		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static int ratioSame(int p0, int g0, int p1, int g1, int p2, int g2)
	{
		int retval = 0;
		if(
				(g0 == 0 && p0 != 0)||
				(g1 == 0 && p1 != 0)||
				(g2 == 0 && p2 != 0)||
				(p0 == 0 && g0 != 0)||
				(p1 == 0 && g1 != 0)||
				(p2 == 0 && g2 != 0)
				)
		{
			return -1;
		}
		int r0 = 0;
		int r1 = 0;
		int r2 = 0;
		if(!(p0 == 0 && g0 == 0))
		{
			if(p0 % g0 != 0)
			{
				return -1;
			}
			r0 = p0/g0;
			if(r0 != 0)
			{
				retval = r0;
			}
		}
		if(!(p1 == 0 && g1 == 0))
		{
			if(p1 % g1 != 0)
			{
				return -1;
			}
			r1 = p1/g1;
			if(r1 != 0)
			{
				retval = r1;
			}
		}
		if(!(p2 == 0 && g2 == 0))
		{
			if(p2 % g2 != 0)
			{
				return -1;
			}
			r2 = p2/g2;
			if(r2 != 0)
			{
				retval = r2;
			}
		}
		if(r0 != 0 && r1 != 0 && r0 != r1)
		{
			return -1;
		}
		if(r1 != 0 && r2 != 0 && r1 != r2)
		{
			return -1;
		}
		if(r0 != 0 && r2 != 0 && r0 != r2)
		{
			return -1;
		}
		return retval;
	}
}