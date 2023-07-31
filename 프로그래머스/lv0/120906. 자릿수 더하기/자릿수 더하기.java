import java.util.Arrays;

class Solution {
    public int solution(int n) {
        String[] numToList = String.valueOf(n).split("");
        
        return Arrays.stream(numToList)
            .reduce(0,(acc,cur) -> acc + Integer.parseInt(cur), Integer::sum);
    }
}