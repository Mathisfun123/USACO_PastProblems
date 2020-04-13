package Mar_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class moop {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Mar_2020_NP.moop" + ".in"));
		int n = sc.nextInt();
		Pair arr[] = new Pair[n];
		for(int i = 0; i< n; i++){
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
		int[] prefixMin = new int[n];
		//min goes rightward
		prefixMin[0] = arr[0].y;
		for(int i = 1; i< n; i++){
			prefixMin[i] = Math.min(prefixMin[i-1], arr[i].y);
		}
		int [] prefixMax = new int[n];
		//max goes leftward
		prefixMax[n-1]= arr[n-1].y;
		for(int i = n-2; i>=0; i--){
			prefixMax[i]= Math.max(prefixMax[i+1], arr[i].y);
		}
//		System.out.println(Arrays.toString(prefixMin));
//		System.out.println(Arrays.toString(prefixMax));
		int count = 1;
		for(int i = 0; i<n-1; i++){
			if(prefixMin[i]>prefixMax[i+1]){
				count++;
			}
		}
		PrintWriter out = new PrintWriter(new File("Mar_2020_NP.moop.out"));
		out.println(count);
		out.close();

	}
	static class Pair implements Comparable{
		int x, y;
		public Pair(int a, int b){
			x = a; y = b;
		}

		@Override //default compareTo, sort based on x first then y
		public int compareTo(Object o) {
			Pair p = (Pair)o;
			if(x==p.x){
				return y-p.y;
			}else{
				return x-p.x;
			}
		}

		@Override
		public String toString() {
			return "Pair{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
}
