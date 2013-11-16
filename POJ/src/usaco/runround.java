/*
ID: kuangwe4
LANG: JAVA
TASK: runround
 */
package usaco;

import java.io.*;
import java.util.HashSet;

class runround {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("runround.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		long M = Long.parseLong(f.readLine()) + 1;

		while(!isRound(M))
		{
			M++;
		}
		out.println(M);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static boolean isRound(long current)
	{
		String st = current + "";
		HashSet<Character> set = new HashSet<Character>();
		for(int i = st.length() - 1; i >= 0; i--)
		{
			if(st.charAt(i) == '0')
			{
				return false;
			}
			if(set.contains(st.charAt(i)))
			{
				return false;
			}
			set.add(st.charAt(i));
		}
		int pointer = 0;
		for(int i = 0; i < st.length(); i++)
		{
			if(!set.contains(st.charAt(pointer)))
			{
				return false;
			}
			set.remove(st.charAt(pointer));
			int step = Integer.parseInt(st.charAt(pointer) + "");
			while(step != 0)
			{
				pointer++;
				if(pointer == st.length())
				{
					pointer = 0;
				}
				step--;
			}
		}
		if(pointer == 0)
		{
			return true;
		}
		else {
			return false;
		}
	}
}