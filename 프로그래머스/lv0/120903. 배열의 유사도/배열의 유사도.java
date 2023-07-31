import java.util.Arrays;

class Solution {
    public int solution(String[] s1, String[] s2) {
        int answer = 0;
        
        for (String str : s1){
            if(Arrays.asList(s2).contains(str)){
                answer++;
            }
        }
        
        return answer;
    }
}