import java.util.*;

class Solution {
    public int solution(String s) {
       int count = 0;

        // 0 ~ s.length() - 1 까지 회전
        for (int i = 0; i < s.length(); i++) {
            String rotated = s.substring(i) + s.substring(0, i);
            if (check(rotated)) {
                count++;
            }
        }

        return count;
    }
    
    private static boolean check(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '[' || c == '(' || c == '{') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if ((c == ']' && top != '[') || (c == ')' && top != '(') || (c == '}'
                  && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}