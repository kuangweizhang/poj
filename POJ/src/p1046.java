import java.util.Scanner;


public class p1046 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int[] r = new int[16];
		int[] g = new int[16];
		int[] b = new int[16];
		for(int i = 0; i < 16; i++)
		{
			r[i] = scanner.nextInt();
			g[i] = scanner.nextInt();
			b[i] = scanner.nextInt();
			if ((r[i] == -1)||(g[i] == -1)||(b[i] == -1))
			{
				System.exit(0);
			}
		}
		
		int cr = scanner.nextInt();
		int cg = scanner.nextInt();
		int cb = scanner.nextInt();
		while (cr != -1)
		{
			int mr = 0;
			int mg = 0;
			int mb = 0;
			int dis = Integer.MAX_VALUE;
			for(int i = 0; i < 16; i++)
			{
				if (dis > (r[i] - cr)*(r[i] - cr) + (g[i] - cg)*(g[i] - cg) + (b[i] - cb)*(b[i] - cb))
				{
					dis = (r[i] - cr)*(r[i] - cr) + (g[i] - cg)*(g[i] - cg) + (b[i] - cb)*(b[i] - cb);
					mr = r[i];
					mg = g[i];
					mb = b[i];
				}
			}
			System.out.println("(" + cr + "," + cg + "," + cb + ") maps to (" + mr + "," + mg + "," + mb + ")");
			cr = scanner.nextInt();
			cg = scanner.nextInt();
			cb = scanner.nextInt();
		}
	}
}
