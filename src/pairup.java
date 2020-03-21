import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//fell for brute force method needed to read solution manual to tell why 11/12 test cases
//heavy emphasis on duplicates as special part
public class pairup {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("pairup" + ".in"));
		int n = sc.nextInt();
		ArrayList<Pair> values = new ArrayList<>(n);
		for(int i = 0; i< n; i++){
			values.add(new Pair(sc.nextInt(), sc.nextInt()));
		}
		Collections.sort(values);

		//ACTUAL CODE
		int i =0; int j = values.size()-1;
		int m = Integer.MIN_VALUE;
		while(i<= j){
			//looking at minimum pair and maximum pair
			Pair max = values.get(j);
			Pair min = values.get(i);
			m = Math.max(m, max.y+min.y);
			//now check if a Pair still remains in the list(not actually removing but just adjusting indices)
			if(max.x>min.x){
				//moving on the next minimum
				max.x-=min.x;
				min.x=0;
				i++;
			}else if(max.x==min.x){
				i++;
				j--;
			}else{
				min.x-=max.x;
				max.x=0;
				j--;
			}
		}
		PrintWriter out = new PrintWriter(new File("pairup.out"));
		out.println(m);
		out.close();

	}
	static class Pair implements Comparable{
		int x;
		int y;
		public Pair(int xin, int yin){
			x = xin;
			y = yin;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair) o;
			return y- p.y;
		}

		@Override
		public String toString() {
			return "{" +
					"x=" + x +
					", y=" + y +
					'}';
		}
	}
}
