import java.util.*;


public class PowerSet{
	
	public static void generatePowerSet(List<Integer> arr){
		int n = arr.size();
		double log2 = Math.log(2);
		List<List<Integer>> ans = new ArrayList<>();
		for (int i=0; i<(1<<n); i++){
			List<Integer> tmp = new ArrayList<>();
			int bytesArray = i;
			while (bytesArray > 0){
				int lastSetbit = bytesArray & ~(bytesArray-1);
				int ndx = (int)(Math.log(lastSetbit)/log2);
				tmp.add(arr.get(ndx));
				bytesArray = bytesArray^lastSetbit;
			}
			ans.add(tmp);
			
			
		}
		System.out.println(ans);	
	
	}
	public static void main(String args[]){
		List<Integer> arr = new ArrayList<>(List.of(1,2,2));
		generatePowerSet(arr);
	}
}
