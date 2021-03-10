//package codeforces;

import java.util.Scanner;

public class BouncingBalls {
    public static final Scanner sc = new Scanner(System.in);

    public static void main(String args[]){
        Solver solver = new Solver();
        solver.solve();

    }
    private static class Solver{
        private void solve(){
            int t = sc.nextInt();
            while (t > 0){
            solveOne();
            t -= 1;

            }
        }

        private void solveOne(){
            int n = sc.nextInt();
            int p = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            int x = sc.nextInt();
            int y = sc.nextInt();
            int [] cp = new int[n+1];
            for (int i = p; i<=n; i++){
                cp[i] = y*(i-p);
                if ( i - k >= p){
                    cp[i] = Math.min(cp[i], cp[i-k]);
                }
                if (s.charAt(i-1) == '0'){
                    cp[i] += x;
                }
            }
            int ans = Integer.MAX_VALUE;
            for (int i = Math.max(n-k+1, p); i<=n; i++){
                ans = Math.min(cp[i], ans);
            }
            System.out.println(ans);
        }
    }
}
