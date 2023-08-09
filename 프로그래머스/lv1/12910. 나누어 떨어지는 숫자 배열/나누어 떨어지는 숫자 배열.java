import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for(int num : arr){
            if(num % divisor == 0){
                resultList.add(num);
            }
        }
        
        resultList.sort(Integer::compareTo);
        
        if(resultList.isEmpty()){
            resultList.add(-1);
        }
        
        return resultList.stream().mapToInt(Integer::intValue).toArray();
    }
}