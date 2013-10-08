/*
ID: kuangwe4
LANG: JAVA
TASK: gift1
 */
package usaco;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

class gift1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("gift1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"gift1.out")));
//		
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		HashMap<String, Integer> balance= new HashMap<String, Integer>();
		String[] players = new String[n];
		for(int i = 0; i < n; i++)
		{
			players[i] = f.readLine();
			balance.put(players[i], 0);
		}
		
		String giver = f.readLine();
		while (giver != null)
		{
			StringTokenizer token = new StringTokenizer(f.readLine());
			int money = Integer.parseInt(token.nextToken());
			int nFriends = Integer.parseInt(token.nextToken());
			int gift = 0;
			if (nFriends != 0)
			{
				gift = money/nFriends;
			}
			balance.put(giver, balance.get(giver) - nFriends*gift);
			for(int i = 0; i < nFriends; i++)
			{
				String friend = f.readLine();
				balance.put(friend, balance.get(friend) + gift);
			}
			giver = f.readLine();
		}
		
		for (String string : players) {
			out.println(string + " " + balance.get(string));
		}
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}