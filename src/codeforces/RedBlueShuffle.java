package codeforces;

import java.util.Scanner;

public class RedBlueShuffle {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        int t = sc.nextInt();
        for(int testCases=0; testCases<t; testCases++){
            int n = sc.nextInt();
            int r[] = new int[n];
            int b[] = new int[n];
            String rs = sc.next();
            String bs = sc.next();
            for (int j = 0; j<n; j++){
                r[j] = rs.charAt(j) - '0';
            }
            for (int j = 0; j<n;j++){
                b[j] = bs.charAt(j) - '0';
            }
            int red_count = 0;
            int blue_count = 0;
            for (int i = 0; i<n; i++){
                if (r[i] > b[i]){
                    red_count += 1;
                }
                else if (r[i] < b[i]){
                    blue_count += 1;
                }
            }
            if ( red_count > blue_count)
                System.out.println("RED");
            else if (red_count < blue_count)
                System.out.println("BLUE");
            else
                System.out.println("EQUAL");


        }
    }
}
