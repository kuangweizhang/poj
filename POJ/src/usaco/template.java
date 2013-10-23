/*
ID: kuangwe4
LANG: JAVA
TASK: template
 */
package usaco;

import java.io.*;
import java.util.StringTokenizer;

class template {
	public static void main(String[] args) throws IOException {
//		BufferedReader f = new BufferedReader(new FileReader("template.in"));
//		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("template.out")));

		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(System.out);
		StringTokenizer st = new StringTokenizer(f.readLine());

		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}