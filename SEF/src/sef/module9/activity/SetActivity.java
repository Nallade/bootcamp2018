package sef.module9.activity;

//Needs to be completed
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetActivity {

	public static void main(String[] args) {
		//1 - Type code to create a set of names.
		//Names must be sorted by their natural order.
		//Do research to find if you already have such a class. 
		//Also try adding a few duplicate entries to this set.
		TreeSet<String> sample1 = new TreeSet<String>();
		sample1.add("sivens");
		sample1.add("kamis");
		sample1.add("sivens");
		sample1.add("apple");
		sample1.add("zibens");
//		//2 - Call print method to print the set passed as its parameter.
		print(sample1);
	}
	
	static void print(Set<String> a) {
		//3 - Type code to print this set
		//Notice the order in which elements get printed.
		for (String x: a) {
            System.out.println(x);
        }
	}
}
