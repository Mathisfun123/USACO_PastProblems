package RandomFiles;

import java.util.Iterator;
import java.util.TreeSet;

public class OOP_concepts {
	public static void main(String[] args) {

		// creating a TreeSet
		TreeSet<Integer> treeadd = new TreeSet<Integer>();

		// adding in the tree set
		treeadd.add(1);
		treeadd.add(13);
		treeadd.add(17);
		treeadd.add(2);

		// create ascending iterator
		Iterator iterator= treeadd.iterator();

		// displaying the Tree set data
		System.out.println("Tree set data in ascending order: ");
		while (iterator.hasNext()) {
			System.out.println(iterator.next() + " ");
		}
		System.out.println(treeadd);
	}
}