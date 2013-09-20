import java.lang.Thread.State;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

import javax.print.attribute.IntegerSyntax;

public class p1068 {
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for(int i = 0; i < n ; i++)
		{
			LinkedList<Integer> answer = new LinkedList<Integer>();
			int k = scanner.nextInt();
			String st = "";
			int previous = 0;
			for (int j = 0; j < k; j++)
			{
				int current = scanner.nextInt();
				for(int p = 0; p < current - previous; p++)
				{
					st += "(";
				}
				st+=")";
				previous = current;
			}
			//System.out.println(st);
			Stack<Integer> stack = new Stack<Integer>();
			for(int j = 0; j < st.length(); j++)
			{
				if (st.charAt(j) == '(')
				{
					stack.push(j);
				}
				else 
				{
					int index = stack.pop();
					int count = 0;
					for (int p = index; p <= j; p++)
					{
						if (st.charAt(p) == ')')
						{
							count++;
						}
					}
					answer.add(count);
				}
			}
			for(int q = 0; q < answer.size() - 1; q++)
			{
				System.out.print(answer.get(q) + " ");
			}
			System.out.println(answer.getLast());
		}
	}
}
