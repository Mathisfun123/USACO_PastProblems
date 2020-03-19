import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
//had to look at the official guide to get the around 2-8 test cases (thought it was best to flip when multiple cow on axes instead of multiple in a unknown spot)
//ooooh for the 11th test case, you can only use one spot
//summary: flip first row and column in case of 1's and then
public class leftout {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("leftout" + ".in"));
		PrintWriter out = new PrintWriter(new File("leftout.out"));
		int n = sc.nextInt();
		sc.nextLine();
		int arr[][] = new int[n][n];
		for(int i = 0; i< n; i++){
			String ln = sc.nextLine();
			for(int j = 0; j< n; j++){
				arr[i][j]= ln.substring(j, j+1).equals("R")?1:0;
			}
		}
		//first change all the top row to 0

			for(int j = 0; j< n; j++){
				if(arr[0][j]==1){
					for(int r = 0; r< n; r++){
						arr[r][j]=arr[r][j]==0?1:0;
					}
				}
			}

		//now changing the first column to be all 0
		for(int i = 0; i< n; i++){
			if(arr[i][0]==1){
				for(int c = 0; c<n; c++){
					arr[i][c]=arr[i][c]==0?1:0;
				}
			}
		}
		//find sum to see if the top cow is guilty
		long sum = 0;
		for(int i = 0; i< n; i++){
			for(int j = 0; j< n; j++){
				sum+= arr[i][j];
			}
		}
		String ln = null;
		if(sum<(n-1)*(n-1)){
			//check if any columns are filled
			for(int i = 1; i< n; i++){
				int sumcol = 0;
				for(int r = 0; r< n; r++){
					sumcol+=arr[r][i];
				}
				if(sumcol==n-1){
				   ln= (1 + " "+ (i+1));
					break;
				}
			}
			//now check if rows are filled
			for(int i = 1; i< n; i++){
				int sumrow= 0;
				for(int c= 0; c< n; c++){
					sumrow+=arr[i][c];
				}
				if(sumrow==n-1){
					ln = ((i+1)+" "+ 1);
					break;
				}
			}
		}else{
			ln = (1 +" " +1);
		}
		if(ln==null){
			boolean reached1= false;
			boolean reached2= false;
			for(int i = 0; i< n && !reached2; i++){
				for(int j = 0; j< n&& !reached2; j++){
					if(arr[i][j]==1){
						if(!reached1) {
							ln = ((i + 1) + " " + (j + 1));
							reached1 = true;
						}else{
							reached2= true;
							ln = null;
						}
					}
				}
			}
			if(!reached1|| ln==null) {
				out.println(-1);
			}else{
				out.println(ln);
			}
		}else{
			out.println(ln);
		}
		out.close();
	}
}
