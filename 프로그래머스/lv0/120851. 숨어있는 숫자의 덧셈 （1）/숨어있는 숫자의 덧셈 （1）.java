import java.util.*;

class Solution {
    public int solution(String my_string) {
        List<Integer> numList = new LinkedList<>();
        
        for (int i = 0; i < my_string.length(); i++){
            if (Character.isDigit(my_string.charAt(i))) {
                numList.add(Integer.parseInt(String.valueOf(my_string.charAt(i))));
            }
        }
        
        return numList.stream().reduce(0,Integer::sum);
    }
}