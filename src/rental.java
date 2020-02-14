import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class rental {
	public static void main(String[] args) throws FileNotFoundException {
		//need to simplify on feb 14 (lol valentetine)
		//giving wrong answers for 3, 4, 5, 6, 8, 9, 10
		//simplify then see what happens
		Scanner sc = new Scanner(new File("rental" + ".in"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r =sc.nextInt();
		//read cow data (fills it in descending)
		Long[] cows = new Long[n]; for(int i = 0; i< n;i++){
			cows[i]= sc.nextLong();
		} Arrays.sort(cows, Collections.reverseOrder());
		//creates prefix array of milk that can be made (keeping one more cow each time)
		long[] prefixsum_cows = new long[n];
		prefixsum_cows[0] = cows[0];
		for(int i =1; i< n;i++){
			prefixsum_cows[i]= cows[i] + prefixsum_cows[i-1];
		}

		//assume far right cows for milking
		//left cows are for renting (useless cows)
		//middle cows are the problem

		//trying milk gaining
		MilkGiving shops[] = new MilkGiving[m]; for(int i = 0; i< m; i++){
			shops[i]= new MilkGiving(sc.nextInt(),sc.nextInt());
		} Arrays.sort(shops);
		//System.out.println(Arrays.toString(shops));
		Long renting[] = new Long[r]; for(int i = 0; i< r; i++){
			renting[i]= sc.nextLong();
		} Arrays.sort(renting,Collections.reverseOrder());
		//try with renting all and want to use bad cows
 
		long totalrenting [] = new long[r]; //sum up benefits
		totalrenting[0]= renting[0];
		for(int i = 1; i< r; i++){
			totalrenting[i]= totalrenting[i-1] + renting[i];
		}
		long maxbenefit = 0;
		//jonathan for proof:
//		System.out.println(Arrays.toString(prefixsum_cows)); // will output the milk gallons with new cows (starts with one cow to milk ([0]))
//		System.out.println(Arrays.toString(shops)); // returns the best shops (first number will actually be the price they'll buy)
//		System.out.println(Arrays.toString(totalrenting)); //outputs the benefit from renting (starts with one cow rent [0])

		//Here's where I need your help (this code should be right, right?)
		//i will denote number of cows used for renting and n-i cows are available for milking
		for(int i = 0; i<=n && i<=r; i++ ){
			long benefitifromrenting = i==0?0:totalrenting[i-1];
			long milkingbenefit =0;
			if(n!=i){
				milkingbenefit = prefixsum_cows[(n - i) - 1];
			}
			int milkingpricetotal = 0;

			for(int j = 0; j< shops.length && milkingbenefit>0; j++){
				int shopwants = shops[j].maxmilk;
				if(shopwants> milkingbenefit){
					milkingpricetotal+= milkingbenefit*shops[j].rate;
					milkingbenefit= 0;
				}else{
					milkingbenefit-= shopwants;
					milkingpricetotal+= shopwants*shops[j].rate;
				}
			}

			maxbenefit= Math.max(maxbenefit, (milkingpricetotal+benefitifromrenting));

		}
		PrintWriter out = new PrintWriter(new File ("rental.out"));
		out.println(maxbenefit);
		out.close();


	}
	public static class MilkGiving implements Comparable{
		public int maxmilk;
		public int rate;
		public MilkGiving(int max,int costper){
			maxmilk= max;
			rate = costper;
		}

		@Override
		public int compareTo(Object o) {
			return -this.rate+ ((MilkGiving)o).rate;
		}
		//flip it around(want descending)

		@Override
		public String toString() {
			return rate+ " " + maxmilk;
		}
	}
}
