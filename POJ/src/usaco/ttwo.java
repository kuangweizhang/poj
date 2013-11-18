/*
ID: kuangwe4
LANG: JAVA
TASK: ttwo
 */
package usaco;

import java.io.*;

class ttwo {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ttwo.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ttwo.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		int[][] board = new int[11][11];
		int cx = 0;
		int cy = 0;
		int fx = 0;
		int fy = 0;
		
		for(int i = 1; i <= 10; i++)
		{
			String line = f.readLine();
			for(int j = 1; j <= 10; j++)
			{
				if(line.charAt(j - 1) == '*')
				{
					board[i][j] = 2;
				}
				else {
					board[i][j] = 1;
					if(line.charAt(j - 1) == 'C')
					{
						cx = i;
						cy = j;
					}
					if(line.charAt(j - 1) == 'F')
					{
						fx = i;
						fy = j;
					}
				}
			}
		}
		
		int[] cp = {cx, cy, -1, 0};
		int[] cf = {fx, fy, -1, 0};
		
		int counter = 0;
		while(!(cp[0] == cf[0] && cp[1] == cf[1]))
		{
			cp = getNext(cp, board);
			cf = getNext(cf, board);
			//System.out.println("Cow: " + cp[0] + " " + cp[1]);
			//System.out.println("F: " + cf[0] + " " + cf[1]);
			if(counter == 1000000)
			{
				out.println(0);
				out.close();
				System.exit(0);
			}
			counter++;
		}
		
		out.println(counter);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	private static int[] getNext(int[] position, int[][] board)
	{
		int x = position[0];
		int y = position[1];
		int dx = position[2];
		int dy = position[3];
		
		x += dx;
		y += dy;
		if(x >= 1 && x <= 10 && y >= 1 && y <= 10 && board[x][y] != 2)
		{
			int[] retval = new int[4];
			retval[0] = x;
			retval[1] = y;
			retval[2] = dx;
			retval[3] = dy;
			return retval;
		}
		else {
			return rotate(position);
		}
	}
	
	private static int[] rotate(int[] position)
	{
		int[] retval = new int[4];
		retval[0] = position[0];
		retval[1] = position[1];
		
		if(position[2] == -1 && position[3] == 0)
		{
			retval[2] = 0;
			retval[3] = 1;
			return retval;
		}
		if(position[2] == 0 && position[3] == 1)
		{
			retval[2] = 1;
			retval[3] = 0;
			return retval;
		}
		if(position[2] == 1 && position[3] == 0)
		{
			retval[2] = 0;
			retval[3] = -1;
			return retval;
		}
		if(position[2] == 0 && position[3] == -1)
		{
			retval[2] = -1;
			retval[3] = 0;
			return retval;
		}
		return null;
	}
}