
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class swap {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("swap" + ".in"));
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
//		System.out.println(Arrays.toString(x));
		PrintWriter out = new PrintWriter(new File("swap.out"));
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
	public static void swapper(int arr[], int start, int end){
		int temp = 0;
		while(start< end){
			temp = arr[start];
			arr[start]= arr[end];
			arr[end]= temp;
			start++;
			end--;
		}
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
