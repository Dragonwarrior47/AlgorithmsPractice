package codeforces;

import java.util.Arrays;
import java.util.Scanner;

public class CircleGame {
    public static final Scanner sc  = new Scanner(System.in);
    public int is_won(int x, int y, int k, long d, int turn, int [][][] dp){
        if (dp[x][y][turn] != -1)
            return dp[x][y][turn];
        int tmpX = x + k;
        int tmpY = y + k;
        if ((tmpX*tmpX + y*y>d*d) && ( x*x + tmpY*tmpY > d*d)){
            dp[x][y][turn] = (turn+1)%2;
            return (turn+1)%2;
        }
        else{
            int p1= tmpX*tmpX>d*d?((turn+1)%2):is_won(tmpX, y, k,d, (turn+1)%2, dp);
            int p2= tmpY*tmpY>d*d?((turn+1)%2):is_won(x, tmpY, k,d, (turn+1)%2, dp);
            if (p1 == turn || p2 == turn){
                dp[x][y][turn] = turn;
                return turn;
            }
            else{
                dp[x][y][turn] = (turn+1)%2;
                return (turn + 1)%2;
            }
        }

    }
    public void solve(){
        int t = sc.nextInt();
        while (t > 0){
            long d = sc.nextLong();
            int k = sc.nextInt();
            int [][][] dp = new int[401][401][2];
            for (int i = 0; i<= 400; i++){
                for(int j = 0; j<=400; j++){
                    for (int h=0; h<2; h++){
                        dp[i][j][h] = -1;
                    }
                }
            }
//            Arrays.fill(dp, -1);
            int turn = 0;
            turn = is_won(0, 0, k, d, 0, dp);
            if (turn == 0){
                System.out.println("Ashish");
            }
            else{
                System.out.println("Utkarsh");
            }
        }
        t -= 1;
    }
    public static void main(String args[]){
        CircleGame cg = new CircleGame();
        cg.solve();

    }
}
