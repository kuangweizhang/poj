import java.util.Scanner;

public class p1011 {

	public static int[] Sticks;
	public static boolean[] Used;
	public static int Goal;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int length = scanner.nextInt();
			int max = 0;
			int sum = 0;
			Sticks = new int[length];
			Used = new boolean[length];
			for (int i = 0; i < length; i++) {
				Sticks[i] = scanner.nextInt();
				Used[i] = false;
				if (Sticks[i] > max) {
					max = Sticks[i];
				}
				sum += Sticks[i];
			}
			for (Goal = max; Goal < Integer.MAX_VALUE; Goal++) {
				if (sum % Goal == 0) {
					if(search(Goal, length))
					{
						System.out.println(Goal);
						break;
					}
				}
			}
		}
	}

	public static boolean search(int left, int stickSize) {
		if (stickSize == 0) {
			if (left == 0) {
				return true;
			}
			return false;
		} else {
			if(left == 0)
			{
				left = Goal;
			}
			boolean result = false;
			for(int i = 0 ; i < Sticks.length; i++)
			{
				if(!Used[i])
				{
					int value = Sticks[i];
					if(value <= left)
					{
						Used[i] = true;
						result = result || search(left -= value, stickSize - 1);
						Used[i] = false;
					}
				}
			}
			return result;
		}
	}
}
// Kitty's first step in programming
//faja;kfja;irj
//ldfkatrjioja'
//;lmf,amia'elf
//LWKRNJ;WOIRJ;ERKJM
