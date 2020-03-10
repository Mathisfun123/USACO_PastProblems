package Feb_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class swap2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Time.swap" + ".in"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] x= new int[n];
		for(int i = 0; i< n; i++){
			x[i] = i;
		}
		Pair[] pairs= new Pair[m];
		for(int i = 0; i< m; i++){
			pairs[i] =new Pair(sc.nextInt(),sc.nextInt());
		}
		HashMap<Integer,Integer> swaps = new HashMap<>();
		for(int i = 0; i< k; i++){
			for(int j = 0; j< m; j++){
				HashMap<Integer, Integer> temp = new HashMap<>(swaps);
				int l = pairs[j].a;
				int r = pairs[j].b;
				for(int b = l; b<= r; b++){
					if(swaps.containsKey(b)){
						temp.put(swaps.get(b),r-b+l);
					}else{
						temp.put(b, r-b+l);
					}
				}
				swaps = new HashMap<>(temp);
			}
		}
		System.out.println(swaps);


	}
	public static class Pair{
		public int a;
		public int b;
		public Pair(int a, int b){
			this.a= a;
			this.b = b;
		}
	}
}
