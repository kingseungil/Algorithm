import java.util.stream.IntStream;

class Solution {
    public int[] solution(int n) {
        int[] result = IntStream.rangeClosed(1,n).filter(i -> i % 2 == 1).toArray();
        
        return result;
    }
}