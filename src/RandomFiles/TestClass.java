package RandomFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestClass {

	public static void main(String[] args) throws FileNotFoundException {
		//time to test if two lines intersect based on endpoints
//		int x0= 0; int y0 = 0;
//		int x1= 2; int y1= 0;
//		int x2= 2; int y2 =1;
//		int x3 =2; int y3 = 2;
//		System.out.println(interesect(x0, y0, x1, y1, x2, y2, x3, y3));
		Scanner sc = new Scanner(new File("C:\\Users\\saiku\\IdeaProjects\\CodeIn\\berries.in"));
		int a = sc.nextInt();
		String b = sc.nextLine();
		System.out.println(a+b);

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
	public static int interesect(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3){
		double s1x = x1-x0; double s1y = y1 - y0;
		double s2x = x3-x2; double s2y = y3 - y2;
		double s =  (-s1y * (x0 - x2) + s1x * (y0 - y2)) / (-s2x * s1y + s1x * s2y);
		double t = ( s2x * (y0 - y2) - s2y * (x0 - x2)) / (-s2x * s1y + s1x * s2y);
		if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
		{

			return 1;
		}

		return 0; // No collision
	}
//	public static boolean digitsInS(int num){
//		String string = Integer.toString(num);
//		for(int i = 0; i< string.length(); i++){
//			if(!p.contains(string.substring(i, i+1))){
//				return false;
//			}
//		}
//		return true;
//	}
}
