package CurrentlyWorking;//Training Page: 1.4 Prime Crypt - Trial 1
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class crypt1 {
	static Set<Integer> s;
	static Set<String> p;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("CurrentlyWorking.crypt1" + ".in"));
		int n = sc.nextInt();
		int[] arr = new int[n];
		s = new HashSet<>();
		p = new HashSet<>();
		for(int i = 0; i< n; i++){
			arr[i]= sc.nextInt();
			s.add(arr[i]);
			p.add(Integer.toString(arr[i]));
		}
		for(int i = 100; i<1000; i++){
			for(int j = 10; j<100; j++){
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
					if(top3<10 && bot3 <10 && s.contains(top1) && s.contains(top2) && s.contains(top3) && s.contains(bot1) && s.contains( bot2) && s.contains( bot3)){
						//now checking final sum
						int r2 = (top2 + bot1) %10;
						int r3=  (top3 + bot1) % 10 + (top2 + bot1) /10;
						int r4 = bot3 +  (top3 + bot1) / 10;
						if(r4< 10 && s.contains(top1) && s.contains(r2) && s.contains(r3) && s.contains(r4)){
							System.out.println(i + " " + j + " : " +r4+r3+r2+top1 );
						}
					}


				}
			}
		}
		System.out.println(p);
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
