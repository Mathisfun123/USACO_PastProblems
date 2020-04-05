import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class socdist{
	static Pair[] pairs;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("socdist.in"));
		int n = sc.nextInt(); int m = sc.nextInt();
		pairs = new Pair[m];
		long lowgrass = Integer.MAX_VALUE; long highgrass = Integer.MIN_VALUE;
		for(int i = 0; i< m; i++){
			long a = sc.nextInt();
			long b = sc.nextInt(); long c = Math.min(a,b); b = Math.max(a,b);
			pairs[i] = new Pair(c,b);
			if(c< lowgrass){
				lowgrass= c;
			}
			if(b> highgrass){
				highgrass= b;
			}
		}
		Arrays.sort(pairs);
		int lowGuess= 1; int highGuess = (int) ((highgrass-lowgrass)/(n-1));
		while(highGuess-lowGuess>1){
			int mid = (lowGuess+highGuess)/2;
			if(works(mid,n,m)){
				lowGuess= mid;
			}else{
				highGuess= mid -1;
			}
		}
		PrintWriter out = new PrintWriter(new File("socdist.out"));

		if(works(highGuess,n,m)){
			out.println(highGuess);
		}else{
			out.println(lowGuess);
		}
		out.close();;

	}
	static class Pair implements Comparable{
		long a,  b;
		public Pair(long v1, long v2){
			a = v1; b = v2;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair)o;
			return (int)(a- p.a);
		}
		public boolean contains(long val){
			return val >= a && val <= b;
		}
	}
	public static boolean works(int D, int n, int m){
		long poss = pairs[0].a + D;
		int cowNum = 1; int pairNumber = 0;
		while(cowNum< n && pairNumber<m) {
			if(pairs[pairNumber].contains(poss)){
				cowNum++; poss+= D;
			}else {
				while (pairNumber < m && !pairs[pairNumber].contains(poss)) {
					if (pairs[pairNumber].a > poss) {
						poss = pairs[pairNumber].a + D;
						cowNum++; break;
					}else{
						pairNumber++;
					}
				}
			}
		}
		return cowNum==n;
	}
}