package LeetCode;
import java.util.*;

public class DuplicateLettersSolution {

    public static void main(String args[]){
        Solution s = new DuplicateLettersSolution.Solution();
        String ans = s.removeDuplicateLetters("bbcaac");

    }

    private static  class Solution{

        public String removeDuplicateLetters(String s) {
            Map<Character, Integer> frequencyMap = new HashMap<>();
            // O(n)
            for (int i =0 ; i<s.length(); i++){
                frequencyMap.put(s.charAt(i),frequencyMap.getOrDefault(s.charAt(i),0)+1);
            }
            List<Character> ans = new ArrayList<>();
            for(int i =0; i<s.length(); i++){
                // O(n)
                frequencyMap.put(s.charAt(i),frequencyMap.get(s.charAt(i))-1);
                if (! ans.contains(s.charAt(i))){

                    while(!ans.isEmpty() && frequencyMap.get(ans.get(ans.size()-1))>0 && ans.get(ans.size()-1)>s.charAt(i)){
                        ans.remove(ans.size()-1);
                    }
                    ans.add(s.charAt(i));
                }
            }
            StringBuilder sb = new StringBuilder();
            for (Character c: ans){
                sb.append(String.format("%s", c));
            }
            System.out.println(sb);
            return sb.toString();
        }
    }

}

