package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class GraphHalfFilled {
    public static Scanner sc = new Scanner(System.in);
    public static int  MAXSIZE = 10005;
    public static void main(String args[]){
        int n = sc.nextInt();
        int [] arr = new int[n];
        int [] cap = new int[n];
        int total = 0;
        for (int i =0; i<n; i++){
            cap[i] = sc.nextInt();
            arr[i] = sc.nextInt();
            total += arr[i];
        }
        int [][][] dp = new int[n+1][n+1][MAXSIZE];
        for (int i = 0; i<n; i++){
            for (int j = 0; j<n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i< n; i++){
            for (int j = 0; j< n; j++){
                for (int k = 0; k< MAXSIZE; k++){
                    if (dp[i][j][k] == -1)
                        continue;
                    dp[i+1][j][k] = Math.max(dp[i+1][j][k], dp[i][j][k]);
                    if (k + cap[i] < MAXSIZE)
                        dp[i+1][j+1][k+cap[i]] = Math.max(dp[i+1][j+1][k+cap[i]], dp[i][j][k]+arr[i]);
                }
            }
        }

        StringBuilder ans = new StringBuilder();
        for (int j=1; j<=n; j++){
            double max = 0;
            for (int k = 0; k< MAXSIZE; k++){
                if ( dp[n][j][k] != -1){
                    max = Math.max(max, Math.min(k, (double) total/2.0+ ((double) dp[n][j][k]/2.0)));
                }

            }
            ans.append(max+" ");

        }
        System.out.println(ans);


    }
}
