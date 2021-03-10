package DataStructures;

import PracticeProblems.MajorityElement;

import java.util.Scanner;

public class SegmentTree {
    int n;
    int t[];
    SegmentTree(int n){
        this.n = n;
        this.t = new int[4*n];
    }

    public void buildST(int a[], int i, int tl, int tr){
        if( tl == tr){
            this.t[i] = a[tl];
        }
        else{
            int tm = (tl + tr)/2;
            buildST(a, 2*i +1, tl, tm);
            buildST(a, 2*i +2 , tm + 1, tr);
            this.t[i] = this.t[2*i+1] + this.t[2*i + 2];
        }

    }

    public int sumST(int i, int tl, int tr, int l, int r){
        if ( l > r){
            return 0;
        }
        if (l == tl && r == tr){
            return this.t[i];
        }
        int tm = (tl + tr) / 2;
        return sumST(2*i +1, tl, tm, l, Math.min(tm, r)) + sumST(2*i + 2, tm +1, tr, Math.max(tm + 1, l),r);

    }

    public void updateST(int i, int tl,int tr, int pos, int new_val){
        if ( tl == tr){
            this.t[i] = new_val;
        }
        else{
            int tm = ( tl + tr)/ 2;
            if ( pos <= tm){
                updateST(2*i + 1, tl, tm, pos, new_val);
            }
            else{
                updateST(2*i + 2, tm +1, tr, pos, new_val);
            }
            this.t[i] = this.t[2*i + 1] + this.t[2*i + 2];
        }


    }

    public static void printArray(int [] arr){
        for(int val: arr){
            System.out.println(val+" ");
        }
        System.out.println();
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i =0; i<t; i++){
            int n = sc.nextInt();
            int input[] = new int[n+1];
            for (int j =0;j<n;j++){
                input[j] = sc.nextInt();
            }
            SegmentTree st = new SegmentTree(n);
            st.buildST(input, 0, 0, n - 1);
            for (int j = 0; j<100;j++) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                if (j%2==0) {
                    int ans = st.sumST(0, 0, n - 1, l, r);
                    System.out.println(ans);
                }
                else{
                    input[l] = r;
                    st.updateST(0, 0, n-1, l, r);
                }
            }
        }
    }
}
