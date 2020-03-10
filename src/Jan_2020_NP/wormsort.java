package Jan_2020_NP;

import java.io.*;
import java.lang.invoke.WrongMethodTypeException;
import java.util.*;

public class wormsort {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader("Jan_2020_NP.wormsort.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Jan_2020_NP.wormsort.out")));

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
		if(needtoportal.size()==0){
			out.println(-1);
		}else{
			wormhole[] wormholes = new wormhole[m];
			for(int i =0; i< m; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int weight = sc.nextInt();
				wormholes[i]= new wormhole(weight,a,b);
			}
			Arrays.sort(wormholes);
			System.out.println(needtoportal);
			for(int i = 0; i< wormholes.length && wormholes[i].weight>793231200; i++){
				System.out.println(i+ " " + wormholes[i]);
			}
			System.out.println(Arrays.toString(wormholes));
			int[][] adjacenmatrix = new int[n][n];
			for(int i =0; i< n; i++){
				for(int j = 0 ;j< n; j++){
					adjacenmatrix[i][j]= -1;
				}
			} //starts all adjacency as -1
			int i;
			for(i =0; i< m; i++){
				//using these wormholes can I make a link
				wormhole currentwormhole = wormholes[i];
				adjacenmatrix[currentwormhole.a-1][currentwormhole.b-1] = currentwormhole.weight;
				adjacenmatrix[currentwormhole.b-1][currentwormhole.a-1]= currentwormhole.weight;
				//dfs time: pick one of the needtoportal and dfs to see if you can get everywhere else?
				int startpos = needtoportal.get(0);
				boolean reachall = true;
				//
				int currenton;
				for(currenton = 1; currenton< needtoportal.size(); currenton++){
					boolean[] visited = new boolean[n];
					if(!dfs(startpos-1, needtoportal.get(currenton), adjacenmatrix, visited)){
						reachall = false;
					}
				}
				if(reachall){
					break;
				}
			}

			out.println(wormholes[i-1].weight);
			//want to use wormholes as large as we can and see if we can reach all the incorrect spots with that
			//System.out.println(Arrays.toString(in_correctpos));

		}
		out.close();
	}
	static class wormhole implements Comparable{
		public int weight;
		public int a;
		public int b;
		public wormhole(int weight, int a, int b){
			this.weight= weight;
			this.a = a;
			this.b = b;
		}
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
	public static boolean dfs(int start, int end, int[][] adjlist, boolean visited[]){
		int n = adjlist.length;
		visited[start] = true;
		for(int i = 0; i< n; i++){
			if(adjlist[start][i]!=-1 && i==end-1){
				return true;
			}
			if(adjlist[start][i]!=-1 && !visited[i]){
				return dfs(i, end, adjlist, visited);
			}
		}
		return false;
	}
}
