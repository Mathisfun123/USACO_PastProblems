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
		ArrayList<Integer>[] connections = new ArrayList[n];
		for(int i = 0; i< n; i++){
			connections[i]= new ArrayList<Integer>();
		}
		for(int i = 0; i< astronaut.length; i++){
			connections[astronaut[i][0]].add(astronaut[i][1]);
			connections[astronaut[i][1]].add(astronaut[i][0]);
		}//adding connections (no care about intermediate connections)
		long sum= 0;
		for(int i = 0; i< n; i++){
			if(!visited[i]){
				Queue<Integer> dfsgrouper = new LinkedList<>();
				dfsgrouper.add(i); HashSet<Integer> uniqueSpots = new HashSet<>();
				while(!dfsgrouper.isEmpty()){
					Integer p = dfsgrouper.poll();
					if(!visited[p]){
						uniqueSpots.add(p);
						dfsgrouper.addAll(connections[p]);
						visited[p]= true;
					}
				}
				sum += ((long) uniqueSpots.size() * (n - uniqueSpots.size()));
				System.out.println(uniqueSpots.size());
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
