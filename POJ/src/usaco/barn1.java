/*
ID: kuangwe4
LANG: JAVA
TASK: barn1
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class barn1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());

		int m = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		boolean[] barn = new boolean[s + 1];
		for(int i = 1; i <= c; i++)
		{
			st = new StringTokenizer(f.readLine());
			int index = Integer.parseInt(st.nextToken());
			barn[index] = true;
		}
		
		int boardcounter = Integer.MAX_VALUE;
		
		while(true)
		{
			boardcounter = 1;
			int beginIndex = 1;
			int endIndex = barn.length - 1;
			while(!barn[beginIndex])
			{
				beginIndex++;
			}
			while(!barn[endIndex])
			{
				endIndex--;
			}
			
			int minstart = beginIndex;
			int minend = endIndex;
			int startp = 0;
			int endp = 0;
			for(int i = beginIndex; i <= endIndex; i++)
			{
				if(startp == 0)
				{
					if(barn[i])
					{
						continue;
					}
					else {
						startp = i;
					}
				}
				else {
					if(barn[i])
					{
						boardcounter++;
						endp = i - 1;
						if (minend - minstart > endp - startp)
						{
							minend = endp;
							minstart = startp;
						}
						startp = 0;
						endp = 0;
					}
					else {
						continue;
					}
				}
			}
			if(boardcounter <= m)
			{
				break;
			}
			for(int i = minstart; i <= minend; i++)
			{
				barn[i] = true;
			}
		}
		
		int finalCounter = 0;
		for(int i = 1; i < barn.length; i++)
		{
			if(barn[i])
			{
				finalCounter++;
			}
		}
		out.println(finalCounter);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}