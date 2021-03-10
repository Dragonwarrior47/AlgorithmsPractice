package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


class Solution {
    public static void main(String args[]) {
        Solution solution = new Solution();
        int[] difficulty = {23,30,35,35,43,46,47,81,83,98};
        int[] profit = {8,11,11,20,33,37,60,72,87,95};
        int[] worker = {95,46,47,97,11,35,99,56,41,92};
        solution.maxProfitAssignment(difficulty, profit, worker);
    }

    public int lastPosition(List<Pair> dpPair, int x, int n){
        int l = 0;
        int h = n-1;
        int lastPosition = -1;
        while ( l <= h){
            int m = l + ( h - l) /2 ;
            if ( dpPair.get(m).getD() <= x){
                lastPosition = m;
                l = m + 1;
            }
            else{
                h = m - 1;
            }
        }
        return lastPosition;
    }
    public int first_position(List<Pair> dpPair, int target, int n){
        int first_position = n;
        int l = 0;
        int h = n-1;
        while (l <= h){
            int mid = l +  ( h - l)/2;
            if ( dpPair.get(mid).getD() >= target){
                first_position = mid;
                h = mid -1;

            }
            else
            {
                l = mid + 1;
            }
        }
        return first_position;

    }

    public int binarySearch(List<Pair> dpPair, int target, int l, int h){
        if ( l > h){
            return -1;
        }
        int mid = l + (h-l)/2;
        if (target < dpPair.get(mid).getD()){
            if (l == mid){
                return l -1;
            }
            return binarySearch(dpPair, target, l, mid-1);
        }
        else if (target > dpPair.get(mid).getD()){
            if ( mid == h){
                return mid;
            }
            return binarySearch(dpPair, target, mid+1, h);
        }
        else
        {
            return mid;
        }


    }

    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<Pair> dpPair = new ArrayList<>();
        int n = difficulty.length;
        if (n < 0)
            return 0;
        for (int i = 0; i < n; i++) {
            dpPair.add(new Pair(difficulty[i], profit[i]));
        }


        Collections.sort(dpPair,(Pair first, Pair second)->{
            if (first.getD() == second.getD()){
                return first.getD() - second.getD();
            }
            else
                return first.getP() - second.getP();
        });
        for (Pair p : dpPair) {
            System.out.println(p);
        }
        int [] max_so_far = new int[n];
        int current_max = dpPair.get(0).getP();
        max_so_far[0] = current_max;
        for (int i =1; i<n; i++){
            if ( current_max < dpPair.get(i).getP()){
                current_max = dpPair.get(i).getP();
            }
            max_so_far[i] = current_max;
        }
        for(int a: max_so_far){
            System.out.println(a);
        }
        int ans = 0;
        for (int w:worker){
            int ndx = lastPosition(dpPair, w, n);
            System.out.println(String.format("ndx=%s, worker=%s", ndx, w));
            if ( ndx >= 0){
                ans += max_so_far[ndx];
            }
        }
        System.out.println(ans);
        return ans;


    }

    public static class Pair  {
        private int d;
        private int p;

        Pair(int difficulty, int profit) {
            this.d = difficulty;
            this.p = profit;
        }

        public int getD() {
            return this.d;
        }

        public int getP(){
            return this.p;
        }


        @Override
        public String toString() {
            return String.format("{difficulty:%s, profit:%s}", this.d, this.p);
        }
    }
}
