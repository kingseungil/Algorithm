import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
         LinkedList<Integer> listAfter = new LinkedList<>();
        // 배열의 첫번째 수는 비교대상이 아니므로 바로 넣어줌
        listAfter.add(arr[0]);
        // 배열의 첫번째 수를 기준으로 아래의 반복문을 실행(조건문에 의해 첫번째 수가 바뀜) 
        for (int num : arr){
            if (arr[0] != num){
                listAfter.add(num);
                arr[0] = num;
            }
        }
        int[] answer = listAfter.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}