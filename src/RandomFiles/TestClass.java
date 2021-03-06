package RandomFiles;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TestClass {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("berries.in"));
		while(sc.hasNextLine()){
			int n = sc.nextInt();
			Stack<Integer> stack = new Stack<>(); boolean isStack = true;
			Queue<Integer> queue = new LinkedList<>(); boolean isQueue = true;
			PriorityQueue<CompareInts> priorityQueue = new PriorityQueue<>(); boolean isPriority = true;
			for(int i = 0; i< n; i++){
				int a = sc.nextInt(); int b = sc.nextInt();
				if(a==1){
					stack.add(b);
					queue.add(b) ;
					priorityQueue.add(new CompareInts(b));
				}else{
					if(stack.size()==0 || b!=stack.pop()) {
						isStack = false;
					}
					if(queue.size()==0 || b!= queue.remove()){
						isQueue= false;
					}
					if(priorityQueue.size()==0|| b!= Objects.requireNonNull(priorityQueue.poll()).val){
						isPriority=false;
					}
				}
			}
			if(!isStack && !isQueue && !isPriority){
				System.out.println("impossible");
			}else if(!isStack && !isQueue){
				System.out.println("priority queue");
			}else if(!isQueue && !isPriority){
				System.out.println("stack");
			}else if(!isStack &&!isPriority){
				System.out.println("queue");
			}else{
				System.out.println("not sure");
			}
			sc.nextLine();
		}





	}
	static class CompareInts implements Comparable{
		int val;

		public CompareInts(int i) {
			val = i;
		}

		@Override
		public String toString() {
			return "CompareInts{" +
					"val=" + val +
					'}';
		}

		@Override
		public int compareTo(Object o) {
			return -val+((CompareInts)o).val;
		}
	}
	public static int[] reverse(int arr[], int l, int r){
		int temp = 0;
		for(int b = l; b<= (r-l)/2+1; b ++){
			temp = arr[b];
			arr[b]= arr[r-(b-l)];
			arr[r-(b-l)] = temp;
		}
		return arr;
	}
	public static int interesect(int x0, int y0, int x1, int y1, int x2, int y2, int x3, int y3){
		double s1x = x1-x0; double s1y = y1 - y0;
		double s2x = x3-x2; double s2y = y3 - y2;
		double s =  (-s1y * (x0 - x2) + s1x * (y0 - y2)) / (-s2x * s1y + s1x * s2y);
		double t = ( s2x * (y0 - y2) - s2y * (x0 - x2)) / (-s2x * s1y + s1x * s2y);
		if (s >= 0 && s <= 1 && t >= 0 && t <= 1)
		{

			return 1;
		}

		return 0; // No collision
	}
//	public static boolean digitsInS(int num){
//		String string = Integer.toString(num);
//		for(int i = 0; i< string.length(); i++){
//			if(!p.contains(string.substring(i, i+1))){
//				return false;
//			}
//		}
//		return true;
//	}
	static class Hi{
		public int a, b;
		public Hi(int a1, int b1){
			a = a1; b = b1;
		}
		public void combine(Hi p){
			a = Math.min(a,p.a);
			b = Math.max(b, p.b);
		}

	@Override
	public String toString() {
		return "Hi{" +
				"a=" + a +
				", b=" + b +
				'}';
	}
}
}
