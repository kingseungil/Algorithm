import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        List<Integer> resultList = new ArrayList<>();
        
        for (int i = n-1; i < num_list.length; i++){
            resultList.add(num_list[i]);
        }
        
        // int[]로 변환
        int[] resultArray = new int[resultList.size()];
        for(int i = 0; i < resultList.size(); i++){
            resultArray[i] = resultList.get(i);
        }
        
        return resultArray;
    }
}