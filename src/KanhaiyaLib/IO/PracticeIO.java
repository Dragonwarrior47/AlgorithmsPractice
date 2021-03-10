package KanhaiyaLib.IO;

import java.util.Scanner;

public class PracticeIO {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name:");
        while (in.hasNext()) {
            System.out.println(in.next());
        }
        System.out.println("Read all the method");
        in.close();
    }
}
