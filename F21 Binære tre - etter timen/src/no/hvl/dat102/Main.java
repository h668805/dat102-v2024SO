package no.hvl.dat102;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {
	public static void main(String[] args) {
		/*
   		Konstruerer eit binært tre som ser slik ut
  
           7
          / \
         5   1
         	/
           0
        
	 	*/
		BinaerTre<Integer> t1 = new BinaerTre<>(0);
		BinaerTre<Integer> t2 = new BinaerTre<>(5);
		BinaerTre<Integer> t3 = new BinaerTre<>(1, t1, null);
		BinaerTre<Integer> t4 = new BinaerTre<>(7, t2, t3);
		
		/*
		
		   2
		  / \
		 3   8
		 
		*/
		BinaerTre<Integer> t5 = new BinaerTre<>(3);
		BinaerTre<Integer> t6 = new BinaerTre<>(8);
		BinaerTre<Integer> t7 = new BinaerTre<>(2, t5, t6);
		
		BinaerTre<Integer> t8 = new BinaerTre<>(9, t4, t7);

		t8.visPreorden();
		t8.visInorden();
		t8.visPostorden();
		
		System.out.println(t8.soek(3));
		System.out.println(grense(t8, 7));
		Iterator<Integer> iterator = t8.getPreordenIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}
	
	private static ArrayList<Integer> grense(BinaerTre<Integer> tre, int i) {
		ArrayList<Integer> liste = new ArrayList<>();
		Iterator<Integer> iterator = tre.getInordenIterator();
		while (iterator.hasNext()) {
			int e = iterator.next();
			if (e < i) {
				liste.add(e);
			}
		}
		return liste;
	}
}
