import java.util.Scanner;


public class p1012 {

	public static int K;
	public static int KD;
	public static int M;
	public static int[] KANS;
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		KANS = new int[14];
		while(scanner.hasNextInt())
		{
			K = scanner.nextInt();
			if(KANS[K] != 0)
			{
				System.out.println(KANS[K]);
				continue;
			}
			KD = K * 2;
			if(K == 0)
			{
				break;
			}
			for(M = K+1; M < Integer.MAX_VALUE; M++)
			{
				if(search(KD+1, 0))
				{
					System.out.println(M);
					KANS[K] = M;
					break;
				}
			}
		}
	}
	
	public static boolean search(int prev, int depth)
	{
		if(depth == K)
		{
			return true;
		}
		prev = (M -(KD - depth + 1 - prev))%(KD - depth);
		if(prev == 0)
		{
			prev = KD - depth;
		}
		if(prev > K)
		{
			return search(prev, depth + 1);
		} else {
			return false;
		}
	}
}
