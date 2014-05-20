/*
ID: kuangwe4
LANG: JAVA
TASK: butter
 */
package usaco;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import org.omg.CORBA.PUBLIC_MEMBER;

class butter {
	
	public static class HeapNode
	{
		public int LinerIndex;
		public int Value;
		public int HeapIndex;
		public HeapNode(int index, int value)
		{
			LinerIndex = index;
			Value = value;
			HeapIndex = 0;
		}
	}
	
	public static class Heap
	{
		private int ElementLeft = 0;
		private HeapNode[] HeapContent;
		private HeapNode[] AddressTracker;
		
		public Heap()
		{
			
		}
		
		public void makeHeap(HashMap<Integer, Integer> neighbors)
		{
			ElementLeft = neighbors.size();
			HeapContent = new HeapNode[ElementLeft + 1];
			AddressTracker = new HeapNode[P];
			int i = 0;
			for(int neighborId : neighbors.keySet())
			{
				HeapNode theNode = new HeapNode(neighborId, neighbors.get(neighborId));
				theNode.HeapIndex = i + 1;
				AddressTracker[neighborId] = theNode;
				HeapContent[i + 1] = theNode;
				UpwardsMove(i + 1);
				i++;
			}
			//int k = 3;
		}
		
		private void UpwardsMove(int heapIndex)
		{
			//heapCheck();
			while(heapIndex != 1)
			{
				HeapNode parentNode = HeapContent[heapIndex/2];
				HeapNode currentNode = HeapContent[heapIndex];
				if(parentNode.Value > currentNode.Value)
				{
					//heapCheck();
					HeapContent[heapIndex] = parentNode;
					HeapContent[heapIndex/2] = currentNode;
					parentNode.HeapIndex = heapIndex;
					currentNode.HeapIndex = heapIndex/2;
					//heapCheck();
				}
				else {
					break;
				}
				heapIndex /= 2;
			}
		}
		
		private void DownwardsMove(int heapIndex)
		{
			//heapCheck();
			while (heapIndex < ElementLeft)
			{
				//System.out.println(heapIndex);
				HeapNode smallerChild = null;
				if (heapIndex * 2 < ElementLeft)
				{
					smallerChild = HeapContent[heapIndex * 2];
				}
				if (heapIndex * 2 + 1 < ElementLeft
						&& HeapContent[heapIndex * 2 + 1].Value < smallerChild.Value)
				{
					smallerChild = HeapContent[heapIndex * 2 + 1];
				}
				HeapNode currentNode = HeapContent[heapIndex];
				
				if (smallerChild != null
						&& smallerChild.Value < currentNode.Value)
				{
					//heapCheck();
					int tempIndex = smallerChild.HeapIndex;
					smallerChild.HeapIndex = currentNode.HeapIndex;
					currentNode.HeapIndex = tempIndex;
					HeapContent[smallerChild.HeapIndex] = smallerChild;
					HeapContent[currentNode.HeapIndex] = currentNode;
					heapIndex = currentNode.HeapIndex;
					//heapCheck();
				}
				else {
					break;
				}
			}
		}
		
//		private void heapCheck()
//		{
//			for(int i = 1; i <= ElementLeft; i++)
//			{
//				if(HeapContent[i] != null && HeapContent[i].HeapIndex != i)
//				{
//					System.out.println("Error");
//				}
//			}
//		}
		
		public int removeTopIndex()
		{
			HeapNode tempNode = HeapContent[1];
			HeapContent[1] = HeapContent[ElementLeft];
			HeapContent[ElementLeft] = tempNode;
			HeapContent[1].HeapIndex = 1;
			HeapContent[ElementLeft].HeapIndex = ElementLeft;
			ElementLeft--;
			DownwardsMove(1);
			return HeapContent[ElementLeft + 1].LinerIndex;
		}
		
		public int get(int index)
		{
			return AddressTracker[index].Value;
		}
		
		public void set(int index, int value)
		{
			HeapNode node = AddressTracker[index];
			node.Value = value;
			UpwardsMove(node.HeapIndex);
			DownwardsMove(node.HeapIndex);
		}
		
		public int size()
		{
			return ElementLeft;
		}
	}
	
	public static int N;
	public static int P;
	public static int C;
	
	public static void main(String[] args) throws IOException {
//		BufferedReader f = new BufferedReader(new FileReader("butter.in"));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("butter.out")));

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		LinkedList<Integer> Cows = new LinkedList<Integer>();
		ArrayList<HashMap<Integer, Integer>> Neighbors = new ArrayList<HashMap<Integer,Integer>>(P);
		for(int i = 0; i < P; i++)
		{
			Neighbors.add(new HashMap<Integer, Integer>());
		}
		for(int i = 0; i < N; i++)
		{
			Cows.add(Integer.parseInt(f.readLine()) - 1);
		}
		int[] SUM = new int[P];

		
		for(int i = 0; i < C; i++)
		{
			st = new StringTokenizer(f.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int c = Integer.parseInt(st.nextToken());
			Neighbors.get(a).put(b, c);
			Neighbors.get(b).put(a, c);
		}

		for(int thecow : Cows)
		{
			Heap heap = new Heap();
			heap.makeHeap(Neighbors.get(thecow));
			while(heap.size() != 0)
			{
				int smallestIndex = heap.removeTopIndex();
				for(int neghborID : Neighbors.get(thecow).keySet())
				{
					if(Neighbors.get(smallestIndex).get(neghborID) != null &&
							heap.get(neghborID) > heap.get(smallestIndex) + Neighbors.get(smallestIndex).get(neghborID))
					{
						heap.set(neghborID, heap.get(smallestIndex) + Neighbors.get(smallestIndex).get(neghborID));
					}
				}
			}
			
			for(int i = 1; i < heap.HeapContent.length; i++)
			{
				SUM[heap.HeapContent[i].LinerIndex] += heap.HeapContent[i].Value;
			}
		}
		
		int answer = Integer.MAX_VALUE;
		for(int i = 0; i < P; i++)
		{
			if(SUM[i] < answer)
			{
				answer = SUM[i];
			}
		}
		
		out.println(answer);
		
		f.close();
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}