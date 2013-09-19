import java.io.*;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Started 9/19/2013
 * Finished 9/19/2013
 * @author Kevin
 *
 */
public class p1045
{
	public static void main(String args[]) throws Exception
	{
		Scanner cin=new Scanner(System.in);
		double vs = cin.nextDouble();
		double r = cin.nextDouble();
		double c = cin.nextDouble();
		int n = cin.nextInt();
		
		for(int i = 1; i <= n; i++)
		{
			double w = cin.nextDouble();
			double vr = r*c*w*vs*Math.sqrt(1/(r*r*c*c*w*w + 1));
			DecimalFormat df = new DecimalFormat("0.000");
			System.out.println(df.format(vr));
		}
	}
}