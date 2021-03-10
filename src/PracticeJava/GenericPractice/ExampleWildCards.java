package PracticeJava.GenericPractice;

import java.util.ArrayList;
import java.util.List;

public class ExampleWildCards {

    private static void printList(List<?> list) {
        System.out.println(list);
    }

    public static void main(String args[]){
        List<String> stuff = new ArrayList<>();
        List<Integer> new_stuff = new ArrayList<>();
        new_stuff.add(1);
        new_stuff.add(2);
        new_stuff.add(3);
        stuff.add("Kanhaiya");
        stuff.add("Lal");
        stuff.add("yadav");
        printList(stuff);
        printList(new_stuff);
    }
}
