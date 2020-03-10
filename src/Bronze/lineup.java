package Bronze;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class lineup {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Bronze.lineup" + ".in"));
		int n = sc.nextInt();
		sc.nextLine();
		String[] arr = {"Beatrice", "Belinda","Bella","Bessie", "Betsy", "Blue","Buttercup","Sue"};
		ArrayList<Integer>[] adj = new ArrayList[arr.length];
		for(int i = 0; i < arr.length; i++)
			adj[i] = new ArrayList<Integer>();
		Arrays.sort(arr, null);
		for(int i = 0; i < n; i++) {
			String[] arr1 = sc.nextLine().split(" ");
			int a = Arrays.binarySearch(arr, arr1[0]);
			int b = Arrays.binarySearch(arr, arr1[5]);
			adj[a].add(b);
			adj[b].add(a);
		}
		System.out.println(Arrays.toString(adj));
		Queue<Integer> q = new ArrayDeque<Integer>();
//		boolean[] visited = new boolean[n];
//		for(int i = 0; i < n; i++) {
//			if(!visited[i]) q.add(i);
//			while(!q.isEmpty()) {
//
//			}
//		}
	}
}
