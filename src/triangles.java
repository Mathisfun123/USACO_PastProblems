import java.io.*;
import java.util.*;

public class triangles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("triangles.in"));
		PrintWriter out = new PrintWriter(new File("triangles.out"));
		int n = sc.nextInt();
		int []xvals  = new int[n]; int []yvals = new int[n];
		for(int i = 0; i< n; i++) {
			xvals[i] = sc.nextInt();
			yvals[i] = sc.nextInt();
		}
		int maxArea = 0;
		//o(n^2) brute force?
		for(int i = 0; i <n; i++){
			for(int j = 0; j<n; j++){
				if(i!=j&& yvals[i]==yvals[j]){
					for(int k = 0; k<xvals.length; k++){
						if(j!=k&&xvals[j]==xvals[k]){
							int maxArea1 = (Math.abs(xvals[i] - xvals[j])) * (Math.abs(yvals[k] - yvals[j]));
							if(maxArea1 >maxArea){
								maxArea = maxArea1;
							}
						}
					}
				}
			}
		}
		out.println(maxArea);
		out.close();
	}
}
