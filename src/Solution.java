import java.io.*;
import java.lang.reflect.Array;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {

	// Complete the journeyToMoon function below.
	static int journeyToMoon(int n, int[][] astronaut) {
		//dfs approach
		boolean[] visited = new boolean[n];
		ArrayList<Long>[] connections = new ArrayList[n];
		for(int i = 0; i< n; i++){
			connections[i]= new ArrayList<Long>();
		}
		for(int i = 0; i< astronaut.length; i++){
			connections[astronaut[i][0]].add((long) astronaut[i][1]);
			connections[astronaut[i][1]].add((long) astronaut[i][0]);
		}//adding connections (no care about intermediate connections)
		long sum= 0;
		for(long i = 0; i< n; i++){
			if(!visited[(int) i]){
				Queue<Long> dfsgrouper = new LinkedList<>();
				dfsgrouper.add(i); HashSet<Long> uniqueSpots = new HashSet<>();
				while(!dfsgrouper.isEmpty()){
					Long p = dfsgrouper.poll();
					if(!visited[(int) i]){
						uniqueSpots.add(p);
						dfsgrouper.addAll(connections[Math.toIntExact(p)]);
						visited[Math.toIntExact(p)]= true;
					}
				}
				sum += ((long) uniqueSpots.size() * (n - uniqueSpots.size()));
			}
		}
		return (int)sum/2;

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

			for (int j = 0; j < 2; j++) {
				int astronautItem = Integer.parseInt(astronautRowItems[j]);
				astronaut[i][j] = astronautItem;
			}
		}

		int result = journeyToMoon(n, astronaut);
		System.out.println(result);


		scanner.close();
	}
}
