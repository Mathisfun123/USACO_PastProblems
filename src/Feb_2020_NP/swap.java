package Feb_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class swap {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("swap" + ".in"));
		int n = sc.nextInt(); int m = sc.nextInt(); int k = sc.nextInt();
		int directTo [] =new int[n];
		for(int i = 0; i< n; i++){
			directTo[i]=i;
		}
		for(int i = 0; i< m; i++){
			int pos1 = sc.nextInt()-1;
			int pos2 = sc.nextInt()-1;
		}
	}
}