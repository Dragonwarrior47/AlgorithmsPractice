import java.util.*;


public class RotateArray{
	public static void printMatrix(List<List<Integer>> matrix){
		for(List<Integer>arr: matrix)
			System.out.println(arr);
			System.out.println();
	}
	public static void solve(List<List<Integer>> arr){
		printMatrix(arr);
		int n = arr.size();
		
		for(int i =0; i<n/2; i++){
			for(int j = i; j<n-i-1; j++){
				
				int tmp1 = arr.get(i).get(j);
				int tmp2 = arr.get(j).get(n-i-1);
				int tmp3 = arr.get(n-i-1).get(n-j-1);
				int tmp4 = arr.get(n-j-1).get(i);
				
				arr.get(j).set(n-i-1, tmp1);
				arr.get(n-i-1).set(n-j-1, tmp2);
				arr.get(n-j-1).set(i, tmp3);
				arr.get(i).set(j, tmp4);
			}
		}
		printMatrix(arr);
	}
	public static void main(String args[]){
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<List<Integer>> arr  = new ArrayList<>();
		for(int i =0; i<n; i++){
			List<Integer> tmp = new ArrayList<Integer>();
			arr.add(tmp);
		}
		
		for(int i =0; i<n; i++){

			for(int j=0; j<n;j++){
				arr.get(i).add(sc.nextInt());
			}
		}
		solve(arr);
	}
}
