package PracticeProblems;

import java.util.Scanner;

public class MajorityElement {
    public int findMajority(int arr[], int n) {
        int count = 0;
        int element = -1;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                element = arr[i];
                count += 1;
            } else {
                if (arr[i] == element) {
                    count += 1;

                }
                else{
                    count -=1;
                }
            }
        }
        int element_count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == element) {
                element_count += 1;
            }
        }
        return element_count > n / 2 ? element : -1;

    }

    public static void main(String ars[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            MajorityElement me = new MajorityElement();
            int ans = me.findMajority(arr, n);
//            for (int j = 0; j < n; j++) {
//                System.out.print(arr[j] + " ");
//            }
            System.out.println(ans);
        }
    }
}
