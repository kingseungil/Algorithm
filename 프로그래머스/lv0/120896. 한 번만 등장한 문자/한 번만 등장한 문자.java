import java.util.*;

class Solution {
    public String solution(String s) {
        ArrayList<Character> resultList = new ArrayList<>();
        HashMap<Character,Integer> map = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }

        for (char c : s.toCharArray()) {
            if (map.get(c) == 1) {
                resultList.add(c);
            }
        }
        
        Collections.sort(resultList);
        
        StringBuilder result = new StringBuilder();
        for (char c : resultList) {
            result.append(c);
        }
        
        return result.toString();
    }
}