package PracticeProblems;

import sun.nio.cs.ext.MacHebrew;

import java.util.Scanner;

public class RMQ {
    int n;
    int [] t;
    RMQ(int n){
        this.t = new int[4*n];
    }

    public void buildRMQ(int a[], int i, int tl, int tr){
        if ( tl == tr){
            this.t[i] = a[tl];
        }
        else{
            int tm = (tl + tr)/2;
            buildRMQ(a, 2*i+1, tl, tm);
            buildRMQ(a, 2*i + 2, tm +1, tr);
            this.t[i] = Math.min(this.t[2*i + 1], this.t[2*i + 2]);

        }

    }
    public  int queryRMQ(int i, int tl, int tr, int l, int r){
        if (l > r){
            return Integer.MAX_VALUE;
        }
        if (l == tl && r == tr){
            return this.t[i];
        }
        int tm = (tl + tr)/2;
        int left_min = queryRMQ(2*i + 1, tl, tm, l, Math.min(tm, r));
        int right_min = queryRMQ(2*i + 2, tm + 1, tr, Math.max(tm + 1, l), r);
        return Math.min(left_min, right_min);

    }

    public void updateRMQ(int i, int tl, int tr, int pos, int new_val){
        if (tl == tr){
            this.t[i] = new_val;
        }
        else{
            int tm = (tl + tr)/2;
            if (pos <= tm){
                updateRMQ(2*i + 1, tl, tm, pos, new_val);
            }
            else{
                updateRMQ(2*i + 2, tm + 1, tr, pos, new_val);
            }
            this.t[i] = Math.min(this.t[2*i + 1], this.t[2*i+ 2]);
        }
    }

    public  static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n, q;
        int l, r;
        n = sc.nextInt();
        q = sc.nextInt();
        int a[] = new int[n];
        for(int i=0; i< n; i++){
            a[i] = sc.nextInt();
        }
        RMQ rmq = new RMQ(n);
        rmq.buildRMQ(a, 0, 0,n-1);
        for (int i = 0; i<q; i++){
            String query = sc.next();
            l = sc.nextInt();
            r = sc.nextInt();
            if (query.equals("q")) {
                int ans = rmq.queryRMQ(0, 0, n - 1, l-1, r-1);
                System.out.println(ans);
            }
            else{
                rmq.updateRMQ(0, 0, n-1, l-1, r);
            }
        }
    }
}
