package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class OccuurenceOf2s
{
    public static void main(String args[]){

    }
    public static List<Long> dp = new ArrayList<>();
    OccuurenceOf2s(){
        dp.add(0L);
        dp.add(0L);
        dp.add(1L);
        for (int i = 3; i< 100000+5; i++){

            long current2s = count2Util(i);
            System.out.println(current2s);
            dp.add(dp.get(i-1)+current2s);
        }
    }
    public static long count2Util(long n){
        long ans = 0L;
        while (n > 0){
            if ( ans % 10 == 2){
                ans += 1L;
            }
            n = n / 10;
        }
        return ans;
    }
    public static long count2s(long n)
    {
        return (long)dp.get((int)n);
    }

}
