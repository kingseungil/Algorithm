import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int num : arr){
            if(num % divisor == 0){
                resultList.add(num);
            }
        }
        
        if(resultList.isEmpty()){
            resultList.add(-1);
        }
        
        resultList.sort(Integer::compareTo);
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}