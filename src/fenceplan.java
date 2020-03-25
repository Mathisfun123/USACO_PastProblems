import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class fenceplan {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("fenceplan" + ".in"));
		int n =sc.nextInt(); int m = sc.nextInt();
		Point[] arr= new Point[n];
		Stack<Point> allOriginPoints = new Stack<>();
		for(int i= 0; i< n; i++){
			arr[i] = new Point(sc.nextInt(), sc.nextInt(),i);
			allOriginPoints.add(arr[i]);
		}
		for(int i = 0; i< m; i++){
			int abi = sc.nextInt()-1; int bci= sc.nextInt()-1;
			Point ab = arr[abi]; Point bc = arr[bci];
			ab.links.add(bc); bc.links.add(ab);
		}

		TreeSet<Point> endvalues = new TreeSet<>();
		//look through with the queue and form links
		while(!allOriginPoints.isEmpty()) {
			Stack<Point> values = new Stack<>();
			Point examine = allOriginPoints.pop();
			values.add(examine);
			boolean[] visited = new boolean[n];
			visited[examine.i] = true;
			while (!values.isEmpty()) {
				Point start = values.pop();
				if(!allOriginPoints.isEmpty()){
					allOriginPoints.remove(start);
				}
				if (!visited[start.i]) {
					//System.out.println(start);
					visited[start.i] = true;
					examine.minx= Math.min(examine.minx, start.minx);
					examine.miny= Math.min(examine.miny, start.miny);
					examine.maxx= Math.max(examine.maxx, start.maxx);
					examine.maxy= Math.max(examine.maxy, start.maxy);
				}
				for (Point p : start.links) {
					if (!visited[p.i]) {
						values.add(p);
					}
				}
			}
			endvalues.add(examine);
			//System.out.println("Hello "+ examine);
		}
		PrintWriter out = new PrintWriter(new File("fenceplan.out"));
		out.println(endvalues.pollFirst());
		out.close();

	}
	static class Point implements Comparable{
		int x, y, i;
		int minx,maxx, miny, maxy;
		ArrayList<Point> links;
		public Point(int xp, int yp, int ip){
			x = xp; y = yp; i =ip;
			minx=maxx=x;
			miny=maxy=y;
			links = new ArrayList<>();
		}

		@Override
		public int compareTo(Object o) {
			Point p = (Point) o;
			int diff = Math.abs(maxx- minx)  + Math.abs(maxy -miny);
			int otherdiff= Math.abs(p.maxx-p.minx) +Math.abs(p.maxy- p.miny);
			return diff- otherdiff;
		}


		@Override
		public String toString() {
			return "" + (2*(Math.abs(maxx-minx)+Math.abs(maxy-miny)));
			//return "Pair" + "{"+x + ", "+ y+"}";
		}
	}
}
