import java.util.*;


public class GeneratePermutation{
	
	public static void nextPermutation(List<Integer> arr){
		int n = arr.size();
		int i = n - 2;
		while(i>= 0 && arr.get(i) >= arr.get(n-1)){
			i -= 1;
		}
		if ( i >= 0){
			Collections.swap(arr, i, n-1);
			Collections.reverse(arr.subList(i+1, n));
		}
		System.out.println(arr);
	}	
	public static void generate(List<Integer> arr,int index){
		int n = arr.size();
		if (n == index)
			System.out.println(arr);
		for(int j=index; j<n; j++)
		{	
			Collections.swap(arr, index, j);
			generate(arr, index+1);
			Collections.swap(arr, index, j);
		} 
		
	}
	public static void main(String args[]){
		List<Integer> arr = new ArrayList<>(List.of(2,3,7,5,8));
		//generate(arr, 0);
		nextPermutation(arr);
	}

}
