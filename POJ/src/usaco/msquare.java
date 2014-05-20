/*
ID: kuangwe4
LANG: JAVA
TASK: msquare
 */
package usaco;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class msquare {
	
	private static HashMap<Integer, String> record;
	private static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("msquare.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("msquare.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());

		for(int i = 0; i < 8; i++)
		{
			N = N * 10 + Integer.parseInt(st.nextToken());
		}
		if(N == 12345678)
		{
			Finish(f, out, "");
		}
		record = new HashMap<Integer, String>();
		
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(12345678);
		record.put(12345678, "");
		
		while (!queue.isEmpty())
		{
			int current = queue.pollFirst();
			String currentStep = record.get(current);
			
			int a = Achange(current);
			if(!record.containsKey(a))
			{
				if(a == N)
				{
					Finish(f, out, currentStep + "A");
				}
				queue.add(a);
				record.put(a, currentStep + "A");
			}
			
			int b = Bchange(current);
			if(!record.containsKey(b))
			{
				if(b == N)
				{
					Finish(f, out, currentStep + "B");
				}
				queue.add(b);
				record.put(b, currentStep + "B");
			}
			
			int c = Cchange(current);
			if(!record.containsKey(c))
			{
				if(c == N)
				{
					Finish(f, out, currentStep + "C");
				}
				queue.add(c);
				record.put(c, currentStep + "C");
			}
		}
		
		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static void Finish(BufferedReader f, PrintWriter out, String printout) throws IOException
	{
		out.println(printout.length());
		while(printout.length() > 60)
		{
			out.println(printout.substring(0, 59));
			printout = printout.substring(60);
		}
		out.println(printout);
		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static int Achange(int k)
	{
		StringBuilder stringBuilder = new StringBuilder(Integer.toString(k));
		return Integer.parseInt(stringBuilder.reverse().toString());
	}
	
	private static int Bchange(int k)
	{
		String kString = Integer.toString(k);
		String newString = kString.charAt(3) 
				+ kString.substring(0, 3) 
				+ kString.substring(5) 
				+ kString.charAt(4);
		return Integer.parseInt(newString);
	}
	
	private static int Cchange(int k)
	{
		String kString = Integer.toString(k);
		StringBuilder newString = new StringBuilder();
		newString.append(kString.charAt(0));
		newString.append(kString.charAt(6));
		newString.append(kString.charAt(1));
		newString.append(kString.charAt(3));
		newString.append(kString.charAt(4));
		newString.append(kString.charAt(2));
		newString.append(kString.charAt(5));
		newString.append(kString.charAt(7));
		return Integer.parseInt(newString.toString());
	}
}