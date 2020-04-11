import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

public class Kattis {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int n = sc.nextInt();
			Stack<Integer> stack = new Stack<>(); boolean isStack = true;
			Queue<Integer> queue = new LinkedList<>(); boolean isQueue = true;
			PriorityQueue<CompareInts> priorityQueue = new PriorityQueue<>(); boolean isPriority = true;
			for (int i = 0; i < n; i++) {
				int command = sc.nextInt(); int val = sc.nextInt();
				if(command==1){
					stack.add(val);
					queue.add(val) ;
					priorityQueue.add(new CompareInts(val));
				}else{
					if(stack.size()==0 || val!=stack.pop()) {
						isStack = false;
					}
					if(queue.size()==0 || val!= queue.remove()){
						isQueue= false;
					}
					if(priorityQueue.size()==0|| val!= Objects.requireNonNull(priorityQueue.poll()).val){
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
			if(sc.hasNextLine()) sc.nextLine();
		}
	}
	static class CompareInts implements Comparable{
		int val;

		public CompareInts(int i) {
			val = i;
		}

		@Override
		public String toString() {
			return "" +val;
		}

		@Override
		public int compareTo(Object o) {
			return -val+((CompareInts)o).val;
		}
	}
}