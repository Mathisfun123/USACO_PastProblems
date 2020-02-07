import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class lineup2 {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("lineup" + ".in"));
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
		LinkedList<String> answer = new LinkedList<>();
		System.out.println(Arrays.toString(adj));
		Queue<Integer> q = new ArrayDeque<Integer>();
		boolean[] visited = new boolean[arr.length];
		boolean first = true;
		//find first first (lol the first one that can work)
		for(int i = 0; i < arr.length; i++) {
			if(first&& adj[i].size()<=1){
				answer.add(arr[i]);
				visited[i]= true;
				first=false;
				if(adj[i].size()==1){
					q.add(adj[i].get(0));
				}
			}
		}
		while(!q.isEmpty()){
			int curr = q.poll();
			answer.add(arr[curr]);
			visited[curr]= true;
			if(adj[curr].size()==2){
				q.add(adj[curr].get(1));
			}
		}
		System.out.println(answer);
	}
}
