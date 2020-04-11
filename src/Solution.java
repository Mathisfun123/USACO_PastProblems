import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'stockmax' function below.
	 *
	 * The function is expected to return a LONG_INTEGER.
	 * The function accepts INTEGER_ARRAY prices as parameter.
	 */

	public static long stockmax(List<Integer> prices) {
		// Write your code here
		int n = prices.size();
		long prefixMax[] = new long[n]; prefixMax[n-1] = prices.get(n-1);
		for(int i = n-2; i>=0 ; i--){
			prefixMax[i] = Math.max(prefixMax[i+1],prices.get(i));
		}
		long sum = 0; long stonks = 0;
		for(int i = 0; i< n; i++){
			if(prices.get(i)<prefixMax[i] && i!=n-1){
				sum-= prices.get(i);
				stonks++;
			}else if(prices.get(i)==prefixMax[i]){
				sum+= (stonks * prefixMax[i]);
				stonks=0;
			}
		}
		return sum;
	}

}

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

		int t = Integer.parseInt(bufferedReader.readLine().trim());

		IntStream.range(0, t).forEach(tItr -> {
			try {
				int n = Integer.parseInt(bufferedReader.readLine().trim());

				List<Integer> prices = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
						.map(Integer::parseInt)
						.collect(toList());

				long result = Result.stockmax(prices);

				bufferedWriter.write(String.valueOf(result));
				bufferedWriter.newLine();
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		bufferedReader.close();
		bufferedWriter.close();
	}
}
