import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class swap {
	static int[] redirect;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("swap" + ".in"));
		int n = sc.nextInt(); int m = sc.nextInt(); int k = sc.nextInt();
		redirect = new int[n];
		for(int i = 0; i< n; i++){
			redirect[i]= i;
		}
		for(int i = 0; i< m; i++){
			int a = sc.nextInt()-1;
			int b = sc.nextInt()-1;
			reverse(a, b);
		}
		Val[] cyclecount = new Val[n];
		for(int i = 0; i< n; i++){
			cyclecount[i] = new Val(i);
			cyclecount[i].vals.add(redirect[i]);
		}
		for(int i = 0; i< n; i++){
			if(redirect[i]==i){
				cyclecount[i].cycleCount= 1;
				System.out.println(i);
			}else{
				int pos = redirect[i]; boolean met  = false;
				for(int j = 1; j< k && !met; j++){
					if(redirect[pos] == i){
						cyclecount[i].add(i); cyclecount[i].cycleCount= j+1;
						met = true;
					}else{
						pos = redirect[pos];
						cyclecount[i].add(pos);
					}
				}
			}
		}
		PrintWriter out = new PrintWriter(new File("swap.out"));
		for(int i = 0; i< n; i++){
			if(cyclecount[i].cycleCount!=Integer.MAX_VALUE){
				int pos = k %cyclecount[i].cycleCount;
				out.println(cyclecount[i].vals.get(pos)+1);
			}else{
				out.println(cyclecount[i].vals.get(cyclecount[i].vals.size()-1)+1);
			}
		}
		out.close();;
//		System.out.println(redirect[82]);
//		System.out.println(Arrays.toString(redirect));
//		System.out.println(Arrays.toString(cyclecount));
	}
	public static void reverse(int a, int b){
		for(int i = 0; i< Math.ceil(b-(a*1.0))/2 ; i++){
			int temp = redirect[i+a];
			redirect[i+a]= redirect[b-i];
			redirect[b-i] = temp;
		}
	}
	public static class Val{
		int cycleCount;
		ArrayList<Integer> vals;
		public Val(int a){
			vals = new ArrayList<>();
			vals.add(a);
			cycleCount= Integer.MAX_VALUE;
		}
		public void add(int a){
			vals.add(a);
		}

		@Override
		public String toString() {
			return "Val{" +
					"cycleCount=" + cycleCount +
					", vals=" + vals +
					'}';
		}
	}
}