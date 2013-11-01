/*
ID: kuangwe4
LANG: JAVA
TASK: checker
 */
package usaco;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

import javax.naming.directory.SearchControls;

class checker {
	
	static int[] board;
	static int size;
	static LinkedList<int[]> ans = new LinkedList<int[]>();
	static int ansCounter = 0;
	static PrintWriter out ;
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("checker.in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter("checker.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		out = new PrintWriter(System.out);
		size = Short.parseShort(f.readLine());
		
		board = new int[size];
		search(board, 0, 0, 0, 0);
		
		
		out.println(ansCounter);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}

	public static void search(int[] board, int depth, int dia1, int dia2, int col)
	{
		if(depth == size)
		{
			if(board[0] == (size/2 + 1))
			{
				ansCounter++;
			}
			else {
				ansCounter += 2;
			}
			
			if(size == 6)
			{
				for (int j = 0; j < size - 1; j++)
				{
					out.print(board[j] + " ");
				}
				out.println(board[size - 1]);
				if(ansCounter == 4)
				{
					for (int j = size - 1; j > 0; j--)
					{
						out.print(board[j] + " ");
					}
					out.println(board[0]);
				}
			}
			else {
				if (ansCounter <= 6)
				{
					for (int j = 0; j < size - 1; j++)
					{
						out.print(board[j] + " ");
					}
					out.println(board[size - 1]);
				}
			}
		}
		else {
			int limit = size;
			if (depth == 0)
			{
				limit = (size + 1)/2;
			}
			for(int i = 0; i < limit; i++)
			{
				int move = (1<<i);
				int movedia1 = (1<<(i+depth));
				int movedia2 = (1<<(size - i + 1 +depth));
				if((dia1 & movedia1) == 0 && (dia2 & movedia2) == 0 && (col & move) == 0)
				{
					board[depth] = i + 1;
					search(board, (short)depth + 1, movedia1 | dia1, movedia2 | dia2, col | move);
					board[depth] = 0;
					
				}
			}
		}
	}
}