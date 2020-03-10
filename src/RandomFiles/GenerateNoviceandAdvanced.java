package RandomFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class GenerateNoviceandAdvanced {
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(new File("input.txt"));
		ArrayList<String> adv = new ArrayList<String>();
		ArrayList<String> nov = new ArrayList<String>();
		while(sc.hasNextLine()){
			String str = sc.nextLine()+"\t";
			//System.out.println(str);
			if(Integer.parseInt(str.split("\\t")[1].substring(4))>40)
				adv.add(str);
				else
					nov.add(str);
		}
		for(String s:adv)
			System.out.println(s);
		System.out.println("/n/n/n/n/n/n/n/n/n/n/n");
		for(String st:nov)
			System.out.println(st);
	}
}
