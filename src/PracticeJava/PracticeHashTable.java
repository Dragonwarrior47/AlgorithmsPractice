package PracticeJava;

import java.util.Hashtable;
import java.util.Map;

public class PracticeHashTable {

    public static void main(String args[]){
        Hashtable<Integer, String> hm = new Hashtable<>();
        hm.put(1, "Kanhaiya");
        hm.put(2, "Mohit");
        hm.put(3, "Mortaza");
        hm.put(4, "Dharmendra");
        System.out.println(hm.getOrDefault(1,null));
        for (Map.Entry m: hm.entrySet()){
            System.out.println("k="+m.getKey()+",v="+m.getValue());
        }
    }
}
