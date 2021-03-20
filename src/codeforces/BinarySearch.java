import java.util.*;


public class BinarySearch{
	
	public static int lowerThanEqualTo(List<Integer> arr, int k){
		int n = arr.size();
		int l = 0;
		int h = n-1;
		int foundSoFar = n;
		
		while (l <=h){
			int mid = l + (h - l)/2;
			System.out.println(String.format("l=%s,h=%s, mid=%s,k=%s", l,h, mid, k));	
			if (k > arr.get(mid)){
				l = mid + 1;
			}
			else{
				foundSoFar = mid;
				h = mid -1;
			}
			
		}
		return foundSoFar;
	}
	public static int solve(List<Integer> arr, int k){
		int n = arr.size();
		int l = 0;
		int h = n-1;
		
		while(l<=h){
			int mid = l + (h-l)/2;
			if(arr.get(mid) > k)
				l = mid + 1;
			else if (arr.get(mid) < k)
				h = mid -1;
			else if (arr.get(mid) == k)
				return mid + 1; 
		}
		return -1;
	}
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> arr = new ArrayList<>();
		for(int j =0 ; j<n ; j++)
			arr.add(sc.nextInt());
		int t = sc.nextInt();
		for(int i =0; i<t; i++){
			int k = sc.nextInt();
			int ndx1 = lowerThanEqualTo(arr, k);
			int ndx2 = lowerThanEqualTo(arr, k+1);
			System.out.println(String.format("[%s, %s]", ndx1, ndx2-1));
		}
	}
}
