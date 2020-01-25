import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
//Bronze Dec 19 #1
public class gymnastics {
	public static void main(String[] args) throws FileNotFoundException {
		//Storing Input
		Scanner sc = new Scanner(new File("gymnastics" + ".in"));
		PrintWriter out = new PrintWriter(new File("gymnastics.out"));
		int k = sc.nextInt();
		int n = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[k][n];
		for(int i = 0; i< k; i++){
			for(int j = 0; j< n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		//N*N-1 number of times the loop will run --> O(N^2) at best
		//Good enough for Bronze
		int numtimes = 0;
		for(int first= 1; first<= n; first++){
			for(int second = 1; second<=n; second++){
				if(first!=second) {
					if(checkiffirstbetterthansecond(arr,first,second,k,n)){
						numtimes++;
					}
				}
			}
		}
		out.println(numtimes);
		out.close();
	}

	public static boolean checkiffirstbetterthansecond(int [][] arr, int first, int second,int k, int n){
		int counter = 0;
		for(int i = 0; i< k; i++){
			int posfir = -1;
			int possec = -1;
			for(int j = 0; j< n; j++){
				if(arr[i][j]==first){
					posfir=j;
				}else if(arr[i][j]==second){
					possec=j;
				}
			}
			if(posfir<possec){
				counter++;
			}
		}
		//has to match condition all the rows
		return counter==k;
	}
}
