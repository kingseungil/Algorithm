import java.util.*;

class Solution {
    public long[] solution(int x, int n) {
        ArrayList<Long> list = new ArrayList<>();
        
        long defaultX = (long) x;
        
        for (int i = 0; i < n; i++) {
            list.add(defaultX * (i+1));
        }
        
        return list.stream().mapToLong(Long::longValue).toArray();
    }
}