

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ClassConfusion {
	static ArrayList<Integer>[] map;
	public static void main(String[] args){
		map = new ArrayList[5];
		for(int i = 0; i< 5; i++){
			map[i] = new ArrayList<>();
		}
		map[2].add(3); map[3].add(1);
		boolean visited [] = new boolean[5]; visited[2]= true;
		System.out.println(DFS(2, visited, 1));

	}
	public static boolean DFS(int X, boolean[] flag, int initial) {
		if (X == initial) {
			return true;
		}
		flag[X] = true;
		Iterator<Integer> i = map[X].iterator();
		while (i.hasNext())
		{
			int next = i.next();
			if (!flag[next])  {
				return DFS(next,flag, initial);
			}
		}
		return false;
	}

}

