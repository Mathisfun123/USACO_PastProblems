package RandomFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class triangles {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("CurrentlyWorking.triangles" + ".in"));
		int n = sc.nextInt();
		HashMap<Integer, ArrayList<Integer>> XVals = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> YVals = new HashMap<>();
		int []xvlas = new int[n];
		int []yvls = new int[n];
		for(int i = 0; i< n; i++){
			xvlas[i]= sc.nextInt();
			yvls[i] = sc.nextInt();
			if(XVals.containsKey(xvlas[i])){
				ArrayList<Integer> t = XVals.get(xvlas[i]);
				t.add(i);
			}else{
				ArrayList<Integer> t = new ArrayList<>();
				t.add(i);
				XVals.put(xvlas[i],t);
			}
			if(YVals.containsKey(yvls[i])){
				ArrayList<Integer> t = YVals.get(yvls[i]);
				t.add(i);
			}else{
				ArrayList<Integer> t = new ArrayList<>();
				t.add(i);
				YVals.put(yvls[i],t);
			}
		}
		int maxarea = -1;

		for(int i = 0; i< n; i++){
			//choosing this point as the right vertex
			//see if there is a common x value
			ArrayList<Integer> commonx = new ArrayList<>(XVals.get(xvlas[i]));
			ArrayList<Integer> commony = new ArrayList<>(YVals.get(yvls[i]));
			commonx.remove(new Integer(i));
			commony.remove(new Integer(i));
			if(commonx.size()>0 && commony.size()>0) {

				for (int p = 0; p < commonx.size(); p++) {
					for (int l = 0; l < commony.size(); l++) {
//						System.out.println("hello" + Math.abs(yvls[commonx.get(p)]) + " " + yvls[i]);
//						System.out.println("hello2" + Math.abs(xvlas[commony.get(l)] * xvlas[i]));
						maxarea = Math.max(maxarea, Math.abs(yvls[commonx.get(p)] - yvls[i]) * Math.abs(xvlas[commony.get(l)] - xvlas[i]));
					}
				}
			}
//			System.out.println(i+ " " + commonx);
//			System.out.println(i + " "+ commony);

		}

//		System.out.println(XVals);
//		System.out.println(YVals);
		System.out.println(maxarea);
	}
}
