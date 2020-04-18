import java.io.File;
import java.util.Scanner;

public class Solution{
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int n =sc.nextInt(); sc.nextLine();
		for(int i = 0; i< n; i++){
			String[] ln = sc.nextLine().split(" "); int kids = Integer.parseInt(ln[0]); String ans = ln[1];
			for(int j = 0; j< kids; j++){
				String ln2[] = sc.nextLine().split(" ");
				double amt = 0;
				for(int k = 0; k< ans.length(); k++){
					if(ln2[1].charAt(k) == ans.charAt(k)){
						amt++;
					}
				}
				System.out.println(ln2[0] + String.format(" %.1f",(100* amt/ans.length()))+"% "+ gradeResul(100*amt/ans.length()));

			}
		}
	}
	public static String gradeResul(double val){
		if(val>=90){
			return "A";
		}else if(val>=80){
			return "B";
		}else if(val>=70){
			return "C";
		}else if(val>=60){
			return  "D";
		}else{
			return "F";
		}
	}
}