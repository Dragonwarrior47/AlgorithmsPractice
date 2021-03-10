//package codeforces;

import java.util.Scanner;

public class SumOfMedians {

    public static int round_up(double val){
        double new_val = (double) ((int)(val));
        if (val > new_val)
        {
            return (int)(val + 1);
        }
        return (int)(val);

    }

    public static void main(String args[]){

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++){

            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr [] = new int[n*k];
            int ans = 0;
            for ( int j =0; j<n*k; j++){
                arr[j] = sc.nextInt();
            }
            double med;
            med = round_up(((double)(n))/2);
            int greater_element = n - (int)med;
            int count = 0;
            for(int l=n*k-1-greater_element; l>=0 && count < k; l=l-greater_element-1){
                System.out.println("l="+l+", arr[l]="+arr[l]);
                ans += arr[l];
                count +=1;
            }
            System.out.println(ans);
        }
    }
}
