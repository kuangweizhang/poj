/*
ID: kuangwe4
LANG: JAVA
TASK: friday
 */
package usaco;

import java.io.*;

class friday {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("friday.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"friday.out")));
// 2 1 1 3 1 2 2 
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(f.readLine());
		int[] counter = new int[7];
		int day = 0;
		for(int year = 1900; year < 1900 + n; year++)
		{
			for(int month = 1; month <= 12; month++)
			{
				if(year == 1900 && month == 1)
				{
					day = 5;
					counter[day]++;
					continue;
				}
				if(month == 2 || month == 4 || month == 6 || month == 8 || month == 9 || month == 11 ||
						month == 1)
				{
					day += 31;
					day %= 7;
					counter[day]++;
					continue;
				}
				if (month == 5 || month == 7 || month == 10 ||month == 12)
				{
					day += 30;
					day %= 7;
					counter[day]++;
					continue;
				}
				if (month == 3)
				{
					if (year % 4 != 0)
					{
						day += 28;
						day %= 7;
						counter[day] ++;
						continue;
					}
					else {
						if (year % 400 != 0 && year % 100 == 0)
						{
							day += 28;
							day %= 7;
							counter[day]++;
							continue;
						}
						else {
							day += 29;
							day %= 7;
							counter[day]++;
							continue;
						}
					}
				}
			}
		}
		out.print(counter[5] + " " + counter[6]);
		for(int i = 0; i < 5; i++)
		{
			out.print(" " + counter[i]);
		}
		out.println();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}