import java.util.*;

class Solution {
    public int solution(String s) {
       int count = 0;
        char[] str = s.toCharArray();

        if (str.length == 0 || str.length % 2 == 1) {
            return 0;
        }

        // 0 ~ s.length() - 1 까지 회전
        for (int offset = 0; offset < s.length(); offset++) {
            if (check(str, offset)) {
                count++;
            }
        }

        return count;
    }
    
    private static boolean check(char[] s, int offset) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length; i++) {
            char c = s[(offset + i) % s.length]; // 회전한 문자열의 인덱스
            switch (c) {
                case '(' -> stack.push(')');
                case '[' -> stack.push(']');
                case '{' -> stack.push('}');
                case ')', ']', '}' -> {
                    if (stack.isEmpty() || stack.pop() != c) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}