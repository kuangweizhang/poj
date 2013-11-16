/*
ID: kuangwe4
LANG: JAVA
TASK: preface
 */
package usaco;

import java.io.*;
import java.util.Hashtable;
import java.util.StringTokenizer;

class preface {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("preface.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(f.readLine());
		
		Hashtable<Character, Integer> counts = new Hashtable<Character, Integer>();
		counts.put('I', 0);
		counts.put('V', 0);
		counts.put('X', 0);
		counts.put('L', 0);
		counts.put('C', 0);
		counts.put('D', 0);
		counts.put('M', 0);
		
		for(int i = 1; i <= n; i++)
		{
			String st = intToRoman(i);
			for(int j = 0; j < st.length(); j++)
			{
				counts.put(st.charAt(j), counts.get(st.charAt(j)) + 1);
			}
		}
		
		if(counts.get('I') != 0)
		{
			out.println("I " + counts.get('I'));
		}
		if(counts.get('V') != 0)
		{
			out.println("V " + counts.get('V'));
		}
		if(counts.get('X') != 0)
		{
			out.println("X " + counts.get('X'));
		}
		if(counts.get('L') != 0)
		{
			out.println("L " + counts.get('L'));
		}
		if(counts.get('C') != 0)
		{
			out.println("C " + counts.get('C'));
		}
		if(counts.get('D') != 0)
		{
			out.println("D " + counts.get('D'));
		}
		if(counts.get('M') != 0)
		{
			out.println("M " + counts.get('M'));
		}

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	
    public static String intToRoman(int num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(num >= 1000)
        {
            return singleDigit('M', 'K', 'S', num/1000) + intToRoman(num % 1000);
        }
        if(num >= 100)
        {
            return singleDigit('C', 'D', 'M', num/100) + intToRoman(num % 100);
        }
        if(num >= 10)
        {
            return singleDigit('X', 'L', 'C', num/10) + intToRoman(num % 10);
        }
        return singleDigit('I', 'V', 'X', num);
    }
    
    public static String singleDigit(char One, char Five, char Ten, int dig)
    {
        String retval = "";
        switch(dig)
        {
            case 0: return ""; //break;
            case 1: return "" + One; //break;
            case 2: return "" + One + One; //break;
            case 3: return "" + One + One + One; //break;
            case 4: return "" + One + Five; //break;
            case 5: return "" + Five; //break;
            case 6: return "" + Five + One; //break;
            case 7: return "" + Five + One + One; //break;
            case 8: return "" + Five + One + One + One; //break;
            case 9: return "" + One + Ten; //break;
        }
        return "Nothing";
    }
}