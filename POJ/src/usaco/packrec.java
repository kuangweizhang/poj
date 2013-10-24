/*
ID: kuangwe4
LANG: JAVA
TASK: packrec
 */
package usaco;

import java.awt.Point;
import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

class packrec {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("packrec.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("packrec.out")));
		
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;

		Point[][] rects = new Point[4][2];
		
		for(int i = 0; i < 4; i++)
		{
			st = new StringTokenizer(f.readLine());
			rects[i][0] = new Point();
			rects[i][0].x = Integer.parseInt(st.nextToken());
			rects[i][0].y = Integer.parseInt(st.nextToken());
			rects[i][1] = new Point();
			rects[i][1].x = rects[i][0].y;
			rects[i][1].y = rects[i][0].x;
		}
		
		HashMap<Integer, Integer> results = new HashMap<Integer, Integer>();
		int minarea = Integer.MAX_VALUE;
		
		for(int i = 0; i <=1; i++)
		{
			for(int j = 0; j <=1; j++)
			{
				for(int k = 0; k <=1; k++)
				{
					for(int l = 0; l <=1; l++)
					{
						Point[] resultarray = new Point[5];
						resultarray[0] = pack1(rects[0][i],rects[1][j],rects[2][k],rects[3][l]);
						resultarray[1] = pack2(rects[0][i],rects[1][j],rects[2][k],rects[3][l]);
						resultarray[2] = pack3(rects[0][i],rects[1][j],rects[2][k],rects[3][l]);
						resultarray[3] = pack4(rects[0][i],rects[1][j],rects[2][k],rects[3][l]);
						resultarray[4] = pack6(rects[0][i],rects[1][j],rects[2][k],rects[3][l]);
						//out.println("new group");
						for (Point point : resultarray) {
							//out.println(point.x + " " + point.y);
							int inter;
							if (point.y < point.x)
							{
								inter = point.y;
								point.y = point.x;
								point.x = inter;
							}
							if(point.x * point.y < minarea)
							{
								minarea = point.x * point.y;
								results.clear();
								results.put(point.x, point.y);
							}
							if(point.x * point.y == minarea)
							{
								results.put(point.x, point.y);
							}
						}
					}
				}
			}
		}

		out.println(minarea);
		List<Integer> keys = new LinkedList<Integer>(results.keySet());
        Collections.sort(keys);
        for (Integer integer : keys) {
			out.println(integer + " " + results.get(integer));
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static Point pack1(Point a,Point b,Point c,Point d)
	{
		Point[] points = new Point[4];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		points[3] = d;
		Point retval = new Point();
		
		retval.x = 0;
		retval.y = Integer.MIN_VALUE;
		for(int i = 0; i <= 3; i++)
		{
			retval.x += points[i].x;
			if(points[i].y > retval.y)
			{
				retval.y = points[i].y;
			}
		}
		
		return retval;
	}
	
	public static Point pack2(Point a,Point b,Point c,Point d)
	{
		Point[] points = new Point[4];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		points[3] = d;
		Point retval = new Point();
		retval.x = 1000;
		retval.y = 1000;
		
		for(int bottom = 0; bottom <= 3; bottom++)
		{
			Point subret = new Point();
			subret.x = 0;
			subret.y = Integer.MIN_VALUE;
			for(int i = 0; i <= 3; i++)
			{
				if(i != bottom)
				{
					subret.x += points[i].x;
					if(points[i].y > subret.y)
					{
						subret.y = points[i].y;
					}
				}
			}
			subret.y += points[bottom].y;
			if(subret.x < points[bottom].x)
			{
				subret.x = points[bottom].x;
			}
			
			if(subret.x * subret.y < retval.x * retval.y)
			{
				retval = subret;
			}
		}
		
		return retval;
		
	}
	
	public static Point pack6(Point a,Point b,Point c,Point d)
	{
		Point[] points = new Point[4];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		points[3] = d;
		Point retval = new Point();
		retval.x = 1000;
		retval.y = 1000;
		
		for(int rowfriend = 1; rowfriend <= 3; rowfriend++)
		{
			for(int colfriend = 1; colfriend <= 3; colfriend++)
			{
				if(rowfriend != colfriend)
				{
					for(int dia = 1; dia <= 3; dia++)
					{
						if(dia != rowfriend && dia != colfriend)
						{
							int width1 = points[0].x + points[rowfriend].x;
							int width2 = points[colfriend].x + points[dia].x;
							if(width1 < width2)
							{
								width1 = width2;
							}
							int length1 = points[0].y + points[colfriend].y;
							int length2 = points[rowfriend].y + points[dia].y;
							if(length1 < length2)
							{
								length1 = length2;
							}
							if(points[0].y + points[dia].y > length1)
							{
								if(width1 < points[0].x + points[dia].x)
								{
									width1 = points[0].x + points[dia].x;
								}
							}
							if(points[0].x + points[dia].x > width1)
							{
								if(length1 < points[0].y + points[dia].y)
								{
									length1 = points[0].y + points[dia].y;
								}
							}
							
							if(points[colfriend].y + points[rowfriend].y > length1)
							{
								if(width1 < points[colfriend].x + points[rowfriend].x)
								{
									width1 = points[colfriend].x + points[rowfriend].x;
								}
							}
							if(points[colfriend].x + points[rowfriend].x > width1)
							{
								if(length1 < points[colfriend].y + points[rowfriend].y)
								{
									length1 = points[colfriend].y + points[rowfriend].y;
								}
							}
							if(width1 * length1 < retval.x * retval.y)
							{
								retval.x = width1;
								retval.y = length1;
							}
						}
					}
				}
			}
		}
		
		return retval;
		
	}
	
//	public static Point pack5(Point a,Point b,Point c,Point d)
//	{
//		Point[] points = new Point[4];
//		points[0] = a;
//		points[1] = b;
//		points[2] = c;
//		points[3] = d;
//		Point retval = new Point();
//		
//		for(int )
//		return retval;
//		
//	}
	
	public static Point pack4(Point a,Point b,Point c,Point d)
	{
		Point[] points = new Point[4];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		points[3] = d;
		Point retval = new Point();
		retval.x = 1000;
		retval.y = 1000;
		for(int left = 0; left <= 3; left++)
		{
			for(int right = 0; right <= 3; right++)
			{
				if(left != right)
				{
					Point subret = new Point();
					subret.y = 0;
					subret.x = Integer.MIN_VALUE;
					for(int i = 0; i <=3; i++)
					{
						if(i != right && i != left)
						{
							subret.y += points[i].y;
							if(subret.x < points[i].x)
							{
								subret.x = points[i].x;
							}
						}
					}
					subret.x += points[left].x + points[right].x;
					if(subret.y < points[right].y)
					{
						subret.y = points[right].y;
					}
					if(subret.y < points[left].y)
					{
						subret.y = points[left].y;
					}
					if(subret.x * subret.y < retval.x * retval.y)
					{
						retval = subret;
					}
				}
			}
		}
		
		return retval;
	}
	
	public static Point pack3(Point a,Point b,Point c,Point d)
	{
		Point[] points = new Point[4];
		points[0] = a;
		points[1] = b;
		points[2] = c;
		points[3] = d;
		Point retval = new Point();
		retval.x = 1000;
		retval.y = 1000;
		for(int right = 0; right <= 3; right++)
		{
			for(int bottom = 0; bottom <= 3; bottom++)
			{
				if(right != bottom){
					Point subret = new Point();
					subret.x = 0;
					subret.y = Integer.MIN_VALUE;
					for(int i = 0; i <= 3; i++)
					{
						if(i != right && i != bottom)
						{
							subret.x += points[i].x;
							if(subret.y < points[i].y)
							{
								subret.y = points[i].y;
							}
						}
					}
					subret.y += points[bottom].y;
					if(subret.y < points[right].y)
					{
						subret.y = points[right].y;
					}
					if(subret.x < points[bottom].x)
					{
						subret.x = points[bottom].x;
					}
					subret.x += points[right].x;
					if(subret.x * subret.y < retval.x * retval.y)
					{
						retval = subret;
					}
				}
			}
		}
		return retval;
	}
}