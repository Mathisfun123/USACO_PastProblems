import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class fenceplan {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("fenceplan" + ".in"));
		int n =sc.nextInt(); int m = sc.nextInt();
		Point [] arr= new Point[n];
		for(int i= 0; i< n; i++){
			arr[i] = new Point(sc.nextInt(), sc.nextInt());
		}
		for(int i = 0; i< m; i++){
			int abi = sc.nextInt()-1; int bci= sc.nextInt()-1;
			Point ab = arr[abi]; Point bc = arr[bci];
			 ab.combine(bc);
			System.out.println(i + " " + (arr[4]==arr[5]));
			arr[bci]= ab; arr[abi] = ab;
		}
		System.out.println(Arrays.toString(arr));

	}
	static class Point implements Comparable{
		int x, y;
		int minx,maxx, miny, maxy;
		public Point(int xp, int yp){
			x = xp; y = yp;
			minx=maxx=x;
			miny=maxy=y;

		}

		@Override
		public int compareTo(Object o) {
			Point p = (Point) o;
			return this.maxx- this.minx == p.maxx - p.minx? this.maxy-this.miny - p.maxy + p.miny: this.maxx- this.minx - p.maxx + p.minx;
		}
		public void combine(Point p){
			minx= Math.min(minx,p.minx);
			maxx= Math.max(maxx,p.maxx);
			miny= Math.min(miny, p.miny);
			maxy= Math.max(maxy, p.maxy);

		}

		@Override
		public String toString() {
			return "Point{" +
					"minx=" + minx +
					", maxx=" + maxx +
					", miny=" + miny +
					", maxy=" + maxy +
					'}';
		}
	}
}
