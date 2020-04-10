import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

	// Complete the journeyToMoon function below.
	static int journeyToMoon(int n, int[][] astronaut) {
		HashMap<Integer, Integer> t = new HashMap<>();
		int uniqueCountry = 0;

		for(int i = 0; i<n; i++){
			//simulating these people?
			t.put(i, i);
		}
		for (int[] twoEleme : astronaut) {
			t.replace(twoEleme[0], Math.min(twoEleme[0], twoEleme[1]));
			t.replace(twoEleme[1], Math.min(twoEleme[0], twoEleme[1]));
		}
		HashMap<Integer, ArrayList<Integer>> vals= new HashMap<>();
		for(int k: t.keySet()){
			if(vals.containsKey(t.get(k))){
				ArrayList<Integer> mp = vals.get(t.get(k));
				mp.add(k);
			}else{
				ArrayList<Integer> mp = new ArrayList<>();
				mp.add(k);
				vals.put(t.get(k),mp);
			}
		}
		int valans[] = new int[vals.keySet().size()];
		int i = 0;
		for(int k: vals.keySet()){
			valans[i] = vals.get(k).size();
			i++;
		}
		long combos = 0 ;
		for(int p = 0; p< valans.length-1; p++){
			for(int pk = p+1; pk< valans.length; pk++){
				combos+= (long) valans[p] * valans[pk];
			}
		}
		return (int)combos;

	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {


		String[] np = scanner.nextLine().split(" ");

		int n = Integer.parseInt(np[0]);

		int p = Integer.parseInt(np[1]);

		int[][] astronaut = new int[p][2];

		for (int i = 0; i < p; i++) {
			String[] astronautRowItems = scanner.nextLine().split(" ");

			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("hello");
			for (int j = 0; j < 2; j++) {
				int astronautItem = Integer.parseInt(astronautRowItems[j]);
				astronaut[i][j] = astronautItem;
			}
		}

		int result = journeyToMoon(n, astronaut);



		scanner.close();
	}
}
