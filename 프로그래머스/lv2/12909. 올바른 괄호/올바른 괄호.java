import java.util.Stack;

// stack사용안한 풀이
class Solution {
       boolean solution(String s){
        boolean answer = false;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                count++;
            }
            if (s.charAt(i) == ')'){
                count--;
            }
            if (count<0){
                break;
            }
        }
        // count = 0 이라는건 쌍이 맞춰졌다는 뜻
        if (count == 0){
            answer = true;
        }
        return answer;
    }
}

// stack사용한 풀이
import java.util.Stack;

class Solution {
    boolean solution(String s){
        boolean answer = false;
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()){
                    return false;
                }
                stack.pop();
            }
        }
        if (stack.isEmpty()){
            answer = true;
        }
        return answer;
    }
}
