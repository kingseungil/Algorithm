import java.util.Arrays;

class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
         // 모든 원소의 합의 제곱
        int sum = Arrays.stream(num_list).sum();
        int sum_square = sum * sum;
        
        // 모든 원소의 곱
        int mul = Arrays.stream(num_list).reduce(1, (a, b) -> a * b);
        answer = sum_square > mul ? 1 : 0;
        return answer;
    }
}