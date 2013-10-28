/*
ID: kuangwe4
LANG: JAVA
TASK: clocks
 */
package usaco;

import java.io.*;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Stage {
	public int[] clocks = new int[10];
	public int[] changeCounter = new int[10];
}

class clocks {
	
	public static TreeMap<BigInteger, String> results = new TreeMap<BigInteger, String>();
	
	public static void main(String[] args) throws IOException {
		 BufferedReader f = new BufferedReader(new FileReader("clocks.in"));
		 PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("clocks.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st;

		int[] clocks = new int[10];
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(f.readLine());
			for (int j = 0; j < 3; j++) {
				clocks[i * 3 + j + 1] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] changes = { {}, { 1, 2, 4, 5 }, { 1, 2, 3 }, { 2, 3, 5, 6 },
				{ 1, 4, 7 }, { 2, 4, 5, 6, 8 }, { 3, 6, 9 }, { 4, 5, 7, 8 },
				{ 7, 8, 9 }, { 5, 6, 8, 9 }, };
		
		for(int c1 = 0; c1 <= 3; c1++)
		{
			for(int c2 = 0; c2 <= 3; c2++)
			{
				for(int c3 = 0; c3 <= 3; c3++)
				{
					for(int c4 = 0; c4 <= 3; c4++)
					{
						for(int c5 = 0; c5 <= 3; c5++)
						{
							for(int c6 = 0; c6 <= 3; c6++)
							{
								for(int c7 = 0; c7 <= 3; c7++)
								{
									for(int c8 = 0; c8 <= 3; c8++)
									{
										for(int c9 = 0; c9 <= 3; c9++)
										{
											Stage newstage = new Stage();
											newstage.changeCounter = new int[10];
											newstage.changeCounter[1] = c1;
											newstage.changeCounter[2] = c2;
											newstage.changeCounter[3] = c3;
											newstage.changeCounter[4] = c4;
											newstage.changeCounter[5] = c5;
											newstage.changeCounter[6] = c6;
											newstage.changeCounter[7] = c7;
											newstage.changeCounter[8] = c8;
											newstage.changeCounter[9] = c9;
											newstage.clocks = clocks.clone();
											for(int i = 1; i <= 9; i++)
											{
												for(int k = 1; k <= newstage.changeCounter[i]; k++)
												for(int j = 0; j < changes[i].length; j++)
												{
													newstage.clocks[changes[i][j]] += 3;
													if(newstage.clocks[changes[i][j]] > 12)
													{
														newstage.clocks[changes[i][j]] -= 12;
													}
												}
											}
											check(newstage);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		out.println(results.firstEntry().getValue());
		out.close();
		System.exit(0);
	}

	public static void check(Stage currentStage) {
		boolean found = true;
		for (int i = 1; i <= 9; i++) {
			if (currentStage.clocks[i] != 12) {
				return;
			}
		}
		if(found)
		{
			StringBuilder value = new StringBuilder();
			BigInteger key = BigInteger.ZERO;
			for(int i = 1; i <= 9; i++)
			{
				for(int j = 1; j <= currentStage.changeCounter[i]; j++)
				{
					value.append(i + " ");
					key = key.multiply(BigInteger.TEN).add(new BigInteger(i + ""));
				}
			}
			results.put(key, value.substring(0, value.length() - 1));
		}
	}
}