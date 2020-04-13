package RandomFiles;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ClassConfusion {
	static ArrayList<Integer>[] map;
	public static void main(String[] args){
		map = new ArrayList[5];
		for(int i = 0; i< 5; i++){
			map[i] = new ArrayList<Integer>();
		}
		map[2].add(3); map[3].add(2);  map[3].add(1); map[1].add(3);
		boolean[] visited = new boolean[5];
		System.out.println(DFS(2, visited, 1,0));

	}
	public static int DFS(int X, boolean[] flag, int initial,int cost) {
		if (X == initial) {
			return cost;
		}
		flag[X] = true;
		cost+=1;
		Iterator<Integer> i = map[X].iterator();
		while (i.hasNext())
		{
			int next = i.next();
			if (!flag[next])  {
				return DFS(next,flag, initial,cost);
			}
		}
		return -1;
	}

}

