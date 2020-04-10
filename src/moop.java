import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class moop {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("moop" + ".in"));
		int n = sc.nextInt();
		Pair arr[] = new Pair[n];
		for(int i = 0; i< n; i++){
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		}
		Arrays.sort(arr);
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
	}
}
