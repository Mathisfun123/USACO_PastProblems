import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kattis {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); sc.nextLine();
		String s = null;
		boolean increasing = true;
		boolean decreasing = true;
		boolean works = true;
		for(int i = 0; i< n; i++){
			if(i==0){
				s = sc.nextLine();
			}else if(i==1){
				if(sc.nextLine().compareTo(s)>0){
					decreasing=false;
				}else{
					increasing = false;
				}
			}else if(works){
				if(increasing){
					if(sc.nextLine().compareTo(s)<0){
						works= false;
					}
				}else{
					if(sc.nextLine().compareTo(s)>0){
						works=false;
					}
				}
			}
		}
		System.out.println(works?(increasing?"INCREASING":"DECREASING"):"NEITHER");
	}
}
