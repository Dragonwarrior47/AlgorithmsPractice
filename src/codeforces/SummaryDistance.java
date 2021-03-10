import java.util.Scanner;
public class SummaryDistance{
	
	public static int getDistance(int x1, int y1, int x2, int y2){
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int testCases=0; testCases<t;testCases++){
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			int ans = getDistance(x1, y1, x2, y2);
			System.out.println(ans);
		
		}
		
	
	}

}
