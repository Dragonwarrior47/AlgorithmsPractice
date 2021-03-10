package PracticeJava.GenericPractice;

import java.util.ArrayList;
import java.util.List;

public class UpperBoundedWildCards {

    private static void printList(List<? extends Number> list) {
        System.out.println(list);
    }

    private static double sumList(List<? extends Number> list) {
        return list.stream()
                .mapToDouble(Number::doubleValue) // returns DoubleStream
                .sum();
    }

    public static void main(String ars[]){
        List<String> stuff = new ArrayList<>();
        List<Double> new_stuff = new ArrayList<>();
        new_stuff.add(1.0);
        new_stuff.add(2.0);
        new_stuff.add(3.0);
        printList(new_stuff);
        System.out.println(sumList(new_stuff));
    }
}
