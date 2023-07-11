class Solution {
    public int solution(String binomial) {
        int answer = 0;
        String[] splitArray = binomial.split(" ");
        
        int first = Integer.parseInt(splitArray[0]);
        int second = Integer.parseInt(splitArray[2]);
        String operator = splitArray[1];
        
        // 연산자에 따른 연산
        if (operator.equals("+")) {
          answer = first + second;
        }
        if (operator.equals("-")) {
          answer = first - second;
        }
        if (operator.equals("*")) {
          answer = first * second;
        }
        
        return answer;
    }
}