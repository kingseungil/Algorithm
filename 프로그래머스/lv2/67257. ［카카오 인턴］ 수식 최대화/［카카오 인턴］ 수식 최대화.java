import java.util.LinkedList;
import java.util.StringTokenizer;

/*
 * 수식 최대화
 * level 2
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */
class Solution {

    // 연산자 우선순위
    private static final String[][] precedences = {
      "+-*".split(""),
      "+*-".split(""),
      "-+*".split(""),
      "-*+".split(""),
      "*+-".split(""),
      "*-+".split("")
    };

    private static long calculate(long left, long right, String op) {
        return switch (op) {
            case "+" -> left + right;
            case "-" -> left - right;
            case "*" -> left * right;
            default -> 0;
        };
    }

    private static long calculate(LinkedList<String> tokens, String[] precedence) {
        for (String op : precedence) {
            for (int i = 0; i < tokens.size(); i++) {
                if (tokens.get(i).equals(op)) {
                    long left = Long.parseLong(tokens.get(i - 1));
                    long right = Long.parseLong(tokens.get(i + 1));
                    long result = calculate(left, right, op);
                    // 연산자와 피연산자를 제거하고 연산 결과를 넣는다.
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.remove(i - 1);
                    tokens.add(i - 1, String.valueOf(result));
                    i -= 2;
                }
            }
        }
        return Long.parseLong(tokens.get(0));
    }

    public static void main(String[] args) {
        String expression = "100-200*300-500+20";
        long result = solution(expression);
        System.out.println(result);
    }

    public static long solution(String expression) {
        StringTokenizer st = new StringTokenizer(expression, "+-*", true); // 숫자와 연산자를 구분자로 나누기
        LinkedList<String> list = new LinkedList<>();
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }

        long max = 0;
        for (String[] precedence : precedences) {
            long value = Math.abs(calculate(new LinkedList<>(list), precedence));
            if (value > max) {
                max = value;
            }
        }
        return max;
    }
}
