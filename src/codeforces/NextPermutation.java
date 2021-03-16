import java.util.*;


public class NextPermutation{
	
	public static List<Integer>  solve(List<Integer> arr, int n){
		int k = arr.size()-2;
		while(k >= 0 && arr.get(k)>= arr.get(k+1))
			k -= 1;
		if(k == -1){
			return Collections.emptyList();
		}
		
		for(int i = arr.size()-1; i>k; i--){
			if (arr.get(i) > arr.get(k)){
			 	Collections.swap(arr, i, k);
				break;
			}
		}
		
		Collections.reverse(arr.subList(k+1, arr.size()));
		return arr;
		
		
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i = 0; i<n; i++){
			arr.add(sc.nextInt());
		}
		List<Integer> ans = solve(arr, n);
		System.out.println(ans);
	}



}
