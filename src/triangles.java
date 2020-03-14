import javax.xml.crypto.dsig.XMLValidateContext;
import java.io.*;
import java.util.*;

public class triangles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("triangles.in"));
		PrintWriter out = new PrintWriter(new File("triangles.out"));
		int n = sc.nextInt();
		int []xvals  = new int[n]; int []yvals = new int[n];
		HashMap<Integer, ArrayList<Integer>> XvalsforPoints= new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> YvalsforPoints= new HashMap<>();
		for(int i = 0; i< n; i++) {
			xvals[i] = sc.nextInt();
			yvals[i] = sc.nextInt();
			if(XvalsforPoints.containsKey(xvals[i])){
				XvalsforPoints.get(xvals[i]).add(i);
			}else{
				ArrayList<Integer> ip = new ArrayList<>();
				ip.add(i);
				XvalsforPoints.put(xvals[i],ip);
			}
			if(YvalsforPoints.containsKey(yvals[i])){
				YvalsforPoints.get(yvals[i]).add(i);
			}else{
				ArrayList<Integer> ip = new ArrayList<>();
				ip.add(i);
				YvalsforPoints.put(yvals[i],ip);
			}
		}
		long maxArea = 0;
		for(int i = 0; i< n; i++){
			//trying out each point as a right corner
//			System.out.println(i+ " " + XvalsforPoints.get(xvals[i]));
			ArrayList<Integer> t = XvalsforPoints.get(xvals[i]);
			long ycomp = 0;
			for(int j = 0; j< t.size(); j++){
				if(t.get(j)!=i){
					//need to get y distance (x vals match)
					ycomp+= Math.abs(yvals[t.get(j)] - yvals[i]);
				}
			}
			ArrayList<Integer> s = YvalsforPoints.get(yvals[i]);
			long xcomp = 0;
			for(int j = 0; j< s.size(); j++){
				if(s.get(j)!=i){
					//need to get y distance (x vals match)
					xcomp+= Math.abs(xvals[s.get(j)] - xvals[i]);
				}
			}
			xcomp%= Math.pow(10, 9) + 7;
			ycomp%= Math.pow(10, 9) + 7;
			maxArea += xcomp * ycomp;
			maxArea%= Math.pow(10, 9) + 7;
			//System.out.println(i+ " " + xcomp + " " + ycomp);
			//time to calculate s1 by saying that you sum all of the y components and multiply by sum of x components (with example of (1,2 vs 1,2) triangles --> 3*3

		}
//		System.out.println(XvalsforPoints);
//		System.out.println(YvalsforPoints);

		out.println(maxArea);
		out.close();
	}
}
