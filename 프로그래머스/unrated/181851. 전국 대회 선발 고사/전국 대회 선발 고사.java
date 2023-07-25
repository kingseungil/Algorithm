import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        ArrayList<Integer> intList = new ArrayList<>();
        
        for (int i = 0; i < rank.length; i++){
            map.put(rank[i],i);
        }
        
        for (int i = 0; i < rank.length; i++){
            if (attendance[i]) intList.add(rank[i]);
        }
        
        Collections.sort(intList);
        
        int a = map.get(intList.get(0));
        int b = map.get(intList.get(1));
        int c = map.get(intList.get(2));
        
        return 10000*a + 100*b + c;
    }
}