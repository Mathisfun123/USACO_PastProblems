package Mar_2019_NA_NC;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

//brute force method: 3/12 -- too slow because need to stop after intersecting once
//run 2: still times out on 4/12 but better time (suddenly got 11th test case)
public class cowjump {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Mar_2019_NA_NC.cowjump" + ".in"));
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
		ArrayList<Point> lineSegmentsCurrent= new ArrayList<>();
		Point onepoint = null; Point otherpoint = null;
		int arri = -1; int arri2= -1;
		int[] intersections = new int[n];
		loop:
		for(int i = 0; i<2*n; i++){
			if(arr[i].additionAction){
				int index = Collections.binarySearch(lineSegmentsCurrent,arr[i],Point::compareTo);
				if (index < 0) {
					index = -index - 1;
				}
				//scan if intersect with neighbors --> if it does then scan rest
				if(lineSegmentsCurrent.size()>index &&lineSegmentsCurrent.size()!=0){
					if(interesect(lineSegmentsCurrent.get(index), arr[i])){
						onepoint= arr[i]; otherpoint= lineSegmentsCurrent.get(index);
						arri= i; arri2= Arrays.binarySearch(arr,lineSegmentsCurrent.get(index));
						break loop;
					}
				}
				if(index-1>=0){
					if(interesect(lineSegmentsCurrent.get(index-1), arr[i])){
						onepoint= arr[i]; otherpoint= lineSegmentsCurrent.get(index-1);
						System.out.println("Hello");
						arri= i; arri2= Arrays.binarySearch(arr,lineSegmentsCurrent.get(index-1));
						break loop;
					}
				}
				lineSegmentsCurrent.add(index, arr[i]);
			}
			if(!arr[i].additionAction){
				//means we have to remove this point (linesegment containing this point )
				lineSegmentsCurrent.remove(arr[i]);
			}
		}
		//need to fix the issue of picking the correct point out of onepoint or otherpoint



		System.out.println(onepoint+ " " + otherpoint);
		System.out.println(arr[arri] + " "+ arr[arri2]);


		PrintWriter out = new PrintWriter(new File("Mar_2019_NA_NC.cowjump.out"));
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
