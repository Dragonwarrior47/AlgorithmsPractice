import java.util.TreeMap;
import java.util.Map;

public class TreeMap1{
	
	public static void main(String args[]){
		TreeMap<Integer, String> map = new TreeMap<>();
		map.put(100, "kanhaya");
		map.put(50, "Lal");
		map.put(25, "Yadav");
		
		for(Map.Entry m: map.entrySet()){
			String ans = String.format("key=%s, value=%s", m.getKey(), m.getValue());
			System.out.println(ans);
		}
		
	}
}
