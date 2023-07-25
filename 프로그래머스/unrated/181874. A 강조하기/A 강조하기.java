class Solution {
    public String solution(String myString) {
        String answer = "";
        
        String lower = myString.toLowerCase();
        answer = lower;
        
        for (int i = 0; i < answer.length(); i++){
            if (answer.charAt(i) == 'a') {
                String replaced = answer.replace('a','A');
                answer = replaced;
            }
        }
        return answer;
    }
}