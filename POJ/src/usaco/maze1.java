/*
ID: kuangwe4
LANG: JAVA
TASK: maze1
 */
package usaco;

import java.awt.Point;
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class maze1 {

	private static int exit1x = -5;
	private static int exit1y = -5;
	private static int exit2x = -5;
	private static int exit2y = -5;
	private static String[] topo;
	private static int[] dx = {1, -1, 0, 0};
	private static int[] dy = {0, 0, 1, -1};
	private static int W;
	private static int H;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("maze1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("maze1.out")));

		
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		topo = new String[2*H + 1];
		
		for(int i = 0; i < topo.length; i++)
		{
			topo[i] = f.readLine();
		}
		
		for(int i = 1; i <= W; i++)
		{
			if(topo[0].charAt(i * 2 - 1) == ' ')
			{
				assginExit(1, i * 2 - 1);
			}
			if(topo[2 * H].charAt(i * 2 - 1) == ' ')
			{
				assginExit(H * 2 - 1, i * 2 - 1);
			}
		}
		
		for(int i = 1; i <= H; i++)
		{
			if(topo[i * 2 - 1].charAt(0) == ' ')
			{
				assginExit(i * 2 - 1, 1);
			}
			if(topo[i * 2 - 1].charAt(2 * W) == ' ')
			{
				assginExit(i * 2 - 1, 2 * W - 1);
			}
		}
		
		int[][] C1 = new int[H][W];
		int[][] C2 = new int[H][W];
		search(exit1x, exit1y, C1);
		search(exit2x, exit2y, C2);
		
		int maxStep = Integer.MIN_VALUE;
		for(int i = 0; i < H; i++)
		{
			for(int j = 0; j < W; j++)
			{
				int newStep = Math.min(C1[i][j] ,C2[i][j]);
				if(newStep > maxStep)
				{
					maxStep = newStep;
				}
			}
		}
		out.println(maxStep);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static void search(int i, int j, int[][] C)
	{
		LinkedList<Point> queue = new LinkedList<Point>();
		LinkedList<Integer> step = new LinkedList<Integer>();
		Point startPoint = new Point(i, j);
		C[(i - 1)/2][(j - 1)/2] = 1;
		queue.add(startPoint);
		step.add(1);
		
		while(!queue.isEmpty())
		{
			Point thePoint = queue.pollFirst();
			int theStep = step.pollFirst();
			for(int direction = 0; direction <= 3; direction++)
			{
				int newx = thePoint.x + dx[direction];
				int newy = thePoint.y + dy[direction];
				int newcx = thePoint.x + 2*dx[direction];
				int newcy = thePoint.y + 2*dy[direction];
				Point point = new Point(newcx, newcy);
				if(within(newcx, newcy) && topo[newx].charAt(newy) == ' ' && C[(newcx - 1)/2][(newcy - 1)/2] == 0)
				{
					queue.add(point);
					step.add(theStep + 1);
					C[(newcx - 1)/2][(newcy - 1)/2] = theStep + 1;
				}
			}
		}
	}
	
	private static boolean within(int i, int j)
	{
		return (i >= 0 && i < 2 * H + 1 && j >= 0 && j < 2 * W + 1);
	}
	
	private static void assginExit(int x, int y)
	{
		if(exit1x == -5)
		{
			exit1x = x;
			exit1y= y;
		}
		else {
			exit2x = x;
			exit2y = y;
		}
	}
}