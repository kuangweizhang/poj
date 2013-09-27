import java.util.Hashtable;
import java.util.Scanner;


public class p1008 {

	public static void main(String[] args)
	{
		Hashtable<String, Integer> month1 = new Hashtable<String, Integer>();
		month1.put("pop", 0);
		month1.put("no", 1);
		month1.put("zip", 2);
		month1.put("zotz", 3);
		month1.put("tzec", 4);
		month1.put("xul", 5);
		month1.put("yoxkin", 6);
		month1.put("mol", 7);
		month1.put("chen", 8);
		month1.put("yax", 9);
		month1.put("zac", 10);
		month1.put("ceh", 11);
		month1.put("mac", 12);
		month1.put("kankin", 13);
		month1.put("muan", 14);
		month1.put("pax", 15);
		month1.put("koyab", 16);
		month1.put("cumhu", 17);
		month1.put("uayet", 18);
		
		String[] month2 = { "imix", "ik", "akbal", "kan", "chicchan", "cimi", "manik", "lamat", "muluk"
			, "ok", "chuen", "eb", "ben", "ix", "mem", "cib", "caban", "eznab", "canac", "ahau"};
		
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println(n);
		scanner.nextLine();
		for(int i = 0; i < n; i++)
		{
			String st = scanner.nextLine();
			String[] inputStrings = st.split(" ");
			int day = Integer.parseInt(inputStrings[0].substring(0, inputStrings[0].length() - 1));
			int month = month1.get(inputStrings[1]);
			int year = Integer.parseInt(inputStrings[2]);
			int totaldays = year*365 + month*20 + day;
			
			int newyear = totaldays /260;
			int leftdays = totaldays % 260;
			System.out.println(leftdays % 13 + 1 + " " + month2[leftdays % 20] + " " + newyear);
		}
	}
}