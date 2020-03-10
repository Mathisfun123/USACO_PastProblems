package Jan_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class berriesjavac {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Jan_2020_NP.berries" + ".in"));
		int n = sc.nextInt();
		int k = sc.nextInt();
		int maxelement = 0;
		Integer cows[] = new Integer[n];
		for(int i = 0; i< n; i++){
			cows[i]= sc.nextInt();
			maxelement= Math.max(cows[i], maxelement);
		}
		int bestcommon = 0;
		for(int i =1; i<=maxelement;i++){
			//max size of each bucket (best to make all same but sometimes not enough for all)
			int full = 0;
			//how many buckets can I create using this size buckets
			for(int j = 0; j< n;j++){
				full+= cows[j]/i; //each bucket will be separate
			}
			if(full< k/2){
				//doesn't even make elsie buckets can't work
				break;
			}
			if(full>= k){
				bestcommon = Math.max(bestcommon, (k/2)*i);
				continue;
				//enough to make buckets of all same size --> see if better than pervious solution
			}
			int modulefactor = i;

			Arrays.sort(cows, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return -(o1%modulefactor) +(o2%modulefactor);
				}
			});
			//sort smaller bucket sizes descending order
			//System.out.println(i + " " + Arrays.toString(cows));
			int current = i* (full-k/2);
			for(int p = 0; p< n && p+full<k; p++){
				current += cows[p] % i; //using smaller size buckets
			}
			bestcommon = Math.max(bestcommon,current);
		}
		PrintWriter out = new PrintWriter(new File("Jan_2020_NP.berries.out"));
		out.println(bestcommon);
		out.close();

	}
}
