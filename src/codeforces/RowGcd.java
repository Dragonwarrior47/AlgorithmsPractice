//package codeforces;

import java.util.Scanner;

public class RowGcd {
    public static Scanner sc = new Scanner(System.in);
    public long gcd(long a, long b){
        if ( a > b){
            return gcd(b, a);
        }
        if ( a == 0)
            return b;
        return gcd(b %a, a);
    }
    public static void main(String args[]){
        RowGcd rgcd = new RowGcd();
//        long u = rgcd.gcd(-1, 2);
        int n  = sc.nextInt();
        int m = sc.nextInt();
        long a[] = new long[n];
        long b[] = new long[m];
        for (int i = 0; i<n; i++){
            a[i] = sc.nextLong();
        }
        for (int i =0; i<m; i++){
            b[i] = sc.nextLong();
        }
        if (n < 2)
            for (int i =0; i<m; i++){
                System.out.print(a[0]+b[i]+ " ");
            }
        else{
            long g = Math.abs(a[1]-a[0]);
            for (int i =2; i<n; i++){
                g = rgcd.gcd(g, Math.abs(a[i]-a[i-1]));

            }
            for (int i =0; i<m; i++){
                long ans = rgcd.gcd(a[0]+b[i], g);
                System.out.print(ans+" ");

            }
        }


    }
}
