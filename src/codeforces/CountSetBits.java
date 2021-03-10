import java.util.Scanner;

public class CountSetBits {
	

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans = 0;
		while (n > 0){
			ans += 1;
			n = n^(n&(-n));
		}		
		
		System.out.println(ans);
	}

}
