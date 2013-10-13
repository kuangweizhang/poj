/*
ID: kuangwe4
LANG: JAVA
TASK: namenum
 */
package usaco;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedList;

class namenum {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("namenum.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenum.out")));
//		
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		HashMap<Long, LinkedList<String>> wordsmap = new HashMap<Long, LinkedList<String>>(5000);
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('A', 2);
		map.put('B', 2);
		map.put('C', 2);
		map.put('D', 3);
		map.put('E', 3);
		map.put('F', 3);
		map.put('G', 4);
		map.put('H', 4);
		map.put('I', 4);
		map.put('J', 5);
		map.put('K', 5);
		map.put('L', 5);
		map.put('M', 6);
		map.put('N', 6);
		map.put('O', 6);
		map.put('P', 7);
		map.put('R', 7);
		map.put('S', 7);
		map.put('T', 8);
		map.put('U', 8);
		map.put('V', 8);
		map.put('W', 9);
		map.put('X', 9);
		map.put('Y', 9);
		BufferedReader f2 = new BufferedReader(new FileReader("dict.txt"));
		String word = f2.readLine();
		while(word != null)
		{
			long key = 0;
			boolean valid = true;
			for(int i = 0; i < word.length(); i++)
			{
				if(word.charAt(i) == 'Q' || word.charAt(i) == 'Z')
				{
					valid = false;
					break;
				}
				else {
					key = key * 10 + map.get(word.charAt(i)); 
				}
			}
			if (valid) {
				if (wordsmap.containsKey(key)) {
					wordsmap.get(key).add(word);
				} else {
					LinkedList<String> list = new LinkedList<String>();
					list.add(word);
					wordsmap.put(key, list);
				}
			}
			word = f2.readLine();
		}
		
		long k = Long.parseLong(f.readLine());
		if(wordsmap.containsKey(k))
		{
			for(String st : wordsmap.get(k))
			{
				out.println(st);
			}
		}
		else {
			out.println("NONE");
		}
		out.close();
		System.exit(0);
	}
}