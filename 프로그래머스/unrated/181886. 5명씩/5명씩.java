import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < names.length; i += 5){
            list.add(names[i]);
        }
        
        String[] result = new String[list.size()];
        list.toArray(result);
        
        return result;
    }
}