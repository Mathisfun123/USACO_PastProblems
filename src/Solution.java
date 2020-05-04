
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution{
	static int [][] costs;
	static boolean cutSpots[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int cuts = Integer.parseInt(st.nextToken());
		cutSpots = new boolean[n+1];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i< cuts; i++){
			cutSpots[Integer.parseInt(st.nextToken())] =true;
		}
		costs= new int[n+1][n+1];
		for(int i = 0; i<=n; i++){
			for(int j = 0; j<=n; j++){
				costs[i][j] = Integer.MAX_VALUE;
			}
		} //prepopulate with MaxVal (to say not solved)
		System.out.println(TotalCost(0,n));
	}
	public static int TotalCost(int a, int b){
		if(costs[a][b]!= Integer.MAX_VALUE){
			return costs[a][b];
		}
		int cost = Integer.MAX_VALUE;
		for(int i = a+1; i< b; i++){
			if(cutSpots[i]){
				cost = Math.min(cost, (b-a) + TotalCost(a, i)  + TotalCost(i, b));
			}
		}
		if(cost==Integer.MAX_VALUE){
			cost = 0;
		}
		costs[a][b]= cost;
		return cost;
	}
}