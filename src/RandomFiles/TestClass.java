package RandomFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestClass {
	static Set<Integer> s;
	static Set<String> p;
	public static void main(String[] args) throws FileNotFoundException {
		int i = 222;
		int j = 62;
		s= new HashSet<>();
		p = new HashSet<>();
		s.add(2); s.add(3);  s.add(4);  s.add(6);  s.add(8);
		p.add("2"); p.add("3"); p.add("4"); p.add("6"); p.add("8");
		if(digitsInS(i) && digitsInS(j)){
			//first digit: %10, second %100 /10
			int iindex1 = i%10; int iindex2 = (i%100)/10; int iindex3 = (i/100);
			int jindex1 = j%10; int jindex2 = (j%100)/10;
			int top1 = iindex1 * jindex1 %10;
			int top2 = iindex2 * jindex1 %10 + iindex1 * jindex1 /10;
			int top3 = iindex3 * jindex1 %10 + iindex2 * jindex1 /10;
			int bot1 = iindex1 * jindex2 %10;
			int bot2 = iindex2 * jindex2 %10 + iindex1 * jindex2 /10;
			int bot3 = iindex3 * jindex2 %10 + iindex2 * jindex2 /10;
			System.out.println(top3+" "+  top2+" "+  top1);
			System.out.println(bot3+" "+  bot2+" "+  bot1);
			if(top3<10 && bot3 <10 && s.contains(top1) && s.contains(top2) && s.contains(top3) && s.contains(bot1) && s.contains( bot2) && s.contains( bot3)){
				//now checking final sum
				int r2 = (top2 + bot1) %10;
				int r3=  (top3 + bot1) % 10 + (top2 + bot1) /10;
				int r4 = bot3 +  (top3 + bot1) / 10;
				System.out.println(top1 + " " + r2 + " "+  r3 + " " + r4);
				if(r4< 10 && s.contains(top1) && s.contains(r2) && s.contains(r3) && s.contains(r4)){
					System.out.println(i + " " + j);
				}
			}


		}

	}
	public static int[] reverse(int arr[], int l, int r){
		int temp = 0;
		for(int b = l; b<= (r-l)/2+1; b ++){
			temp = arr[b];
			arr[b]= arr[r-(b-l)];
			arr[r-(b-l)] = temp;
		}
		return arr;
	}
	public static boolean digitsInS(int num){
		String string = Integer.toString(num);
		for(int i = 0; i< string.length(); i++){
			if(!p.contains(string.substring(i, i+1))){
				return false;
			}
		}
		return true;
	}
}
