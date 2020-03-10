package Feb_2020_NP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class triangles {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("Feb_2020NP.RandomFiles.triangles" + ".in"));
		int n =sc.nextInt();
		int [] X = new int[n];
		int [] Y = new int[n];
		HashMap<Integer, ArrayList<Integer>> xhashMap = new HashMap<>();
		HashMap<Integer, ArrayList<Integer>> yhashMap = new HashMap<>();
		for(int i = 0; i< n; i++){
			X[i]= sc.nextInt();
			Y[i]= sc.nextInt();
			if(xhashMap.containsKey(X[i])){
				xhashMap.get(X[i]).add(i);
			}else{
				ArrayList<Integer> t = new ArrayList<>();
				t.add(i);
				xhashMap.put(X[i], t);
			}
			if(yhashMap.containsKey(Y[i])){
				yhashMap.get(Y[i]).add(i);
			}else{
				ArrayList<Integer> t = new ArrayList<>();
				t.add(i);
				yhashMap.put(Y[i], t);
			}
		}

		int area = 0;
		for(int i = 0; i< n; i++){
			ArrayList<Integer> commonx = xhashMap.get(X[i]);
			ArrayList<Integer> commony = yhashMap.get(Y[i]);
			for(int jx = 0; jx< commonx.size(); jx++ ){
				int xcomponent = (int)(Math.abs(Y[commonx.get(jx)]-Y[i]));

				for(int jy = 0; jy< commony.size() ; jy++){
					int ycomponent = (int)(Math.abs(X[commony.get(jy)]-X[i]));
					area+= (xcomponent*ycomponent);
				}
			}
		}
		PrintWriter out = new PrintWriter(new File("Feb_2020NP.RandomFiles.triangles.out"));
		out.println((int)(area%(Math.pow(10,9)+7)));
		out.close();

	}
}
