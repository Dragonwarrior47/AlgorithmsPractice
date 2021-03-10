package codeforces;

import sun.nio.cs.ext.MacHebrew;

public class OptimalStrategyGame {

    public static int solveUtil1(int nums[], int l, int h, int [][] dp){

        if (l > h)
            return 0;
        if (dp[l][h] != -1)
            return dp[l][h];
        if (l == h) {
            dp[l][h] = nums[l];
            return dp[l][h];
        }
        int left_sum = nums[l] + Math.min(solveUtil1(nums, l+2, h, dp), solveUtil1(nums, l+1, h-1, dp));
        int right_sum = nums[h] + Math.min(solveUtil1(nums, l+1, h-1, dp), solveUtil1(nums, l, h-2, dp));
        dp[l][h] = Math.max(left_sum, right_sum);
        return dp[l][h];
    }

    public static int solveUtil(int nums [], int l, int h, int turn, int sum_so_far){
        if (l > h)
            return 0;
        if ( l == h && turn == 1){
            return nums[l];
        }
        else if ( l == h && turn == 0){
            return 0;
        }
        if ( turn == 1) {
            int left_sum = nums[l] + solveUtil(nums, l + 1, h, (turn + 1) % 2, sum_so_far);
            int right_sum = nums[h] + solveUtil(nums, l, h - 1, (turn + 1) % 2, sum_so_far);
            return Math.max(left_sum, right_sum);
        }
        else{
            int left_sum = solveUtil(nums,l+1,  h, (turn+1)%2, sum_so_far);
            int right_sum = solveUtil(nums, l, h-1, (turn+1)%2,  sum_so_far);
            return Math.min(left_sum, right_sum);

        }
    }
    public static int solve(int [] nums){
        int n = nums.length;
        int [][] dp  = new int[n][n];
        for (int i =0; i<n;i++){
            for (int j =0; j<n;j++){
                dp[i][j] = -1;
            }
        }
        int ans = solveUtil1(nums, 0, n-1, dp);
        return ans;
    }
    public static void main(String args[]){
        int nums [] = {8,15,3,7};
        System.out.println(solve(nums));
    }
}
