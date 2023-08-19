class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] numStr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
      "nine"};
        
        // 숫자 문자열을 숫자로 변환
        for (int i = 0; i < numStr.length; i++){
            s = s.replace(numStr[i], Integer.toString(i));
        }
        
        // 숫자 문자열을 숫자로 변환한 문자열을 숫자로 변환
        answer = Integer.parseInt(s);
        
        return answer;
    }
}