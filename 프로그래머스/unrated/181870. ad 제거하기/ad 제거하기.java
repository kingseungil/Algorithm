import java.util.*;

class Solution {
    public String[] solution(String[] strArr) {
        String[] answer = new String[strArr.length];
        int answerIdx = 0;
        
        for(String str:strArr){
            if(str.contains("ad")){
                continue;
            }
            answer[answerIdx++] = str;
        }
        
        String[] finalAnswer = Arrays.copyOf(answer,answerIdx);
        return finalAnswer;
    }
}