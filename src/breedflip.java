import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class breedflip {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("breedflip.in"));
		int n = sc.nextInt(); sc.nextLine();
		String a = sc.nextLine();
		String b = sc.nextLine();
		ArrayList<Integer> changesneeded= new ArrayList<>();
		for(int i = 0; i< n; i++){
			if(!(a.substring(i,i+1).equals(b.substring(i,i+1)))){
				changesneeded.add(i);
			}
		}
//		System.out.println(changesneeded);
		int ans = changesneeded.size();
		for(int i = 0; i< changesneeded.size()-1; i++){
			if(changesneeded.get(i)==changesneeded.get(i+1)-1){
				ans--;
			}
		}
//		System.out.println(g);
//		System.out.println(h);
//		int ans = g.size() + h.size();
//		for(int i = 0; i< g.size()-1; i++){
//			if(g.get(i)== g.get(i+1) -1){
//				ans--;
//			}
//		}
//		for(int i = 0; i< h.size()-1; i++){
//			if(h.get(i)== h.get(i+1) -1){
//				ans--;
//			}
//		}
//		int numTimes = 0;
//		for(int i = 0; i <g.size()-1; i++){
//			while(g.get(i) == (g.get(i+1)-1)){
//				i++;
//			}
//			numTimes++;
//		}
//		for(int i = 0; i <h.size()-1; i++){
//			while(h.get(i) == (h.get(i+1)-1)){
//				i++;
//			}
//			numTimes++;
//		}
		PrintWriter out = new PrintWriter(new File("breedflip.out"));
		out.println(ans);
		out.close();
	}
}
