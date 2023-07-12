import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        List<Integer> list = new LinkedList<>();
        
        for (int num : arr) {
            // num 값 만큼 list에 추가
            for (int i = 0; i < num; i++){
                list.add(num);
            }
        }
        
        answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}