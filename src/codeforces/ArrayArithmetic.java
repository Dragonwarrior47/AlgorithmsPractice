import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ArrayArithmetic{
	
	public static void solve(List<Integer> arr){
		int n = arr.size()-1;
		arr.set(n, arr.get(n)+1);
		for(int i =n; i>0 && arr.get(i) == 10; i--){
			arr.set(i, 0);
			arr.set(i-1, arr.get(i-1)+1);
		}
		
		if(arr.get(0) == 10){
			arr.set(0, 0);
			arr.add(0, 1);
		}
		System.out.println(arr);
	}
	
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i =0; i<t; i++){
			int n = sc.nextInt();
			List<Integer> arr = new ArrayList<>();
			for(int j = 0; j<n; j++){
				arr.add(sc.nextInt());
			}
			solve(arr);
		}
		//solve(arr);
	}	


}
