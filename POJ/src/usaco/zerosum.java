/*
ID: kuangwe4
LANG: JAVA
TASK: zerosum
 */
package usaco;

import java.io.*;
import java.util.LinkedList;

class zerosum {
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("zerosum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("zerosum.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(f.readLine());
		LinkedList<Integer> algo = new LinkedList<Integer>();
		
		Search(n, algo, out);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static void Search(int n, LinkedList<Integer> path, PrintWriter out)
	{
		if(n == 1)
		{
			if(eval(path))
			{
				print(out, path);
			}
		}
		else {
			for(int i = 1; i <= 3; i++)
			{
				path.add(i);
				Search(n - 1, path, out);
				path.removeLast();
			}
		}
	}
	
	private static boolean eval(LinkedList<Integer> path)
	{
		LinkedList<Integer> nums = new LinkedList<Integer>();
		nums.add(1);
		int counter = 1;
		for (Integer op : path)
		{
			counter++;
			if(op == 1)
			{
				int k = nums.removeLast() * 10 + counter;
				nums.addLast(k);
			}
			else {
				nums.add(counter);
			}
		}
		
		int sum = nums.removeFirst();
		for(Integer op : path)
		{
			if(op == 2)
			{
				sum += nums.removeFirst();
			}
			if(op == 3)
			{
				sum -= nums.removeFirst();
			}
		}
		return sum == 0;
	}
	
	private static void print(PrintWriter out, LinkedList<Integer> path)
	{
		out.print(1);
		int counter = 1;
		for (Integer integer : path)
		{
			counter++;
			if(integer == 1)
			{
				out.print(" " + counter);
			}
			if(integer == 2)
			{
				out.print("+" + counter);
			}
			if(integer == 3)
			{
				out.print("-" + counter);
			}
		}
		out.println();
	}
}