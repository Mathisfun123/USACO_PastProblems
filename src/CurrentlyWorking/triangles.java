package CurrentlyWorking;
//Need to look at this a later date: do other silver problems
//overshoot test cases 8-10 (8 with 7)
//draw shape of rectangular field

import java.io.*;
import java.util.*;

public class triangles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("CurrentlyWorking.triangles.in"));
		PrintWriter out = new PrintWriter(new File("CurrentlyWorking.triangles.out"));
		int n = sc.nextInt();
		int []xvals  = new int[n]; int []yvals = new int[n];
		long[]xcomp = new long[n]; long[]ycomp = new long[n];
		HashMap<Integer, TreeSet<Pair>> XvalsforPoints= new HashMap<>();
		HashMap<Integer, TreeSet<Pair>> YvalsforPoints= new HashMap<>();
		for(int i = 0; i< n; i++) {
			xvals[i] = sc.nextInt();
			yvals[i] = sc.nextInt();
			if(XvalsforPoints.containsKey(xvals[i])){
				XvalsforPoints.get(xvals[i]).add(new Pair(i, yvals[i]));
			}else{
				TreeSet<Pair> ip = new TreeSet<>();
				ip.add(new Pair(i, yvals[i]));
				XvalsforPoints.put(xvals[i],ip);
			}
			if(YvalsforPoints.containsKey(yvals[i])){
				YvalsforPoints.get(yvals[i]).add(new Pair(i, xvals[i]));
			}else{
				TreeSet<Pair> ip = new TreeSet<>();
				ip.add(new Pair(i, xvals[i]));
				YvalsforPoints.put(yvals[i],ip);
			}
		}

		Arrays.fill(xcomp,-1) ;
		Arrays.fill(ycomp,-1);
		long maxArea = 0;
		for(int i = 0; i< n; i++){
			//trying out each point as a right corner
//			System.out.println(i+ " " + XvalsforPoints.get(xvals[i]));
			TreeSet<Pair> t = XvalsforPoints.get(xvals[i]); int tsize= t.size();
			TreeSet<Pair> s = YvalsforPoints.get(yvals[i]); int ssize= s.size();
			if (t.size() != 1 && s.size() != 1) {
				if(ycomp[i]==-1) {
					ycomp[i] = 0;
					for (Pair k : t) {
						int j = k.xory;
						if (j != yvals[i]) {
							ycomp[i] += Math.abs(j - yvals[i]);
						}
					}
					int icounter = -1;// will always be minimum one that I look at first(treeSet)
					int iterationnumber = 0;
					for(Pair k: t){
						if (iterationnumber != 0) {
							ycomp[k.ivalue] = ycomp[icounter] + ((2 * iterationnumber) - tsize) * (yvals[k.ivalue] - yvals[icounter]);
						}
						icounter= k.ivalue;
						iterationnumber++;
					}
				}
				if(xcomp[i]==-1) {
					xcomp[i] = 0;
					for (Pair k : s) {
						int j = k.xory;
						if (j != xvals[i]) {
							xcomp[i] += Math.abs(j - xvals[i]);
						}
					}
					int icounter = -1;// will always be minimum one that I look at first(treeSet)
					int iterationnumber = 0;
					for(Pair k: s){
						if (iterationnumber != 0) {
							xcomp[k.ivalue] = xcomp[icounter] + ((2 * iterationnumber) - ssize) * (xvals[k.ivalue] - xvals[icounter]);
						}
						icounter= k.ivalue;
						iterationnumber++;
					}
					System.out.println(i + " " + xvals[i] + " " + yvals[i]+ " " + xcomp[i]+ " " + ycomp[i]+ " "+ xcomp[39999] + ycomp[39999]);
				}
				if(xcomp[i]!=-1 &&ycomp[i]!=-1) {
					xcomp[i] %= Math.pow(10, 9) + 7;
					ycomp[i] %= Math.pow(10, 9) + 7;
					maxArea += xcomp[i] * ycomp[i];
					if(xcomp[i] * ycomp[i]<0){
						System.out.println(i);
						System.out.println(xcomp[i]);
						System.out.println(ycomp[i]);
					}
					maxArea %= Math.pow(10, 9) + 7;
				}
				//time to set the xcomponent for the other common y vals
			}
		}



		out.println(maxArea);
		out.close();
	}
	static class Pair implements Comparable{
		//will be a pair of numbers where one is the x or y coordinate and the other is if there is a value assigned already
		int xory;
		int value;
		int ivalue;
		public Pair(int i, int xorygivent){
			xory = xorygivent;
			value= -1;
			ivalue= i;
		}

		@Override
		public int compareTo(Object o) {
			Pair p = (Pair) o;
			return xory-p.xory;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"xory=" + xory +
					'}';
		}
	}
}