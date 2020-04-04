import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class cereal {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("cereal" + ".in"));
		int n = sc.nextInt(); int m = sc.nextInt();
		Pair [] arr = new Pair[n];
		for(int i = 0; i< n; i++){
			arr[i]= new Pair(sc.nextInt()-1, sc.nextInt()-1);
		}
		PrintWriter out = new PrintWriter(new File("cereal.out"));
		for(int i = 0; i< n; i++){
			int bye = 0;
			boolean [] vistied = new boolean[m];
			for(int j =i; j< n; j++){
				if(!vistied[arr[i].a]){
					vistied[arr[i].a]= true;
				}else if(!vistied[arr[i].b]){
					vistied[arr[i].b] = true;
				}else{
					bye++;
				}
			}
			out.println(n-i-bye);
		}
		out.close();
	}
	static class Pair{
		int a, b;
		public Pair(int x, int y){
			a = x; b = y;
		}
	}
}
