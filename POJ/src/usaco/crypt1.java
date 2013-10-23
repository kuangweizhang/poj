/*
ID: kuangwe4
LANG: JAVA
TASK: crypt1
 */
package usaco;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class crypt1 {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));

//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		int n = Integer.parseInt(f.readLine());
		StringTokenizer st = new StringTokenizer(f.readLine());

		LinkedList<Integer> digits = new LinkedList<Integer>();
		for(int i = 0; i < n; i++)
		{
			digits.add(Integer.parseInt(st.nextToken()));
		}
		int counter = 0;
		for (Integer i : digits) {
			for (Integer j : digits) {
				for (Integer k : digits) {
					for (Integer l : digits) {
						for (Integer m : digits) {
							int number1 = i*100 + j*10 + k;
							int number2 = l*10+m;
							int product1 = number1 * m;
							int product2 = number1 * l;
							if(product1 >= 1000 || product2 >= 1000)
							{
								continue;
							}
							int totalproduct = number1*number2;
							if(totalproduct >= 10000)
							{
								continue;
							}
							if(!digits.contains(product1/100))
							{
								continue;
							}
							if(!digits.contains((product1/10)%10))
							{
								continue;
							}
							if(!digits.contains(product1%10))
							{
								continue;
							}
							
							if(!digits.contains(product2/100))
							{
								continue;
							}
							if(!digits.contains((product2/10)%10))
							{
								continue;
							}
							if(!digits.contains(product2%10))
							{
								continue;
							}
							
							if(!digits.contains(totalproduct/1000))
							{
								continue;
							}
							if(!digits.contains((totalproduct/100)%10))
							{
								continue;
							}
							if(!digits.contains((totalproduct/10)%10))
							{
								continue;
							}
							if(!digits.contains((totalproduct)%10))
							{
								continue;
							}
							counter++;
						}
					}
				}
			}
		}
		out.println(counter);
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}