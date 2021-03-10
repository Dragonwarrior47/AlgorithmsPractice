package codeforces;

import java.util.Scanner;

public class MoveAndTurn {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int n = sc.nextInt();
        int k;
        if (n % 2 == 0){
            k = n / 2;
            System.out.println((k+1)*(k+1));
        }
        else{
            k = n/2;
            System.out.println((k+1)*(k+2)*2);
        }
    }
}
