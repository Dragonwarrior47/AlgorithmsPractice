import java.util.*;


public class BaseConversion{
	
	public static String constructFromBase2(int numAsInt, int base){
		StringBuilder sb = new StringBuilder();
		int tmp = numAsInt;
		while (tmp > 0){
		
			if(tmp % base >= 10){
				char c = (char)('A' + (tmp%base-10));	
				sb.append(c);
			}
			else
				sb.append((char)('0'+(tmp%base)));
			tmp = tmp/base;
			
		}
		return sb.reverse().toString();
	}
	public static String constructFromBase(int numAsInt, int base){
		return numAsInt == 0 ? "0": constructFromBase(numAsInt/base, base)+ (char)(numAsInt%base>=10?'A'+numAsInt%base-10: '0'+numAsInt%base);		
	}

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		while(testCases-- > 0){
			int n = sc.nextInt();
			int base = sc.nextInt();
			String ans = constructFromBase(n, base);
			String ans2 = constructFromBase2(n, base);
			System.out.println(String.format("ans1=%s, ans2=%s", ans, ans2));
		
		}
	}

}
