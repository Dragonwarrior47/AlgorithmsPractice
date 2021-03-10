package PracticeJava.CollectionsPractice;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTest {

    public static void main(String args[]){
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");
        a.add("Penny");
        a.add("Jodi");

        List<String> b = new LinkedList<String>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");
        System.out.println(b.get(1));
        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();


    }
}
