/*
ID: kuangwe4
LANG: JAVA
TASK: milk
 */
package usaco;

import java.io.*;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class milk {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, Integer> pricetable = new HashMap<Integer, Integer>();
		PriorityQueue<Integer> priceQueue = new PriorityQueue<Integer>();
		
		for(int i = 0; i < m; i++)
		{
			st = new StringTokenizer(f.readLine());
			int price = Integer.parseInt(st.nextToken());
			int amount = Integer.parseInt(st.nextToken());
			if(pricetable.containsKey(price))
			{
				pricetable.put(price, pricetable.get(price) + amount);
			}
			else {
				pricetable.put(price, amount);
				priceQueue.add(price);
			}
		}
		
		
		int total = 0;
		while (n != 0)
		{
			int price = priceQueue.poll();
			int amount = pricetable.get(price);
			if (n - amount > 0)
			{
				n -= amount;
				total += price * amount;
			}
			else {
				total += n*price;
				n = 0;
			}
		}
		out.println(total);
		
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}