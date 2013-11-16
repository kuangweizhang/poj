/*
ID: kuangwe4
LANG: JAVA
TASK: prefix
 */
package usaco;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class prefix {
	
	public static int ans = -1;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("prefix.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		LinkedList<String> pres = new LinkedList<String>();
		StringBuilder st = new StringBuilder();
		
		String line = f.readLine();
		while(!line.equals("."))
		{
			StringTokenizer stt = new StringTokenizer(line);
			try
			{
			while(true)
			{
				pres.add(stt.nextToken());
			}
			}
			catch(Exception e){}
			
			line = f.readLine();
		}
		
		line = f.readLine();
		while(line != null)
		{
			st.append(line);
			line = f.readLine();
		}
		
		String target = st.toString();
		
		//search(target, pres, -1);
		search2(" " + target, pres);
		
		out.println(ans);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static void search2(String target, LinkedList<String> list)
	{
		boolean[] check = new boolean[target.length()];
		check[0] = true;
		for(int i = 0; i < check.length; i++)
		{
			if(check[i])
			{
				for (String st : list)
				{
					if(target.regionMatches(i + 1, st, 0, st.length()))
					{
						check[i + st.length()] = true;
					}
				}
			}
		}
		
		for(int i = check.length - 1; i >= 0; i--)
		{
			if(check[i])
			{
				ans = i;
				return;
			}
		}
	}
	
	private static void search(String target, LinkedList<String> list, int k)
	{
		if(k >= target.length())
		{
			return;
		}
		if(k > ans)
		{
			ans = k;
		}
		
		for (String string : list)
		{
			if(target.regionMatches(k + 1, string, 0, string.length()))
			{
				search(target, list, k + string.length());
			}
		}
	}
}