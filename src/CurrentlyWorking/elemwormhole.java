package CurrentlyWorking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class elemwormhole {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("wormhole" + ".in"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		boolean in_correctpos [] = new boolean[n];
		ArrayList<Integer> needtoportal = new ArrayList<>();
		for(int i = 0; i< n; i++){
			arr[i]= sc.nextInt();
			if(arr[i]-1 ==i){
				in_correctpos[i]=true;
			}
			if(!in_correctpos[i]){
				needtoportal.add(i+1);
			}
		}

		for(int i =0; i< m; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int weight = sc.nextInt();
		}
		HashMap<Integer, TreeSet<Integer>> wormholelinks = new HashMap<>();



		//want to use wormholes as large as we can and see if we can reach all the incorrect spots with that
		System.out.println(Arrays.toString(in_correctpos));



	}
	static class wormhole implements Comparable{
		public int weight;
		public int a;
		public int b;

		@Override
		public int compareTo(Object o) {
			return -(this.weight)+ ((wormhole)(o)).weight;
		}

		@Override
		public String toString() {
			return "wormhole{" +
					"weight=" + weight +
					", a=" + a +
					", b=" + b +
					'}';
		}
	}
}
