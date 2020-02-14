import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

class word{
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("word.in"));
		PrintWriter out = new PrintWriter(new File("word.out"));
		int n = sc.nextInt();
		int k = sc.nextInt();
		String bob[] = new String[n];
		sc.nextLine();
		for(int i = 0; i< n; i++){
			bob[i]= sc.next();
		}

		int x= 0;
		int i= 0;
		while(i<n){
				if ((bob[i].length() + x) <= k) {
					if(x==0){
						out.print(bob[i]);
					}
					else{
						out.print(" " + bob[i]);
					}
					x += bob[i].length();
				}
				else {
					x = bob[i].length();
					out.println();
					out.print(bob[i]);
				}
				i++;

		}
		out.close();

	}
}
