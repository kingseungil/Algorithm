import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int n) {
        
        int[] answer = arr;
        // 짝수라면
        if (arr.length % 2 == 0) {
          for (int i = 1; i < arr.length; i = i + 2) {
            answer[i] = arr[i] + n;
          }
        } 
        // 홀수라면
        else {
          for (int i = 0; i < arr.length; i = i + 2) {
            answer[i] = arr[i] + n;
          }
        }
        return answer;
    }
}