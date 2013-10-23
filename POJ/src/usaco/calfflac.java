/*
ID: kuangwe4
LANG: JAVA
TASK: calfflac
 */
package usaco;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class calfflac {
	static boolean[] records = new boolean[20001];
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("calfflac.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("calfflac.out")));
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);

		String st = f.readLine();
		//LinkedList<Character> stringCharacters = new LinkedList<Character>();
		char[] stringsChars = new char[20001];
		
		int stringCharLength = 0;
		while(st != null)
		{
			for(int i = 0; i < st.length(); i++)
			{
				stringsChars[stringCharLength] = st.charAt(i);
				stringCharLength++;
			}
			stringsChars[stringCharLength] = '\n';
			stringCharLength++;
			st = f.readLine();
		}
		int longestlength = Integer.MIN_VALUE;
		int longeststart = 0;
		int longestend = 0;
		for(int mid = 0; mid < stringCharLength - longestlength/2; mid++)
		{
//			System.out.println(mid);
			int lengthcounter;
			if((stringsChars[mid] >= 'a' && stringsChars[mid] <= 'z')||
					(stringsChars[mid] >= 'A' && stringsChars[mid] <= 'Z'))
			{
				lengthcounter = 1;
			}
			else {
				lengthcounter = 0;
			}
			Integer leftworker = mid - 1;
			Integer rightworker = mid + 1;
			leftworker = nextChar(leftworker, -1, stringsChars, stringCharLength);
			rightworker = nextChar(rightworker, 1, stringsChars, stringCharLength);
			if(leftworker == null || rightworker == null)
			{
				continue;
			}
			while(charequal(stringsChars[leftworker],stringsChars[rightworker]))
			{
				lengthcounter += 2;
				leftworker = nextChar(leftworker - 1, -1, stringsChars, stringCharLength);
				rightworker = nextChar(rightworker + 1, 1, stringsChars, stringCharLength);
				if(leftworker == null || rightworker == null)
				{
					break;
				}
			}
			if(leftworker == null)
			{
				leftworker = 0;
			}
			if(rightworker == null)
			{
				rightworker = stringCharLength - 1;
			}
			if(lengthcounter > longestlength)
			{
				longestlength = lengthcounter;
				longeststart = nextChar(leftworker + 1, 1, stringsChars, stringCharLength);
				longestend = nextChar(rightworker - 1, -1, stringsChars, stringCharLength);
			}
						
			// even
			lengthcounter = 0;
			leftworker = mid;
			rightworker = mid + 1;
			leftworker = nextChar(leftworker, -1, stringsChars, stringCharLength);
			rightworker = nextChar(rightworker, 1, stringsChars, stringCharLength);
			if(leftworker == null || rightworker == null)
			{
				continue;
			}
			while(charequal(stringsChars[leftworker],stringsChars[rightworker]))
			{
				lengthcounter += 2;
				leftworker = nextChar(leftworker - 1, -1, stringsChars, stringCharLength);
				rightworker = nextChar(rightworker + 1, 1, stringsChars, stringCharLength);
				if(leftworker == null || rightworker == null)
				{
					break;
				}
			}
			if(leftworker == null)
			{
				leftworker = 0;
			}
			if(rightworker == null)
			{
				rightworker = stringCharLength - 1;
			}
			if(lengthcounter > longestlength)
			{
				longestlength = lengthcounter;
				longeststart = nextChar(leftworker + 1, 1, stringsChars, stringCharLength);
				longestend = nextChar(rightworker - 1, -1, stringsChars, stringCharLength);
			}
		}
		out.println(longestlength);
		if(longeststart == 1)
		{
			out.print(stringsChars[0]);
		}
		for(int i = longeststart; i <= longestend; i++)
		{
			out.print(stringsChars[i]);
		}
		out.println();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static boolean charequal(char ch1, char ch2)
	{
		int i,j = 0;
		if(ch1 >= 'a' && ch1 <= 'z')
		{
			i = (int)ch1 - (int)'a';
		}
		else {
			i = (int)ch1 - (int)'A';
		}
		if(ch2 >= 'a' && ch2 <= 'z')
		{
			j = (int)ch2 - (int)'a';
		}
		else {
			j = (int)ch2 - (int)'A';
		}
		return i == j;
	}
	
	public static Integer nextChar(int index, int direction, char[] string, int length){
		if(index < 0 || index >= length)
		{
			return null;
		}
		if(records[index])
		{
			return index;
		}
		if((string[index]>='a' && string[index]<='z')||(string[index]>='A' && string[index]<='Z'))
		{
			records[index] = true;
			return index;
		}
		else {
			return nextChar(index + direction, direction, string, length);
		}
	}
}