import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

//brute force method: 3/12 -- too slow because need to stop after intersecting once
//run 2: still times out on 4/12 but better time (suddenly got 11th test case)
public class cowjump {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("cowjump" + ".in"));
		int n = sc.nextInt();
		sc.nextLine();
		LineSegment[] arr = new LineSegment[n];
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
				arr[i] = new LineSegment(ax, ay, bx, by);
			}else{
				min = Math.min(bx,min);
				max = Math.max(ax, max);
				arr[i] = new LineSegment(bx, by, ax, ay);
			}

		}
		Arrays.sort(arr);
		int[] intersections = new int[n];
		int oneposs=-1,otherposs=-1;
		System.out.println(Arrays.toString(arr));
		HashSet<Integer> current = new HashSet<>();
		for(int i = min; i<= max; i++){

		}


//		for(int i = 0; i< n; i++){
//			//first checking if oneposs is intersecting
//			if (i != oneposs && i != otherposs) {
//				if(interesect(arr[i],arr[oneposs])){
//					intersections[oneposs]++;
//				}else if(interesect(arr[i],arr[otherposs])){
//					intersections[otherposs]++;
//				}
//			}
//		}
//		int pos;
//		if(intersections[otherposs]>intersections[oneposs]){
//			pos = otherposs;
//		}else{
//			pos = oneposs;
//		}
//		PrintWriter out = new PrintWriter(new File("cowjump.out"));
//		out.println(pos+1);
//		out.close();
	}
	static class LineSegment implements Comparable{
		int xbeg; int ybeg;
		int xend; int yend;
		public LineSegment(int x0, int y0, int x1, int y1) {
			xbeg = x0;
			ybeg = y0;
			xend = x1;
			yend = y1;
		}

		@Override
		public int compareTo(Object o) {
			LineSegment p = (LineSegment)o;
			if(xbeg==p.xbeg){
				return ybeg-p.ybeg;
			}else{
				return xbeg- p.xbeg;
			}
		}

		@Override
		public String toString() {
			return "LineSegment{" +
					"xbeg=" + xbeg +
					", ybeg=" + ybeg +
					", xend=" + xend +
					", yend=" + yend +
					'}';
		}
	}
	public static boolean interesect(LineSegment line1, LineSegment line2){
		int x0= line1.xbeg; int y0= line1.ybeg; int x1 = line1.xend; int y1 = line1.yend;
		int x2= line2.xbeg; int y2= line2.ybeg; int x3 = line2.xend; int y3 = line2.yend;
		double s1x = x1-x0; double s1y = y1 - y0;
		double s2x = x3-x2; double s2y = y3 - y2;
		double v = -s2x * s1y + s1x * s2y;
		double s =  (-s1y * (x0 - x2) + s1x * (y0 - y2)) / v;
		double t = ( s2x * (y0 - y2) - s2y * (x0 - x2)) / v;
		return s >= 0 && s <= 1 && t >= 0 && t <= 1;// No collision
	}
}
