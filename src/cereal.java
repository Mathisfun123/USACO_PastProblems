//underestimated the efficiency of the dropping and adding --> thought recursive O(n^2)
// should have just attempted it as it

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class cereal{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("cereal.in"));
		int n = sc.nextInt(); int m = sc.nextInt();
		Cow[] positions = new Cow[m];
		Cow[] cowwantings = new Cow[n];
		int[] ans = new int[n];
		for(int i = 0; i< n; i++){
			cowwantings[i] = new Cow(sc.nextInt() -1, sc.nextInt()-1, i);
		}
		//stimulate the n-1 cow --> gets first choice
		positions[cowwantings[n-1].firstChoice]= cowwantings[n-1];
		int val = 1;  		ans[n-1]= val;
		for(int i = n-2; i>=0; i--){
			//include this cow now
			if(positions[cowwantings[i].firstChoice]!=null){
				//need to swap --new cow always first priority
				Cow cowAtPos = positions[cowwantings[i].firstChoice];
				boolean canwork = true;
				//finding place for the cow at the old spot
				while(cowAtPos!=null && canwork){
					if(positions[cowAtPos.secondChoice]==null){
						positions[cowAtPos.secondChoice] = cowAtPos;
						cowAtPos=null;
//						if(val==87){
//							System.out.println(Arrays.toString(positions));
//						}
						val++;
					}else{
						if(positions[cowAtPos.secondChoice].i_val>cowAtPos.i_val){
							Cow temp  = positions[cowAtPos.secondChoice];
							positions[cowAtPos.secondChoice] = cowAtPos;
							cowAtPos= temp;
						}else{
							canwork=false;
						}
					}
				}

				positions[cowwantings[i].firstChoice] = cowwantings[i];
				ans[i]= val;
			}else{
				positions[cowwantings[i].firstChoice]= cowwantings[i];
				val++;
				ans[i]= val;
			}
		}
		PrintWriter out = new PrintWriter(new File("cereal.out"));
		for(int i = 0; i< n; i++){
			out.println(ans[i]);
		}
		out.close();

	}
	static class Cow{
		int firstChoice, secondChoice, i_val;
		public Cow(int x, int y, int z){
			firstChoice= x; secondChoice= y; i_val=z;
		}

		@Override
		public String toString() {
			return "Cow{" +
					"firstChoice=" + firstChoice +
					", secondChoice=" + secondChoice +
					", i_val=" + i_val +
					'}';
		}
	}
}