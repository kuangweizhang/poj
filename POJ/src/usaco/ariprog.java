/*
ID: kuangwe4
LANG: JAVA
TASK: ariprog
 */
package usaco;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.TreeMap;

class ariprog {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));

		TreeMap<Long, Point> ans = new TreeMap<Long, Point>();

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		int lengthOfProg = Integer.parseInt(f.readLine());
		int maxpq = Integer.parseInt(f.readLine());
		boolean[] bisquare = new boolean[125001];
		for(int i = 0; i <= maxpq; i++)
		{
			for(int j = 0; j <= maxpq; j++)
			{
				//System.out.println(i + " " + j + " " + (i*i+j*j));
				bisquare[i*i+j*j] = true;
			}
		}
		int maxbisquare = 2*maxpq*maxpq;

		LinkedList<Integer> bisquarelist = new LinkedList<Integer>();
		for(int i = 0; i <= maxbisquare; i++)
		{
			if(bisquare[i])
			{
				bisquarelist.add(i);
			}
		}
		
		for (Integer start : bisquarelist)
		{
			for(int diff = 1; diff <= (maxbisquare - start)/(lengthOfProg - 1); diff++)
			{
				boolean found = true;
				for(int term = 1; term < lengthOfProg; term ++)
				{
					if(!bisquare[start + diff * term])
					{
						found = false;
						break;
					}
				}
				if(found)
				{
					ans.put((long) (diff * 125001 + start), new Point(start, diff));
				}
			}
		}
		
		for(long key : ans.keySet())
		{
			out.println(ans.get(key).x + " " + ans.get(key).y);
		}
		if(ans.size() == 0)
		{
			out.println("NONE");
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}