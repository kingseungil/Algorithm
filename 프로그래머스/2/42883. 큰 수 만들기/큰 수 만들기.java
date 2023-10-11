import java.util.Stack;
import java.util.stream.Collectors;

class Solution {
    public String solution(String number, int k) {
        Stack<Character> stack = new Stack<>();
        for (char c : number.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && c > stack.peek()) { // 현재 검사하는 문자보다 스택에 있는 수가 작으면, 스택에서 제거
                stack.pop();
                k--; // 제거할 때마다 k 감소
            }
            stack.push(c); // 현재 검사하는 문자를 스택에 삽입
        }
        while (k > 0) { // k가 0보다 크면, 스택에서 k개의 수를 제거
            stack.pop();
            k--;
        }

        return stack.stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining());
    }
}