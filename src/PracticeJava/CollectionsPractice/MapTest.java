package PracticeJava.CollectionsPractice;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String args[]){
        Map<String, Integer> staff = new HashMap<String, Integer>();
        staff.put("144-25-5464", 23789);
        staff.put("567-24-2546", 384);
        staff.put("157-62-7935", 2384);
        staff.put("456-62-5527", 437);
        /**
         * Example of keySet
         */
        for(String val: staff.keySet()){
            System.out.println(val);
        }
        /**
         * Example of Values
         */
        for(Integer val: staff.values()){
            System.out.println(val);
        }
        /**
         * Example of Key, Value entrySet
         */
        for(Map.Entry<String, Integer> stf: staff.entrySet()){
            System.out.printf(String.format("{%s:%s}\n", stf.getKey(), stf.getValue()));
        }
    }
}
