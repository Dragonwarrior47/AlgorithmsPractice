import java.util.*;


public class LookAndSay{
	public static void lookAndSay(int n){
		String s = "1";
		List<String> ans = new ArrayList<String>();
		ans.add(s);
		for(int i = 1; i<n; i++)
		{
			s = lookAndSayHelper(s);
			ans.add(s);
		}
		System.out.println(ans);
	}
	
	public static String lookAndSayHelper(String s){
		StringBuilder ans = new StringBuilder();
		int n = s.length();
		for(int i =0; i<n; i++){
			int cnt = 1;
			while((i < n-1) && (s.charAt(i) == s.charAt(i+1))){
				cnt += 1;
				i += 1;
			}
			ans.append(cnt);
			ans.append(s.charAt(i));
		}
		return ans.toString();
	}

	public static void main(String args[])
	{
		lookAndSay(10);
	}
}
