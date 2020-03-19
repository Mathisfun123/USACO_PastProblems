package RandomFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestClass {

	public static void main(String[] args) throws FileNotFoundException {
		String s = "a70 and z72 will be replaced, but aa24 and a872 will not";
		s= s.replaceAll("[a-z][0-9][0-9][ ]","*** ");
		System.out.println(s);

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
