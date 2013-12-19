/*
ID: kuangwe4
LANG: JAVA
TASK: rect1
 */
package usaco;

import java.awt.Point;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

class rect1 {
	static class Rect{
		Point ll;
		Point ur;
		int value;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("rect1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("rect1.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int[] colorCount = new int[2501];
		ArrayList<Rect> list = new ArrayList<Rect>();
		Rect background = new Rect();
		background.ll = new Point(0, 0);
		background.ur = new Point(a, b);
		background.value = 1;
		list.add(background);
		
		for(int i = 0; i < n; i++)
		{
			String[] line = f.readLine().split(" ");
			Point llp = new Point();
			Point urp = new Point();
			llp.x = Integer.parseInt(line[0]);
			llp.y = Integer.parseInt(line[1]);
			urp.x = Integer.parseInt(line[2]);
			urp.y = Integer.parseInt(line[3]);
			int color = Integer.parseInt(line[4]);
			Rect newRect = new Rect();
			newRect.ll = llp;
			newRect.ur = urp;
			newRect.value = color;
			int j = list.size() - 1;
			for(; j >= 0; j--)
			{
				Rect originalRect = list.get(j);
				ArrayList<Rect> newRects = new ArrayList<rect1.Rect>();
				if(!(originalRect.ur.x <= newRect.ll.x ||
				   originalRect.ur.y <= newRect.ll.y ||
				   originalRect.ll.x >= newRect.ur.x ||
				   originalRect.ll.y >= newRect.ur.y))
				{
					list.remove(j);
					
					if(originalRect.ur.x - newRect.ur.x > 0)
					{
						int newurx = originalRect.ur.x;
						int newury = Math.min(originalRect.ur.y, newRect.ur.y);
						int newllx = newRect.ur.x;
						int newlly = Math.max(originalRect.ll.y, newRect.ll.y);
						Rect splitRect = new Rect();
						splitRect.ur = new Point(newurx, newury);
						splitRect.ll = new Point(newllx, newlly);
						splitRect.value = originalRect.value;
						newRects.add(splitRect);
					}
					
					if(newRect.ll.x - originalRect.ll.x > 0)
					{
						int newurx = newRect.ll.x;
						int newury = Math.min(originalRect.ur.y, newRect.ur.y);
						int newllx = originalRect.ll.x;
						int newlly = Math.max(originalRect.ll.y, newRect.ll.y);
						Rect splitRect = new Rect();
						splitRect.ur = new Point(newurx, newury);
						splitRect.ll = new Point(newllx, newlly);
						splitRect.value = originalRect.value;
						newRects.add(splitRect);
					}
					
					if(originalRect.ur.y - newRect.ur.y > 0)
					{
						int newurx = originalRect.ur.x;
						int newury = originalRect.ur.y;
						int newllx = originalRect.ll.x;
						int newlly = newRect.ur.y;
						Rect splitRect = new Rect();
						splitRect.ur = new Point(newurx, newury);
						splitRect.ll = new Point(newllx, newlly);
						splitRect.value = originalRect.value;
						newRects.add(splitRect);
					}
					
					if(newRect.ll.y - originalRect.ll.y > 0)
					{
						int newurx = originalRect.ur.x;
						int newury = newRect.ll.y;
						int newllx = originalRect.ll.x;
						int newlly = originalRect.ll.y;
						Rect splitRect = new Rect();
						splitRect.ur = new Point(newurx, newury);
						splitRect.ll = new Point(newllx, newlly);
						splitRect.value = originalRect.value;
						newRects.add(splitRect);
					}
				}
				list.addAll(j, newRects);
			}
			list.add(newRect);
		}
		
		for (Rect rect : list)
		{
			colorCount[rect.value] += (rect.ur.x - rect.ll.x)*(rect.ur.y - rect.ll.y);
		}
		
		for(int i = 1; i <= 2500; i++)
		{
			if(colorCount[i] != 0)
			{
				out.println(i + " " + colorCount[i]);
			}
		}
		
		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}