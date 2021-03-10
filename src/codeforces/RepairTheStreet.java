package codeforces;

import java.util.Scanner;

public class RepairTheStreet {

    public static int solve(int arr[], int n, int k){
        int ans = Integer.MAX_VALUE;
        for (int i =1; i <=100; i++){
            int min_so_far = 0;
            int j = 0;
            while ( j < n){
                if(arr[j] != i){
                    min_so_far += 1;
                    j += k;
                }
                else
                {
                    j += 1;
                }
            }
            ans = Math.min(ans, min_so_far);
        }

        return ans;
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i<t; i++){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int j =0; j< n; j++){
                arr[j] = sc.nextInt();
            }
            int ans = RepairTheStreet.solve(arr, n, k);
            System.out.println(ans);
        }
    }
}
