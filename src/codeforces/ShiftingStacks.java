import java.util.Scanner;

public class ShiftingStacks{
	
	public static void main(String args[]){
			
			Scanner sc = new Scanner(System.in);
			int t = sc.nextInt();
			
			for(int testCases=0; testCases<t; testCases++){
				int n = sc.nextInt();
				long currentValue = 0;
				boolean isPossible = true;
				for(int i =0; i<n; i++){
					long tmp = (long)sc.nextInt() + currentValue;
					if ( tmp < i){
						isPossible = false;	
					}
					currentValue = tmp - (long)i;
				}
				if(isPossible)
					System.out.println("YES");
				else
					System.out.println("NO");
				
				}		
		
		}		



}
