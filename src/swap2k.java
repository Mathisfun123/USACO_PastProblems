import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class swap2k {
	static int[] redirect;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("swap" + ".in"));
		PrintWriter out = new PrintWriter(new File("swap.out"));
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
		int [] valuest = new int[k+1];
		for(int i = 0; i< n; i++){
			if(redirect[i]==i){
				out.println(i+1);
			}else{
				valuest[0]= i; valuest[1]=redirect[i];
				int pos = redirect[i];
				int cycleCount = Integer.MAX_VALUE;
				boolean met = false;
				for(int j = 1; j< k && !met; j++){
					if(redirect[pos] == i){
						valuest[j+1]= (i); cycleCount= j+1;
						met = true;
					}else{
						pos = redirect[pos];
						valuest[j+1]= pos;
					}
				}
				if(cycleCount==Integer.MAX_VALUE){
					out.println(valuest[k]+1);
				}else{
					int posk = k % cycleCount;
					out.println(valuest[posk]+1);
				}
			}
		}
		out.close();

	}
	public static void reverse(int a, int b){
		for(int i = 0; i< Math.ceil(b-(a*1.0))/2 ; i++){
			int temp = redirect[i+a];
			redirect[i+a]= redirect[b-i];
			redirect[b-i] = temp;
		}
	}
}
