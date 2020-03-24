

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class berriessplithalf {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("berries" + ".in"));
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] trees = new int[n];
		for(int i = 0; i< n; i++){
			trees[i]= sc.nextInt();
		}
		Arrays.sort(trees);
		int leftmarker = n-k;  //only look at stuff to the right
		ArrayList<Integer> bessie = new ArrayList<>();
		ArrayList<Integer> elsie = new ArrayList<>();
		for(int i = leftmarker; i < n;i++){
			if(i< (n-k) + (k/2)){
				bessie.add(trees[i]);
			}else{
				elsie.add(trees[i]);
			}
		}
		for(int i = k/2-1; i>=0; i--){
			//scan through elsie and see if any that should be split
			if(elsie.get(i)/2 > bessie.get(0)){
				if(elsie.get(i)/2 > bessie.get(1)  && elsie.get(i)/2<elsie.get(0)){
					bessie.remove(1);
					bessie.remove(0);
					//need to find where we place the split bucket into
					int pos = 0;
					for(int j = 0; j< bessie.size(); j++){
						if(bessie.get(j)>elsie.get(i)/2){
							pos = j; // no need for -1 cause position is 0 shift
						}
					}
					bessie.add(pos,elsie.get(i)/2);
					bessie.add(pos,elsie.get(i)/2);
					elsie.remove(i);
					//but need to add bessie last value into elsie
					elsie.add(0, bessie.remove(bessie.size()-1));
				}else if(elsie.get(i)/2<elsie.get(1)){
					bessie.remove(0);
					//need to find out where elsie.get(i)/2 should be placed in bessie
					int pos = 0;
					for(int j = 0; j< bessie.size(); j++){
						if(bessie.get(j)>elsie.get(i)/2){
							pos = j;
						}
					}
					bessie.add(pos, elsie.get(i)/2);
					bessie.remove(0); //replaced by elsie smallest value
					for(int j = 0; j< bessie. size();j++){
						if(bessie.get(j)>elsie.get(0)){
							pos=j;
						}
					}
					bessie.add(pos, elsie.get(0));
					elsie.remove(0);
					//need to find where elsie.get(i)/2 should be placed in elsie
					for(int j = 0;j< elsie.size();j++){
						if(elsie.get(j)>elsie.get(i)/2){
							pos= j;
						}
					}
					elsie.add(pos,elsie.get(i)/2);
					elsie.remove(elsie.size()-1);
				}else{
					//case where need to pop 2 off elsie smallest and add .i/2 to elsie onlu
					int n1 = elsie.get(0);
					int n2 = elsie.get(1);
					boolean reverse= false;
					if(n2>n1){
						reverse = true;
					}
					int p1= 0;
					int p2= 0;
					for(int j = 0;j< bessie.size(); j++){
						if(bessie.get(j)>n1){
							p1= j;
						}
						if(bessie.get(j)>n2){
							p2= j;
						}
					}
					if(reverse){
						bessie.add(p2, n2); //in case same position but different values still in right order
						bessie.add(p1,n1);
					}else{
						bessie.add(p1,n1);
						bessie.add(p2,n2);
					}
					//look where both .i/2 belong in elsie
					int pos = 0;
					for(int j = 0; j< elsie.size(); j++){
						if(elsie.get(j)>elsie.get(i/2)){
							pos = j;
						}
					}
					elsie.add(pos,elsie.get(i/2));
					elsie.add(pos,elsie.get(i/2));
					elsie.remove(i/2+2);



				}
			}
		}
		PrintWriter out = new PrintWriter(new File("berries.out"));
		out.println(bessie);
		//System.out.println(elsie);

	}
}
