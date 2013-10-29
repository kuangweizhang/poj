/*
ID: kuangwe4
LANG: JAVA
TASK: milk3
 */
package usaco;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class StageMilk3
{
	int [] bucket = new int[3];
	int [] milk = new int[3];
}

class milk3 {
	
	static HashMap<Integer, StageMilk3> record = new HashMap<Integer, StageMilk3>();
	static LinkedList<StageMilk3> queue = new LinkedList<StageMilk3>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		StageMilk3 startStage = new StageMilk3();
		startStage.bucket[0] = a;
		startStage.bucket[1] = b;
		startStage.bucket[2] = c;
		startStage.milk[0] = 0;
		startStage.milk[1]= 0;
		startStage.milk[2] = c;
		
		queue.add(startStage);
		
		record.put(hash(startStage), startStage);
		while(!queue.isEmpty())
		{
			StageMilk3 currentstage = queue.pollFirst();
			for(int from = 0; from <= 2; from++)
			{
				for(int to = 0; to <= 2; to++)
				{
					if(from != to)
					{
						pour(currentstage, from, to);
					}
				}
			}
		}
		
		LinkedList<Integer> ans = new LinkedList<Integer>();
		for (StageMilk3 stage : record.values())
		{
			if(stage.milk[0] == 0)
			{
				ans.add(stage.milk[2]);
			}
		}
		Collections.sort(ans);
		for(int i = 0; i < ans.size() - 1; i++)
		{
			out.print(ans.get(i) + " ");
		}
		out.println(ans.getLast());
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
	
	public static void pour(StageMilk3 stage, int from, int to)
	{
		StageMilk3 newStage = new StageMilk3();
		newStage.bucket = stage.bucket.clone();
		newStage.milk = stage.milk.clone();
		if(newStage.milk[from] != 0 && newStage.bucket[to] != newStage.milk[to])
		{
			if(newStage.milk[from] > newStage.bucket[to] - newStage.milk[to])
			{
				newStage.milk[from] -= (newStage.bucket[to] - newStage.milk[to]);
				newStage.milk[to] = newStage.bucket[to];
			}
			else {
				newStage.milk[to] += newStage.milk[from];
				newStage.milk[from] = 0;
			}
			if(!record.containsKey(hash(newStage)))
			{
				record.put(hash(newStage), newStage);
				queue.addLast(newStage);
			}
		}
	}
	
	public static int hash(StageMilk3 stage){
		return stage.milk[0] * 21 * 21 + stage.milk[1] * 21 + stage.milk[2];
	}
}