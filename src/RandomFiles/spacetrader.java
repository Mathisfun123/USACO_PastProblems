package RandomFiles;

import java.util.*;
import java.awt.*;
import java.io.*;
import java.text.DecimalFormat;

public class spacetrader
{
	static int[][] connections = new int[26][26];
	static char startingPlant; static int max;
	public static void main(String[] args) throws Exception
	{
		Scanner fromFile = new Scanner(new File("RandomFiles.spacetrader.dat"));

		startingPlant = fromFile.nextLine().charAt(0);


		for(int r=0; r<connections.length; r++)
			for(int c=0; c<connections[0].length; c++)
				connections[r][c]=-1;

		while(fromFile.hasNextLine())
		{
			String[] temp = fromFile.nextLine().split("/");
			char planetA = temp[0].charAt(0);
			char planetB = temp[1].charAt(0);
			int distance = Integer.parseInt(temp[1].substring(4));

			connections[planetA-'A'][planetB-'A'] = distance;
			connections[planetB-'A'][planetA-'A'] = distance;
		}
		max =0;
		ArrayList<Integer> visited = new ArrayList<>();
		LinkedList<Character> answers = new LinkedList<>(); answers.add(startingPlant);
		visited.add(startingPlant-'A');
		dfs_attem(connections, startingPlant, 0,0,visited);
		System.out.println(max);
	}
	private static void dfs_attem (int[][] arr_connections, char pos, int amt, int count, ArrayList<Integer> visited){
		if((amt<50)){
			for(int i = 0; i< 26; i++){
				if(arr_connections[pos-'A'][i] !=-1){
					if(amt + arr_connections[pos-'A'][i]  < 50 ){System.out.println(pos + " " + amt+" ");
						if(visited.contains(i)){
							dfs_attem(arr_connections, (char)('A'+i), amt+ arr_connections[pos-'A'][i], count,visited);
						}else{
							visited.add(i);
							if(count+1>max){

								max= count+1;
							}
							dfs_attem(arr_connections, (char)(i+'A'), amt+ arr_connections[pos-'A'][i], count+1, visited);
						}
					}
				}
			}
		}
	}
	
}