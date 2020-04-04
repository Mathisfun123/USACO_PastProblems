import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.management.MonitorInfo;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class socdist {
	public static Pair[] paris;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("socdist" + ".in"));
		int n = sc.nextInt(); int m = sc.nextInt();
		long min = Long.MAX_VALUE; long max = Long.MIN_VALUE;
		 paris = new Pair[m];
		for(int i = 0; i< m; i++){
			long a = sc.nextLong();
			long b = sc.nextLong();
			min = Math.min(min, a); max = Math.max( max, b);
			paris[i]= new Pair(a, b);
		}
		Arrays.sort(paris);
		long maxdiff = (max-min)/(n-1); long mindist = 1;
		while(mindist<maxdiff){
			long mid = (int)((maxdiff +mindist)/2);
			if(works(mid,n,m)){
				mindist= mid;
			}else{
				maxdiff= mid-1;
			}
		}




		PrintWriter out = new PrintWriter(new File("socdist.out"));
		out.println(works(mindist+1,n,m)?mindist+1:mindist);
		out.close();
	}
	public static boolean works(long MinDist, int n, int m){
		//using this as the min distance means we have to move continuously to the right
		int whichCow = 1; //set left as first cow "0"
		long pos = paris[0].a;  long maxDist = paris[m-1].b;
		int currentPair = 0;

		while(whichCow<=n && pos<maxDist){
			pos = pos+ MinDist;
			if(paris[currentPair].contains(pos)){
				whichCow++;
			}else{
				//past that interval so need to move on
				while(currentPair<m && !paris[currentPair].contains(pos)){
					if(paris[currentPair].a >= pos){
						pos = paris[currentPair].a;
						whichCow++;
					}else{
						currentPair++;
					}

					//System.out.println("hello " +MinDist+ ' ' + currentPair + " " + pos + " " + whichCow  + paris[currentPair].contains(pos));
				}
			}
		}

		return whichCow == n - 1;

	}
	static class Pair implements Comparable{
		long a,  b;
		public Pair(long x, long y){
			a =x; b = y;
		}

		@Override
		public int compareTo(Object o) {
			return (int) (a- ((Pair)o).a);
		}
		public boolean contains(long val){
			return val>=a && val<=b;
		}
	}
}
