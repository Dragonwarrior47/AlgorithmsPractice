import java.util.Scanner;
import java.util.Arrays;
import java.util.HashSet;


public class NumberClassifier{
	
	public static void swap(int[] arr, int i , int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j]  = tmp;
	
	}
	
	public static int[] solve(int n, int [] arr, int pivot){
		int smaller =0; 
		int equal = 0;
		int larger = n;
		while(equal < larger){
			if(arr[equal] < pivot){
				swap(arr, smaller, equal);
				smaller += 1;
				equal += 1;
			}
			else if (arr[equal] == pivot){
				equal += 1;
			}
			else{	//larger -= 1;
				swap(arr, equal, --larger);
				//larger -= 1;
			}
		
		}
		return arr;
			
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0; i<t; i++){
			int n = sc.nextInt();
			int pivot1 = sc.nextInt();
			int pivot2 = sc.nextInt();
			int [] arr = new int[n];
			for(int j=0;j<n;j++){
				arr[j] = sc.nextInt();
			}
			int ans [] = solve(n, arr, pivot1);
			solve(n, ans, pivot2);
			System.out.println(Arrays.toString(ans));
			
		}
	}
}
