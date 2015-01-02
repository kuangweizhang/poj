import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class p1011 {

	public static LinkedList<Integer> Sticks;
	public static int Goal;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNextInt()) {
			int length = scanner.nextInt();
			int max = 0;
			int sum = 0;
			Sticks = new LinkedList<Integer>();
			for (int i = 0; i < length; i++) {
				Sticks.addLast(scanner.nextInt());
				if (Sticks.getLast() > max) {
					max = Sticks.getLast();
				}
				sum += Sticks.getLast();
			}
			for (Goal = max; Goal < Integer.MAX_VALUE; Goal++) {
				if (sum % Goal == 0) {
					System.out.println(search(Goal));
				}
			}
		}
	}

	public static boolean search(int left) {
		if (Sticks.size() == 0) {
			if (left == 0) {
				return true;
			}
			return false;
		} else {
			if(left == 0)
			{
				left = Goal;
			}
			ListIterator<Integer> iterator = Sticks.listIterator();
			boolean result = false;
			while (iterator.hasNext()) {
				int value = iterator.next();
				if (value <= left) {
					iterator.remove();
					result = result || search(left -= value);
					iterator.add(value);
				}
			}
			return result;
		}
	}
}
