import java.io.*;
import java.sql.Time;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 0; i< n; i++){
			int m = sc.nextInt();
			int arr[] = new int[m];
			for(int j = 0; j< m; j++){
				arr[j] =sc.nextInt();
			}
			long prefixarr[] =new long[m]; prefixarr[0]= arr[0];
			for (int j = 1; j< m; j++){
				prefixarr[j] = prefixarr[j-1] + arr[j];
			}
			HashMap<Long, Integer> TimesAppear = new HashMap<>();
			int combos = 0;
			for(int j = 0; j< m; j++){
				long val = prefixarr[j]-47; //looking for this value
				if(TimesAppear.containsKey(val)){
					combos+= TimesAppear.get(val);
				}
					if(TimesAppear.containsKey(prefixarr[j])){
						TimesAppear.put(prefixarr[j],TimesAppear.get(prefixarr[j])+1);
					}else {
						TimesAppear.put(prefixarr[j], 1);
					}

			}
			System.out.println(combos);
		}
	}
}