/*
ID: kuangwe4
LANG: JAVA
TASK: ride
 */
package usaco;

import java.io.*;

class ride {
	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"ride.out")));
//		
//		BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
//		PrintWriter out = new PrintWriter(System.out);
		
		String st1 = f.readLine();
		String st2 = f.readLine();

		int id1 = 1;
		for (int i = 0; i < st1.length(); i++) {
			id1 *= (int) st1.charAt(i) - 64;
			if (id1 >= 47) {
				id1 %= 47;
			}
		}

		int id2 = 1;
		for (int i = 0; i < st2.length(); i++) {
			id2 *= (int) st2.charAt(i) - 64;
			if (id2 >= 47) {
				id2 %= 47;
			}
		}

		if (id1 == id2) {
			out.println("GO");
		} else {
			out.println("STAY");
		}
		out.close(); // close the output file
		System.exit(0); // don't omit this!
	}
}