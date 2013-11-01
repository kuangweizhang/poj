/*
ID: kuangwe4
LANG: JAVA
TASK: sort3
 */
package usaco;

import java.io.*;

class sort3 {
	static int count1 = 0;
	static int count2 = 0;
	static int count3 = 0;
	static int[] array;
	static int n ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		n = Integer.parseInt(f.readLine());
		array = new int[n + 1];
		
		
		for(int i = 1; i <= n; i++)
		{
			array[i] = Integer.parseInt(f.readLine());
			if(array[i] == 1)
			{
				count1 ++;
			}
			else {
				if(array[i] == 2)
				{
					count2++;
				}
				else {
					count3++;
				}
			}
		}
		int counter12 = 0;
		int counter13 = 0;
		int counter21 = 0;
		int counter23 = 0;
		int counter31 = 0;
		int counter32 = 0;
		
		for(int i = 1; i <= n; i++)
		{
			if(i <= count1)
			{
				if(array[i] == 2)
				{
					counter21++;
				}
				if(array[i] == 3)
				{
					counter31++;
				}
			}
			else {
				if(i <= count1 + count2)
				{
					if(array[i] == 1)
					{
						counter12++;
					}
					if(array[i] == 3)
					{
						counter32++;
					}
				}
				else {
					if(array[i] == 1)
					{
						counter13++;
					}
					if(array[i] == 2)
					{
						counter23++;
					}
				}
			}
		}
		
		int change = 0;
		if(counter12 > counter21)
		{
			change += counter21;
			counter12 -= counter21;
			counter21 = 0;
		}
		else {
			change += counter12;
			counter21 -= counter12;
			counter12 = 0;
		}
		
		if(counter13 > counter31)
		{
			change += counter31;
			counter13 -= counter31;
			counter31 = 0;
		}
		else {
			change += counter13;
			counter31 -= counter13;
			counter13 = 0;
		}
		
		if(counter32 > counter23)
		{
			change += counter23;
			counter32 -= counter23;
			counter23 = 0;
		}
		else {
			change += counter32;
			counter23 -= counter32;
			counter32 = 0;
		}
		
		change += (2*counter12 + 2*counter13);
		
		out.println(change);

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}