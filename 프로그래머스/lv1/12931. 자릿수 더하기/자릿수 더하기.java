import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;

        String[] nums = String.valueOf(n).split("");
        answer = Arrays.stream(nums).mapToInt(Integer::parseInt).sum();

        return answer;
    }
}