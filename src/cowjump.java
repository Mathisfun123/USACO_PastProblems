import javax.sound.sampled.Line;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
//brute force method: 3/12 -- too slow because need to stop after intersecting once
//run 2: still times out on 4/12 but better time (suddenly got 11th test case)
public class cowjump {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("cowjump" + ".in"));
		int n = sc.nextInt();
		sc.nextLine();
		LineSegment[] arr = new LineSegment[n];
		for(int i = 0; i< n; i++){
			arr[i] = new LineSegment(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
		}
		int[] intersections = new int[n];
		int oneposs=-1,otherposs=-1;
		loop:
		for(int i = 0; i< n; i++){
			for(int j = i+1; j< n; j++){
				//going to check if these two LineSegments intersect -> if they intersect then both spots get counter ++
				//find the greatest counter number and output that
				if(interesect(arr[i],arr[j])){
					intersections[i]++;
					intersections[j]++;
					oneposs= i;
					otherposs= j;
					break loop;
				}
			}
		}

		for(int i = 0; i< n; i++){
			//first checking if oneposs is intersecting
			if (i != oneposs && i != otherposs) {
				if(interesect(arr[i],arr[oneposs])){
					intersections[oneposs]++;
				}else if(interesect(arr[i],arr[otherposs])){
					intersections[otherposs]++;
				}
			}
		}
		int pos;
		if(intersections[otherposs]>intersections[oneposs]){
			pos = otherposs;
		}else{
			pos = oneposs;
		}
		PrintWriter out = new PrintWriter(new File("cowjump.out"));
		out.println(pos+1);
		out.close();
	}
	static class LineSegment{
		int xbeg; int ybeg;
		int xend; int yend;
		public LineSegment(int x0, int y0, int x1, int y1) {
			xbeg = x0;
			ybeg = y0;
			xend = x1;
			yend = y1;
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
