import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;

public class QuickPartition{
	
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
		int pivotIndex = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i = 0; i<n ;i++)
			arr.add(sc.nextInt());
		solve(pivotIndex, arr);
	}	
}
