package PracticeJava.CollectionsPractice;

import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String args[]){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(1278); // G. Hopper
        pq.add(89); // A. Lovelace
        pq.add(938); // J. von Neumann
        pq.add(2387932); // K. Zuse
        System.out.println("Iterating over elements . . .");
        for (Integer date : pq)
            System.out.println(date);
        System.out.println("Removing elements . . .");
        while (!pq.isEmpty())
            System.out.println(pq.remove());
    }
}
