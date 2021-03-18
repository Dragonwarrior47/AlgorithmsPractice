import java.util.*;


public class RandomSampling{
	public static void solve(List<Integer> arr){
		System.out.println(arr);
		int k = arr.size()-2;
		Random gen = new Random();
		for(int i = 0; i<k; i++){
			Collections.swap(arr, i, i + gen.nextInt(arr.size()-i));
		}
		System.out.println(arr);
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int i =0; i<n; i++){
			arr.add(sc.nextInt());
		}
		solve(arr);
	}
}
