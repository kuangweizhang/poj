/*
ID: kuangwe4
LANG: JAVA
TASK: beads
 */
package usaco;

import java.io.*;

class beads {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("beads.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"beads.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(f.readLine());
		String beadsString = f.readLine();
		
		char[] beads = new char[beadsString.length()*2];
		
		for(int i = 0; i < beadsString.length(); i ++)
		{
			beads[i] = beadsString.charAt(i);
		}
		
		for(int i = beadsString.length(); i < beads.length; i ++)
		{
			beads[i] = beadsString.charAt(i - beadsString.length());
		}
		
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < beadsString.length(); i++)
		{
			char left = beads[i];
			char right = beads[i + 1];
			int leftindex = i;
			int rightindex = i + 1;
			while(left == 'w' && leftindex >= 0)
			{
				left = beads[leftindex];
				leftindex--;
			}
			leftindex = i;
			while(right == 'w' && rightindex < beads.length)
			{
				right = beads[rightindex];
				rightindex++;
			}
			rightindex = i + 1;
			
			while(leftindex >= 0)
			{
				if (beads[leftindex] != left && beads[leftindex] != 'w')
				{
					break;
				}
				leftindex--;
			}
			
			while(rightindex <=leftindex + n && rightindex < beads.length)
			{
				if(beads[rightindex] != right && beads[rightindex] != 'w')
				{
					break;
				}
				rightindex++;
			}
			if (max < rightindex - leftindex - 1)
			{
				max = rightindex - leftindex - 1;
			}
		}
		
		out.println(max);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}