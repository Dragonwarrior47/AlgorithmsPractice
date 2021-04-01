import java.util.*;


public class SubsetOfSizeK{
	
	public static void solve(int n , int k){
		List<List<Integer>> result = new ArrayList<>();
		helper(0, n,k, new ArrayList<Integer>(), result);
		System.out.println(result.size());
		System.out.println(result);
	}
	
	public static void helper(int offset, int n, int k, List<Integer> partialSubset, List<List<Integer>> result){
		//System.out.println(partialSubset);
		if (partialSubset.size()==k){
			result.add(new ArrayList<Integer>(partialSubset));
			return;
			}
		int remainingElement = k - partialSubset.size();
		for(int i = offset; i<n && remainingElement<=n-i+1; i++){
			partialSubset.add(i);
			helper(offset+1, n, k, partialSubset, result);
			partialSubset.remove(partialSubset.size()-1);
		}
	
	}
	public static void main(String args[]){
		solve(3,2);
	}
}

