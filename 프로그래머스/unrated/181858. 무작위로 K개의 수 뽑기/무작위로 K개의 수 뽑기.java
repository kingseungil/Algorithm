import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        // set 자료형을 이용하여 중복 제거
        Set<Integer> set = new LinkedHashSet<>();
        for(int num : arr){
            set.add(num);
        }
        
        // k만큼 answer 배열 만들어주기
        int[] answer = new int[k];
        
        // 우선 answer 배열을 -1로 채워준다
        Arrays.fill(answer,-1);
        
        // set 크기만큼 반복문을 돌려서 answer 배열에 값을 넣어준다.
        int i = 0;
        for (int j : set){
            if (i >= k){
                break;
            }
            answer[i] = j;
            i++;
        }
        
        return answer;
    }
}