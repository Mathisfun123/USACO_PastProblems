
import java.io.*;
import java.util.*;

public class triangles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("triangles.in"));
		PrintWriter out = new PrintWriter(new File("triangles.out"));
		int n = sc.nextInt();
		int []xvals  = new int[n]; int []yvals = new int[n];
		HashMap<Integer, TreeSet<Integer>> XvalsforPoints= new HashMap<>();
		HashMap<Integer, TreeSet<Integer>> YvalsforPoints= new HashMap<>();
		for(int i = 0; i< n; i++) {
			xvals[i] = sc.nextInt();
			yvals[i] = sc.nextInt();
			if(XvalsforPoints.containsKey(xvals[i])){
				XvalsforPoints.get(xvals[i]).add(yvals[i]);
			}else{
				TreeSet<Integer> ip = new TreeSet<>();
				ip.add(yvals[i]);
				XvalsforPoints.put(xvals[i],ip);
			}
			if(YvalsforPoints.containsKey(yvals[i])){
				YvalsforPoints.get(yvals[i]).add(xvals[i]);
			}else{
				TreeSet<Integer> ip = new TreeSet<>();
				ip.add(xvals[i]);
				YvalsforPoints.put(yvals[i],ip);
			}
		}
		long maxArea = 0;
		for(int i = 0; i< n; i++){
			//trying out each point as a right corner
//			System.out.println(i+ " " + XvalsforPoints.get(xvals[i]));
			TreeSet<Integer> t = XvalsforPoints.get(xvals[i]);
			TreeSet<Integer> s = YvalsforPoints.get(yvals[i]);
			if (t.size() != 1 && s.size() != 1) {
				long ycomp = 0;
				for (int j : t) {
					if (j != yvals[i]) {
						ycomp += Math.abs(j - yvals[i]);
					}
				}
				long xcomp = 0;
				for (int j : s) {
					if (j != xvals[i]) {
						xcomp += Math.abs(j - xvals[i]);
					}
				}
				xcomp %= Math.pow(10, 9) + 7;
				ycomp %= Math.pow(10, 9) + 7;
				maxArea += xcomp * ycomp;
				maxArea %= Math.pow(10, 9) + 7;
				//time to set the xcomponent for the other common y vals
			}
		}


		out.println(maxArea);
		out.close();
	}
	static class Pair{
		//will be a pair of numbers where one is the x or y coordinate and the other is if there is a value assigned already
		int xory;
		int value;
		public Pair(int xorygivent){
			xory = xorygivent;
			value= -1;
		}
	}
}