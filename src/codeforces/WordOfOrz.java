package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class WordOfOrz {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int t = sc.nextInt();
        for (int i =0; i<t; i++){
            int n = sc.nextInt();
            int [] ans = new int[n];
            int current = 8;
            ans[0] = 9;
            for (int j =1; j<n;j++){
                    ans[j] = current%10;
                    current += 1;
            }
            for (int val: ans)
            System.out.print(val);
            System.out.println();
        }
    }
}
