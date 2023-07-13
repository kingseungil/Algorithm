import java.util.Arrays;

class Solution {
    private static String[] makeSuffix(String str){
        String[] result = new String[str.length()];
        
        for (int i = 0; i < str.length(); i++){
            result[i] = str.substring(i);
        }
        
        return result;
    }
    
    public String[] solution(String my_string) {
        String[] answer = makeSuffix(my_string);
        Arrays.sort(answer);
        return answer;
    }
}