package Feb_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class clocktree {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Feb_2020NP.clocktree" + ".in"));
		int n  =sc.nextInt();
		int clocks [] = new int[n];
		int counteven = 0;
		for(int i = 0; i< n; i++){
			clocks[i] = sc.nextInt();
			counteven+= clocks[i]%2==0?1:0;
		}
		PrintWriter out = new PrintWriter(new File("Feb_2020NP.clocktree.out"));
		out.print((int)(Math.random()*(counteven+1)));
		out.close();
	}
}
