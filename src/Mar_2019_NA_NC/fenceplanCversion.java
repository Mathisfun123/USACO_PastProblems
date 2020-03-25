package Mar_2019_NA_NC;

import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class fenceplanCversion {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Mar_2019_NA_NC.fenceplan" + ".in"));
		int n = sc.nextInt(); int m = sc.nextInt();
		Point[] arr = new Point[n];
		ArrayList<Integer> [] connections = new ArrayList[n];
		for(int i = 0; i< n; i++){
			arr[i] = new Point(sc.nextInt(), sc.nextInt(), i);
			connections[i] = new ArrayList<>();
		}
		boolean[] visited = new boolean[n];
		for(int i = 0; i< m; i++){
			int a = sc.nextInt(); int b = sc.nextInt();
			connections[a-1].add(b-1); connections[b-1].add(a-1);
		}
		TreeSet<LineSegments> potentials = new TreeSet<>();
		for(int i = 0; i< n; i++){
			if(!visited[i]){
				visited[i] =true;
				LineSegments t = new LineSegments(arr[i]);
				Stack<Point> current = new Stack<>(); 
				for(Integer integer: connections[i]){
					if(!visited[integer])
						current.add(arr[integer]); 
				}
				while(!current.isEmpty()){
					Point p = current.pop();
					visited[p.i]= true;
					t.combine(p);
					for(Integer integer: connections[p.i]){
						if(!visited[integer])
							current.add(arr[integer]);
					}
				}
				potentials.add(t);
			}
		}
		PrintWriter out = new PrintWriter(new File("Mar_2019_NA_NC.fenceplan.out"));
		out.println(potentials.pollFirst());
		out.close();

	}
	static class Point{
		int x, y, i;
		public Point(int x1, int y1, int i1){
			x = x1; y = y1; i =i1; 
		}

		@Override
		public String toString() {
			return "Point{" +
					"x=" + x +
					", y=" + y +
					", i=" + i +
					'}';
		}
	}
	static class LineSegments implements Comparable{
		int minx,maxx, miny, maxy;
		public LineSegments(Point p){
			minx= maxx= p.x;
			miny=maxy=p.y;
		}
		public void combine(Point p){
			this.minx= Math.min(this.minx, p.x);
			this.miny= Math.min(this.miny, p.y);
			this.maxx= Math.max(this.maxx, p.x);
			this.maxy= Math.max(this.maxy, p.y);
		}

		@Override
		public int compareTo(Object o) {
			LineSegments p = (LineSegments) o;
			int diff = Math.abs(maxx- minx)  + Math.abs(maxy -miny);
			int otherdiff= Math.abs(p.maxx-p.minx) +Math.abs(p.maxy- p.miny);
			return diff- otherdiff;
		}

		@Override
		public String toString() {
			 //return "Pair" + "{"+minx+" "+ maxx + ", "+ miny + " " + maxy+"}";
			return ""+ (2*(Math.abs(maxx- minx)  + Math.abs(maxy -miny)));
		}
	}
	
}
