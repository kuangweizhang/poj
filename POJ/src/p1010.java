import java.util.Scanner;

public class p1010 {
	public static int[] Categories;
	public static int[] Answer;
	public static int CategoryCount;
	public static int MaxCount;
	public static int LengthCount;
	public static boolean Tie;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNextLine())
		{
			String[] categoryAry = scanner.nextLine().split(" ");
			Categories = new int[categoryAry.length - 1];
			Answer = null;
			for(int i = 0; i < categoryAry.length - 1; i++)
			{
				Categories[i] = Integer.parseInt(categoryAry[i]);
			}
			String[] goals = scanner.nextLine().split(" ");
			for(int i = 0; i < goals.length - 1; i++)
			{
				int goal = Integer.parseInt(goals[i]);
				Answer = null;
				search(goal, new int[100], 0, 0, 0);
				if(Answer == null)
				{
					// 6 ---- none
					System.out.println(goal + " ---- none");	
				}
				else if(Tie)
				{
					// 3 (2): tie
					System.out.println(goal + " " + "(" + CategoryCount + "): tie");
				}
				else{
					// 7 (3): 1 1 2 3
					System.out.print(goal + " " + "(" + CategoryCount + "):");
					for(int j = 0; j < LengthCount; j++)
					{
						System.out.print(" " + Answer[j]);
					}
					System.out.println();
				}
			}
		}
	}
	
	public static void search(int leftValue, int[] combination, int nextPos, int keyPos, int categoryCount)
	{
		if(leftValue == 0)
		{
			updateAns(combination, categoryCount);
		}
		if(nextPos == 4)
		{
			return;
		}
		for(int keyIndex = keyPos; keyIndex < Categories.length; keyIndex++)
		{
			int key = Categories[keyIndex];
			if(leftValue - key >= 0)
			{
				combination[nextPos] = key;
				int newCategoryCount = categoryCount;
				if(keyIndex != keyPos || nextPos == 0 && keyPos == 0)
				{
					newCategoryCount += 1;
				}
				search(leftValue - key, combination, nextPos + 1, keyIndex, newCategoryCount);
				combination[nextPos] = 0;
			}
		}
	}
	
	public static void updateAns(int[] newAns, int categoryCount)
	{
		int length = 0;
		int max = 0;
		for (int i = 0; i < newAns.length; i++)
		{
			if(newAns[i] == 0)
			{
				break;
			}
			length++;
			if(newAns[i] > max)
			{
				max = newAns[i];
			}
		}
		if(Answer == null)
		{
			Answer = newAns.clone();
			CategoryCount = categoryCount;
			LengthCount = length;
			MaxCount = max;
			Tie = false;
			return;
		}
		
		if(CategoryCount < categoryCount || 
				CategoryCount == categoryCount && LengthCount > length ||
				CategoryCount == categoryCount && LengthCount == length && MaxCount < max
				)
		{
			Answer = newAns.clone();
			CategoryCount = categoryCount;
			LengthCount = length;
			MaxCount = max;
			Tie = false;
			return;
		}
		if (CategoryCount == categoryCount && LengthCount == length && MaxCount == max)
		{
			Tie = true;
		}
	}
}
