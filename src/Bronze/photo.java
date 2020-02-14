package Bronze;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
//Bronze Dec 2019 #2
public class photo {
	static int n;
	static boolean var = false;
	static int sums [];
	static PrintWriter out;
	public static void main(String[] args) throws FileNotFoundException {
		//reading data
		Scanner sc = new Scanner(new File("photo.in"));
		n = sc.nextInt();
		sums= new int[n];
		for(int i = 0; i< n-1; i ++){
			sums[i]= sc.nextInt();
		}
		//start of actual code
		int pos = 0;
		out = new PrintWriter(new File("photo.out"));
		//psuedo dfs (try all solutions)
		for(int i = 1; i <=n; i++){
			boolean used[] = new boolean[n];
			recur(i, used, pos, new LinkedList<Integer>());
		}
		out.close();

	}
	public static void recur ( int test, boolean [] used,int pos, LinkedList<Integer>list){
		//something to keep in mind: check for condition of
		if(pos == 0 ){
			used[test-1]= true;
			if(!(sums[pos]-test<1)&& (sums[pos]-test-1<n) && !used[sums[pos]-test-1]) {
				list.add(test);
				recur(sums[pos] - test, used, pos + 1, list );
			}
		}else {
			// pos!= n (final case when solve as pos = n -1)
			//!var makes sure not solved already (first solution best)
			if(pos!=n-1 && !var){
				if((sums[pos]-test)>0 && test-1< n&& !used[test-1]){
					used[test-1] = true;
					list.add( test);
					recur(sums[pos]-test, used, pos+1, list);

				}
			}else{
				if(test>1&&test-1< n && !used[test-1] && !var){
					for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
						Integer next =  iterator.next();
						out.print(next+ " ");
					}
					out.println(test);
					var = true;
				}
			}

		}
	}
}
