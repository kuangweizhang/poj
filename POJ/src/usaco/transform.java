/*
ID: kuangwe4
LANG: JAVA
TASK: transform
 */
package usaco;

import java.io.*;

class transform {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("transform.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
//		
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		int n = Integer.parseInt(f.readLine());
		boolean[][] matrix = new boolean[n][n];
		boolean[][] matrix2 = new boolean[n][n];
		
		for(int i = 0; i < n; i++)
		{
			String st = f.readLine();
			for(int j = 0; j < n; j++)
			{
				if(st.charAt(j) == '-')
				{
					matrix[i][j] = true;
				}
			}
		}
		
		for(int i = 0; i < n; i++)
		{
			String st = f.readLine();
			for(int j = 0; j < n; j++)
			{
				if(st.charAt(j) == '-')
				{
					matrix2[i][j] = true;
				}
			}
		}
		
		if(same(matrix2, transform1(matrix, n), n))
		{
			out.println(1);
			out.close();
			System.exit(0);
		}
		
		if(same(matrix2, transform2(matrix, n), n))
		{
			out.println(2);
			out.close();
			System.exit(0);
		}
		
		if(same(matrix2, transform3(matrix, n), n))
		{
			out.println(3);
			out.close();
			System.exit(0);
		}
		
		if(same(matrix2, transform4(matrix, n), n))
		{
			out.println(4);
			out.close();
			System.exit(0);
		}
		
		if(same(matrix2, transform51(matrix, n), n))
		{
			out.println(5);
			out.close();
			System.exit(0);
		}
		
		if(same(matrix2, transform52(matrix, n), n))
		{
			out.println(5);
			out.close();
			System.exit(0);
		}
		
		if(same(matrix2, transform53(matrix, n), n))
		{
			out.println(5);
			out.close();
			System.exit(0);
		}
		
		if(same(matrix2, transform6(matrix, n), n))
		{
			out.println(6);
			out.close();
			System.exit(0);
		}
		
		out.println(7);
		out.close();
		System.exit(0);
	}
	
	public static boolean[][] transform1(boolean[][] matrix, int n)
	{
		boolean[][] retval = new boolean[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				retval[j][n-i-1] = matrix[i][j];
			}
		}
		return retval;
	}
	
	public static boolean[][] transform2(boolean[][] matrix, int n)
	{
		return transform1(transform1(matrix, n), n);
	}
	
	public static boolean[][] transform3(boolean[][] matrix, int n)
	{
		return transform2(transform1(matrix, n), n);
	}
	
	public static boolean[][] transform4(boolean[][] matrix, int n)
	{
		boolean[][] retval = new boolean[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				retval[i][n-j-1] = matrix[i][j];
			}
		}
		return retval;
	}
	
	public static boolean[][] transform51(boolean[][] matrix, int n)
	{
		return transform1(transform4(matrix, n), n);
	}
	
	public static boolean[][] transform52(boolean[][] matrix, int n)
	{
		return transform2(transform4(matrix, n), n);
	}
	
	public static boolean[][] transform53(boolean[][] matrix, int n)
	{
		return transform3(transform4(matrix, n), n);
	}
	
	public static boolean[][] transform6(boolean[][] matrix, int n)
	{
		return matrix;
	}
	
	public static boolean same(boolean[][] matrix1, boolean[][] matrix2, int n) {
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				if(matrix2[i][j]!=matrix1[i][j])
				{
					return false;
				}
			}
		}
		return true;
	}
}