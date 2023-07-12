import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer> list = new LinkedList<>();
        for (int num : num_list){
            list.add(num);
        }
        
        list.sort(null);
        list = list.subList(0,5);
        
        int[] answer = list.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}