package PracticeJava.GenericPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class LowerBoundWildCard {

    public static void printList(List<?> list){
        System.out.println(list);
    }
    public static void numsUpTo(Integer num, List<? super Integer> output) {
        IntStream.rangeClosed(1, num)
                .forEach(output::add);
    }
    public static void main(String args[]){
        ArrayList<Integer> integerList = new ArrayList<>();
        ArrayList<Number> numbersList = new ArrayList<>();
        numsUpTo(5, integerList);
        numsUpTo(5, numbersList);
        printList(integerList);
        printList(numbersList);
    }
}

class Tree{
    int data;
    Tree left, right, random;
    Tree(int d){
        data = d;
        left = null;
        right= null;
        random = null;
    }
}
