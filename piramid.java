String x1, x2;
        int k, p;
        p = 10;
        for (int e = 0; e < p; e++) {
            x1 = "";
            for (k = e + 1; k < p; k++) x1 = x1 + " ";
            x2 = "";
            for (int n = p - e; n <= p; n++) x2 = x2 + "#";
            System.out.println(x1 + x2 + " " + x2 + x1);
        }

		
		

import java.util.Scanner;

public class Temperature {
	public static void main (String[] args) {
		Scanner s = new Scanner(System.in);
		double name = s.nextDouble();
		double result = ((name * 9) / 5) + 32;
		System.out.println(result + "F");
	}
}
