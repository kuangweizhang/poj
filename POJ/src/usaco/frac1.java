/*
ID: kuangwe4
LANG: JAVA
TASK: frac1
 */
package usaco;

import java.awt.Point;
import java.io.*;
import java.util.HashSet;
import java.util.TreeMap;

class frac1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(f.readLine());
		HashSet<Point> fractrions = new HashSet<Point>();
		for(int i = 1; i <= n; i++)
		{
			for(int j = 0; j <= i; j++)
			{
				int gcd = GCD(i, j);
				int numerator = j / gcd;
				int deno = i / gcd;
				fractrions.add(new Point(numerator, deno));
			}
		}
		
		TreeMap<Double, Point> sorted = new TreeMap<Double, Point>();
		for (Point point : fractrions)
		{
			sorted.put(point.x/(double)point.y, point);
		}
		
		for (double key : sorted.keySet())
		{
			out.println(sorted.get(key).x + "/" + sorted.get(key).y);
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static int GCD(int a, int b) { return b==0 ? a : GCD(b, a%b); }
}