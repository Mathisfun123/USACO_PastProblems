import javax.sound.sampled.Line;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//brute force method: 3/12 -- too slow because need to stop after intersecting once
//run 2: still times out on 4/12 but better time (suddenly got 11th test case)
public class cowjump {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("cowjump" + ".in"));
		int n = sc.nextInt();
		sc.nextLine();
		Point[] arr = new Point[2*n];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int i = 0; i< n; i++){
			int ax= sc.nextInt();
			int ay= sc.nextInt();
			int bx = sc.nextInt();
			int by = sc.nextInt();
			if(ax< bx || (ax==bx && ay<by)) {
				min = Math.min(ax,min);
				max = Math.max(bx, max);
				arr[2*i] = new Point(ax,ay, i,true,null);
				arr[2*i+1]= new Point(bx, by, i,false,arr[i]);
				arr[2*i].pair= arr[2*i+1];
			}else{
				min = Math.min(bx,min);
				max = Math.max(ax, max);
				arr[2*i] = new Point(bx, by, i, true,null);
				arr[2*i+1] = new Point(ax, ay, i, false, arr[i]);
				arr[2*i].pair= arr[2*i+1];
			}
		}
		Arrays.sort(arr);
		int lastposs = 0;
		HashSet<Point> currentSegments = new HashSet<>();
		int[] intersections = new int[n];
		Point onepoint = null; Point otherpoint = null;
		for(int i = min;i<=max && lastposs!=2*n && (otherpoint==null|| (currentSegments.contains(onepoint)||currentSegments.contains(otherpoint)));i++){
			if(arr[lastposs].x==i){
				//this means we need to do something
				if(!arr[lastposs].additionAction){
					currentSegments.remove(arr[lastposs].pair);
				}
				if(arr[lastposs].additionAction){
					for(Point p: currentSegments){
						if(interesect(arr[lastposs],p)){
							intersections[arr[lastposs].i]++; intersections[p.i]++;
							onepoint = arr[lastposs]; otherpoint= p;
						}
					}
					currentSegments.add(arr[lastposs]);
				}
				lastposs++;
			}
			if(lastposs!= 2*n && arr[lastposs].x ==i){
				i--;
			}
		}
		PrintWriter out = new PrintWriter(new File("cowjump.out"));
		if(onepoint==null){
			out.println(-1);
		}else if(intersections[onepoint.i]>=intersections[otherpoint.i]){
			out.println(onepoint.i+1);
		}else{
			out.println(otherpoint.i+1);
		}
		out.close();

	}
	static class Point implements Comparable{
		int x,y,i;
		Point pair; 
		boolean additionAction;
		public Point(int xv, int yv,int iv, boolean condition, Point otherpoint){
			x= xv; y =yv; i =iv;  additionAction= condition; pair = otherpoint;
			//might have pair equal to null but changed later -> sus programming
		}

		@Override
		public int compareTo(Object o) {
			Point p = (Point)o;
			if(x!=p.x){
				return x-p.x;
			}else if(additionAction!=p.additionAction){
				if(!additionAction){ //better to first remove the point (when adding have to check if intersection and gauran no intersect here (x and y /= for both)
					return 1;
				}else{
					return -1;
				}
			}else{
				return y- p.y;
			}
		}

		@Override
		public String toString() {
			return "Point{" +
					"x=" + x +
					", y=" + y +
					", i=" + i +
					", additionAction=" + additionAction +
					'}';
		}
	}

	public static boolean interesect(Point point1, Point point2){
		int x0= point1.x; int y0= point1.y; int x1 = point1.pair.x; int y1 = point1.pair.y;
		int x2= point2.x; int y2= point2.y; int x3 = point2.pair.x; int y3 = point2.pair.y;
		double s1x = x1-x0; double s1y = y1 - y0;
		double s2x = x3-x2; double s2y = y3 - y2;
		double v = -s2x * s1y + s1x * s2y;
		double s =  (-s1y * (x0 - x2) + s1x * (y0 - y2)) / v;
		double t = ( s2x * (y0 - y2) - s2y * (x0 - x2)) / v;
		return s >= 0 && s <= 1 && t >= 0 && t <= 1;// No collision
	}
}
