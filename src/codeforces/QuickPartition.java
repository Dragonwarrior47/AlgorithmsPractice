import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;


public class QuickPartition{
	
	public static int findKthSmallest(List<Integer> arr, int k){
		int n = arr.size();
		int l = 0;
		int r = n -1;
		int pos = partition(arr, l, r);
		while (pos != k-1){
			if (pos > k-1){
				pos = partition(arr, l, pos-1);
			}
			else if (pos < k-1)
				{
					pos = partition(arr, pos+1, r);
				}
			else
				break;
		}
		return arr.get(pos);
		
	}
	public static int partition(List<Integer> arr, int l, int r){
		Random gen = new Random();
		int pivotIndex = gen.nextInt(r-l+1) + l;
		int pivotValue = arr.get(pivotIndex);
		Collections.swap(arr, pivotIndex, r);
		
		for(int i =l; i<r; i++)
		{
			if(arr.get(i) < pivotValue){
				Collections.swap(arr, i, l);
				l += 1;
			}
		}
		Collections.swap(arr, l, r);
		return r;
	}
	
	public static void solve(int pivotIndex, List<Integer> arr){
		int pivot = arr.get(pivotIndex);
		int smaller = 0;
		int larger = arr.size()-1;
		int n = arr.size();
		System.out.println(arr);
		for (int i = 0; i<n ;i++){
			if(arr.get(i) < pivot){
				Collections.swap(arr, smaller, i);
				smaller += 1;
			}
		}
		for (int i =arr.size()-1; i>=0; i--){
			if(arr.get(i)> pivot){
				Collections.swap(arr, larger, i);
				larger -= 1;
			}	
		
		}
		System.out.println(arr);	
		
		
	}
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i = 0; i<n ;i++)
			arr.add(sc.nextInt());
		//solve(pivotIndex, arr);
		int ans = findKthSmallest(arr, k);
		System.out.println(arr);
		System.out.println(ans);
	}	
}
