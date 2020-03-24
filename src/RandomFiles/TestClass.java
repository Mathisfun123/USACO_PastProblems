package RandomFiles;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestClass {

	public static void main(String[] args) throws FileNotFoundException {
		Hi[] arr = new Hi[3];
		for(int i= 0; i<3; i++){
			arr[i] = new Hi(2*i+1,2*i+2);
		}
		arr[1].combine(arr[0]); arr[0] = arr[1];
		arr[2].combine(arr[0]); arr[0]= arr[2];
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);







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
	static class Hi{
		public int a, b;
		public Hi(int a1, int b1){
			a = a1; b = b1;
		}
		public void combine(Hi p){
			a = Math.min(a,p.a);
			b = Math.max(b, p.b);
		}

	@Override
	public String toString() {
		return "Hi{" +
				"a=" + a +
				", b=" + b +
				'}';
	}
}
}
