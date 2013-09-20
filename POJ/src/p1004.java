import java.text.DecimalFormat;
import java.util.Scanner;


public class p1004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		double mean = 0;
		for(int i = 0; i < 12; i++)
		{
			mean += scanner.nextDouble()/12;
		}
		DecimalFormat df = new DecimalFormat("0.00");
		System.out.println("$" + df.format(mean));
	}

}
