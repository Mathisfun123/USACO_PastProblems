
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class swap {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("swap" + ".in"));
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int[] x= new int[n];
		for(int i = 0; i< n; i++){
			x[i] = i;
		}
		Pair[] pairs = new Pair[m];
		for(int i = 0; i< m; i++){
			pairs[i]= new Pair(sc.nextInt()-1,sc.nextInt()-1);
			swapper(x, pairs[i].a, pairs[i].b);
		}
//		System.out.println(Arrays.toString(x));
		PrintWriter out = new PrintWriter(new File("swap.out"));
		//time to start analyzing cycles
		int[] minimumxforindic = new int[n]; 
		Set<Integer> valsmissing = new HashSet<Integer>();
		for(int i = 0; i< n; i++){
			if(x[i]==i){
				minimumxforindic[i]= 1; 
			}else{
				valsmissing.add(i);
				minimumxforindic[i]= Integer.MAX_VALUE; 
			}
		}
		int runs = 1; //counts the number of times we've done the moves  
		ArrayList<int[]> arraysAfterIterations = new ArrayList<>();
		arraysAfterIterations.add(x);
		while(valsmissing.size()>0 && runs<k){
			int[] lastarr = arraysAfterIterations.get(runs-1);
			int[] newarr=  new int[n];
			runs++;
			for(int j = 0; j< n; j++){
				newarr[j]= lastarr[lastarr[j]]; 
				if(newarr[j]== j && valsmissing.contains(j)){
					valsmissing.remove(new Integer(j)); 
					minimumxforindic[j] = runs; 
				}
			}
			arraysAfterIterations.add(newarr);
		}
		System.out.println(Arrays.toString(minimumxforindic));
		for (int[] i: arraysAfterIterations){
			System.out.println(Arrays.toString(i));
		}
		for(int i = 0; i< n; i++){
			if(minimumxforindic[i]== Integer.MAX_VALUE){
				//couldn't use cycle technique but can use last element of iterations value
				out.println(arraysAfterIterations.get(k-1)[i]+1);
			}else{
				int stepsaftermod= k%minimumxforindic[i];
				if(stepsaftermod> 0){
					stepsaftermod --; //accounting for original being no step change
					out.println(arraysAfterIterations.get(stepsaftermod)[i]+1);

				}else{
					out.println(i+1);
				}
				System.out.println(stepsaftermod + " " + arraysAfterIterations.get(stepsaftermod)[i]);

			}
		}

		out.close();
	}
	public static void swapper(int arr[], int start, int end){
		int temp = 0;
		while(start< end){
			temp = arr[start];
			arr[start]= arr[end];
			arr[end]= temp;
			start++;
			end--;
		}
	}
	public static class Pair{
		public int a;
		public int b;
		public Pair(int a, int b){
			this.a= a;
			this.b = b;
		}
	}
}
