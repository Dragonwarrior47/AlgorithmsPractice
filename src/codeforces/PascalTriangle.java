import java.util.*;


public class PascalTriangle{

	public static List<List<Integer>> solve(int n){
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> prev = new ArrayList<>();
		prev.add(1);
		for(int i = 1; i <=n ; i++)
		{
			List<Integer> tmp = new ArrayList<>();
			tmp.add(prev.get(0));
			for(int j=1; j<prev.size(); j++){
				tmp.add(prev.get(j) + prev.get(j-1));
			}
			tmp.add(prev.get(prev.size()-1));
			ans.add(tmp);
			prev = tmp;
		}
		return ans;
	}
	public static void printPascal(List<List<Integer>> arr){
		for(List<Integer> a: arr)
			System.out.println(a);	
	}
	public static void main(String args[]){
		Scanner sc  = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>> ans = solve(n);
		printPascal(ans);
	}
}
