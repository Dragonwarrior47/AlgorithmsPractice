package LeetCode;

import java.util.Arrays;

public class SolutionBurstBalloons {
    public int maxCoins(int[] A) {
        int n = A.length;
        if (n < 1){
            return 0;
        }
        int [][] dp = new int [n][n];

        for (int l = n-1; l>=0; l--){
            for( int r= l; r<n; r++){
                for (int i = l; i<=r; i++){
                    dp[l][r] = Math.max(dp[l][r],
                            (l>0?A[l-1]:1)*A[i]*(r==n-1?1:A[r+1])
                                    + (i-1<l?0:dp[l][i-1])
                                    +(r+1>n-1?0:dp[i+1][r])
                    );

                    System.out.println("****************("+l+","+i+","+r+")*******************");
                    for(int []arr: dp){
                        System.out.println(Arrays.toString(arr));
                    }
                    System.out.println("******************************************");
                }
            }
        }
        return dp[0][n-1];

    }
    public static void main(String args[]){
        int [] nums = {1,2};
        SolutionBurstBalloons sol = new SolutionBurstBalloons();
        sol.maxCoins(nums);

    }
}