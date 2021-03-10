import java.util.Scanner;

public class SwapBits{
	
	public static int solve(int n, int i, int j){
		if( ((n>>i) & 1) != ((n>>j)&1)){
			int mask = (1<<i) | (1<<j);
			return n^mask;
		}
		return n;
	}
	public static int countBits(int n){
		int ans = 0;
		while (n > 0){
			n >>= 1;
			ans += 1;
		}
		return ans;
	}
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int t  = sc.nextInt();
		for(int p =0; p<t; p++){
			int n = sc.nextInt();
			int tmp = n;
			//int a = sc.nextInt();
			//int b = sc.nextInt();
			int l = countBits(tmp);
			for(int i =0,j=l-1; i < j; i++, j--)
				tmp = solve(tmp, i, j);
			
			System.out.println(String.format("Before masking: %s",Integer.toBinaryString(n)));
			//int ans = solve(n, a, b);
			System.out.println(String.format("After masking: %s", Integer.toBinaryString(tmp)));
		}
	}

}
