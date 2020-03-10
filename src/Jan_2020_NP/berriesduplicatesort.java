package Jan_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class berriesduplicatesort {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Jan_2020_NP.berries" + ".in"));
		int n = sc.nextInt();
		int k = sc.nextInt();
		ArrayList<Integer> berries = new ArrayList<>();
		for(int i = 0;i< n;i++){
			berries.add(sc.nextInt());
		}
		Collections.sort(berries);
		int leftmarker= n-k;
		while(berries.get(n-1)/2> berries.get(leftmarker)){
			int val = berries.remove(n-1)/2;
			//time to binary search where to place the element
			int first = leftmarker;
			int last = berries.size()-1;
			while(last-first!=1){
				int mid = (first+last)/2;
				if (berries.get(mid) < val) {
					first = mid;
				} else if (berries.get(mid) > val) {
					last = mid;
				}else{
					last= mid;
				}
			}
			berries.add(last,val);
			berries.add(last,val);
//			System.out.println(Jan_2020_NP.berries);
		}
		leftmarker= berries.size()-k;
		int sum = 0;
		for(int i = leftmarker; i<leftmarker+k/2; i++){
			sum+= berries.get(i);
		}
		System.out.println(berries);
		PrintWriter out = new PrintWriter(new File("Jan_2020_NP.berries.out"));
		out.println(sum);
		out.close();


	}
}
