import java.util.*;


public class ReplaceAndRemove{

	public static void solve(){
		String s = "acca";
		char[] c = s.toCharArray();
		int n = s.length();
		int writeIndex = 0;
		int aCount = 0;
		System.out.println(Arrays.toString(c));
		for(int i =0; i<n; i++){
			if (c[i] != 'b'){
				c[writeIndex] = c[i];
				writeIndex += 1;
			}
			if (c[i] == 'a')
				aCount += 1;

		}
		
		int currentIndex = writeIndex -1;
		writeIndex = writeIndex + aCount - 1;
		int finalSize = writeIndex + 1;
		while(currentIndex >= 0)
		{
			if(c[currentIndex] == 'a'){
				c[writeIndex--] = 'd';
				c[writeIndex--] = 'd';
			}
			else
				c[writeIndex--] = c[currentIndex];
			currentIndex -= 1;
		}
		System.out.println(Arrays.toString(c));
	}
	
	public static void main(String args[]){
	
		solve();
	}
}
