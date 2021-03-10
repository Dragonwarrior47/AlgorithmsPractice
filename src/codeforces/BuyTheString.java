package codeforces;

import java.util.Scanner;

public class BuyTheString {

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =0; i<t; i++){
            int n = sc.nextInt();
            int c0 = sc.nextInt();
            int c1  = sc.nextInt();
            int h = sc.nextInt();
            int cnt0=0;
            int cnt1=0;
            String line = sc.next();
            for (int j =0; j < n; j++){
                if(line.charAt(j) == '0')
                    cnt0 += 1;
                else
                    cnt1 += 1;
            }
//            System.out.println(""+cnt0*c0+cnt1*c1+","+c0*n + h*cnt1+","+c1*n+h*cnt0);
            int ans = Math.min(Math.min(cnt0*c0+cnt1*c1, c0*n + h*cnt1), c1*n+h*cnt0);
            System.out.println(ans);


        }

    }
}
