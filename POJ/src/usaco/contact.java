/*
ID: kuangwe4
LANG: JAVA
TASK: contact
 */
package usaco;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class contact {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("contact.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("contact.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] counter = new int[10000];
		StringBuilder list = new StringBuilder();
		String line = f.readLine();
		while(line != null)
		{
			list.append(line);
			line = f.readLine();
		}
		
		for(int digit = a; digit <= b; digit++)
		{
			for(int start = 0; start + digit <= list.length(); start++)
			{
				counter[Integer.parseInt("1" + list.substring(start, start + digit), 2)]++;
			}
		}
		
		int[] sorted = counter.clone();
		Arrays.sort(sorted);
		
		for(int i = sorted.length - 1; i >= 0; i--)
		{
			if(sorted[i] == 0)
			{
				break;
			}
			if(n == 0)
			{
				break;
			}
			if(sorted[i] == sorted[i-1])
			{
				continue;
			}
			out.println(sorted[i]);
			ArrayList<Integer> ansList = new ArrayList<Integer>();
			for(int j = 0; j < 10000; j++)
			{
				if(counter[j] == sorted[i])
				{
					ansList.add(j);
				}
			}
			int printCount = 0;
			for(int j = 0; j < ansList.size() - 1; j++)
			{
				if(printCount == 5)
				{
					out.println(Integer.toBinaryString(ansList.get(j)).substring(1));
					printCount = 0;
				}
				else {
					out.print(Integer.toBinaryString(ansList.get(j)).substring(1) + " ");
					printCount++;
				}
			}
			if(ansList.size() != 0)
			{
				out.println(Integer.toBinaryString(ansList.get(ansList.size() - 1)).substring(1));
				out.flush();
			}
			n--;
		}
		
		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}