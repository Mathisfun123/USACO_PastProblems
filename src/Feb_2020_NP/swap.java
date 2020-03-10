package Feb_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class swap {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Time.swap" + ".in"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] x= new int[n];
		for(int i = 0; i< n; i++){
			x[i] = i;
		}
		Pair[] pairs = new Pair[m];
		for(int i = 0; i< m; i++){
			pairs[i]= new Pair(sc.nextInt()-1,sc.nextInt()-1);
			swapper(x, pairs[i].a, pairs[i].b);
		}
		PrintWriter out = new PrintWriter(new File("Time.swap.out"));
		for(int i = 0; i< n; i++){
			if(x[i]==i){
				out.println(i+1);
			}else{
				int val = x[i];
				for(int j = 1;j< k; j++ ){
					val = x[val];
				}
				out.println(val+1);
			}
		}

		out.close();
	}
	public static int[] swapper(int arr[], int start, int end){
		int temp = 0;
		for(int b = start; b<= (end-start)/2+1; b ++){
			temp = arr[b];
			arr[b]= arr[end-(b-start)];
			arr[end-(b-start)] = temp;
		}
		return arr;
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