package PracticeJava;

import java.lang.reflect.Array;
import java.util.Arrays;

public class PracticeArray {

    public static void main(String args[]){

        int [] arr;
        arr = new int[]{5, 4, 3, 2, 1};
        Arrays.sort(arr);
        for (int i = 0; i <4 ; i++)
            System.out.println("value of array at index=" +i + ", is = " + arr[i]);
    }
}
