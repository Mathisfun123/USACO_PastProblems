package RandomFiles;

import java.util.*;

public class ClassConfusion {
	static ArrayList<Integer>[] map;
	public static void main(String[] args){
		map = new ArrayList[6];
		for(int i = 0; i< 6; i++){
			map[i] = new ArrayList<>();
		}
		map[0].add(1); map[1].add(0);
		map[1].add(3); map[3].add(1);
		map[1].add(2); map[2].add(1);
		map[3].add(4); map[4].add(3);
		map[3].add(5); map[5].add(3);
		boolean[] visited = new boolean[6];
		System.out.println(DFS(0, visited, 2,0));
//		Queue<Integer> t = new LinkedList<>();  t.add(0);
//		System.out.println(BFS(t, visited, 2, 0));
	}
	public static int DFS(int X, boolean[] flag, int wanting, int cost) {
		if (X == wanting) {
			return cost;
		}
		flag[X] = true;
		cost += 1;
		int result = Integer.MAX_VALUE;
		for (int next : map[X]) {
			if (!flag[next]) {
				int val = DFS(next, flag, wanting, cost);
				if(val!=-1){
					result = Math.min(val,result);
				}
			}
		}
		return result;
	}
	public static int BFS(Queue<Integer> t, boolean[] flag, int wanting, int cost){
		Integer X = t.poll();
		assert X != null;
		System.out.println("Hello " + X);
		if(X== wanting){
			return cost;
		}
		flag[X]= true;
		cost+=1;
		for (int next : map[X]) {
			if (!flag[next]) {
				t.add(next);
			}
		}

		return BFS(t, flag, wanting, cost);
	}

}

