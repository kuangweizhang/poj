import java.util.Scanner;

/**
 * Started: 9/19/2013
 * Finished: 9/19/2013
 * @author Kevin
 *
 */
public class p1050 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner cin = new Scanner(System.in);
		int n = cin.nextInt();
		if (n == 1)
		{
			System.out.println(cin.nextInt());
			System.exit(0);
		}
		int[][] a = new int[n][n];
		for(int i = 0; i < n; i++)
		{
			for(int j = 0; j < n; j++)
			{
				a[i][j] = cin.nextInt();
			}
		}
		int[][] sum = new int[n][n];
		for (int i = 0; i < n; i++)
		{
			for (int j = 0; j < n; j++)
			{
				if(i == 0)
				{
					sum[i][j] = a[i][j];
				}
				else
				{
					sum[i][j] = a[i][j] + sum[i-1][j];
				}
			}
		}
		int max = 0;
		for (int i = 0; i < n - 1; i++)
		{
			for (int j = i+1; j <n; j++)
			{
				int sumn;
				if (i != 0)
				{
					sumn = sum[j][0] - sum[i-1][0];
				}
				else {
					sumn = sum[j][0];
				}
				for(int k = 1; k < n; k++)
				{
					if (sumn > 0)
					{
						if (i != 0)
						{
							sumn += sum[j][k] - sum[i-1][k];
						}
						else {
							sumn += sum[j][k];
						}
					}
					else
					{
						if (i != 0)
						{
							sumn = sum[j][k] - sum[i-1][k];
						}
						else {
							sumn = sum[j][k];
						}
					}
					if (sumn > max)
					{
						max = sumn;
					}
				}
			}
		}
		System.out.println(max);
	}
}
