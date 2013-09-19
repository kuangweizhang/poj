import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

/**
 * Started: 9/19/2013
 * Finished: 9/19/2013
 * @author Kevin
 *
 */
public class p1051 {

	public static HashMap<String, String> letterToM = new HashMap<String, String>();
	public static HashMap<String, String> mtoLetter = new HashMap<String, String>();
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		cin.nextLine();
		
		letterToM.put("A",".-");
		letterToM.put("H","....");
		letterToM.put("O","---");
		letterToM.put("V","...-");
		letterToM.put("B","-...");
		letterToM.put("I","..");
		letterToM.put("P",".--.");
		letterToM.put("W",".--");
		letterToM.put("C","-.-.");
		letterToM.put("J",".---");
		letterToM.put("Q","--.-");
		letterToM.put("X","-..-");
		letterToM.put("D","-..");
		letterToM.put("K","-.-");
		letterToM.put("R",".-.");
		letterToM.put("Y","-.--");
		letterToM.put("E",".");
		letterToM.put("L",".-..");
		letterToM.put("S","...");
		letterToM.put("Z","--..");
		letterToM.put("F","..-.");
		letterToM.put("M","--");
		letterToM.put("T","-");
		letterToM.put("G","--.");
		letterToM.put("N","-.");
		letterToM.put("U","..-");
		letterToM.put("_","..--");
		letterToM.put(",",".-.-");
		letterToM.put(".","---.");
		letterToM.put("?","----");
		
		for (String letter: letterToM.keySet())
		{
			mtoLetter.put(letterToM.get(letter), letter);
		}

		for(int i = 0; i < n; i++)
		{
			System.out.print(i + 1 + ": ");
			String st = cin.nextLine();
			Stack<Integer> separa = new Stack<Integer>();
			LinkedList<Character> morse = new LinkedList<Character>(); 
			for(int j = 0; j < st.length(); j++)
			{
				String morsecode = letterToM.get(st.charAt(j) + "");
				
				for(int k = 0; k < morsecode.length(); k++)
				{
					morse.add(morsecode.charAt(k));
				}
				separa.push(morsecode.length());
			}
			while(!separa.isEmpty())
			{
				int length = separa.pop();
				String morsecode = "";
				for(int j = 0; j < length; j++)
				{
					morsecode += morse.get(0);
					morse.remove(0);
				}
				System.out.print(mtoLetter.get(morsecode));
			}
			System.out.println();
		}
	}

}
