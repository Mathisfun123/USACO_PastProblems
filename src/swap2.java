import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
//carbon copy of usaco sol to see if time issue in java
public class swap2{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc= new Scanner(new File("swap.in"));
		int n = sc.nextInt(); int m = sc.nextInt(); int k = sc.nextInt();
		int[] l = new int[m]; int [] r = new int[m];
		for(int i = 0; i< m; i++){
			l[i] = sc.nextInt()-1; r[i] = sc.nextInt()-1;
		}
		int[] p = new int[n];
		for(int i = 0; i< n; i++){
			p[i]= i;
			for(int j= 0; j< m; j++){
				if(p[i]>=l[j] && p[i]<= r[j]){
					p[i]= r[j] + l[j]- p[i];
				}
			}
		}
		int C = 1;
		int[] cc = new int[n];
		ArrayList<Integer>[] A = new ArrayList[n];
		for(int i = 0; i< n; i++){
			A[i] = new ArrayList<>();
		}
		int[] pos = new int[n];
		int ans[]= new int[n];
		for(int i = 0; i< n; i++){
			if(cc[i]==0) {
				cc[i] = C;
				A[C].add(i);
				int j = p[i];
				if (j != i) {
					pos[j] = 1;
				}
				while (j != i) {
					A[C].add(j);
					cc[j] = C;
					if (p[j] != i) pos[p[j]] = 1 + pos[j];
					j = p[j];
				}
				C++;
			}
		}
		PrintWriter out = new PrintWriter(new File("swap.out"));
		for(int i=0;i<n;i++)
			ans[A[cc[i]].get((pos[i] + k)%A[cc[i]].size())] = i;
		for(int i=0;i<n;i++)
			out.println(ans[i]+1);
		out.close();;
	}
}