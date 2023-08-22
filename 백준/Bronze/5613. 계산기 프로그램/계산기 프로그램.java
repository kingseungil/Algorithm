import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 문제: https://www.acmicpc.net/problem/5613
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = Integer.parseInt(br.readLine());
        while (true) {
            String operator = br.readLine();
            if (operator.equals("=")) {
                break;
            }
            int operand = Integer.parseInt(br.readLine());
            result = calculate(result, operator, operand);
        }

        System.out.println(result);
    }

    public static int calculate(int result, String operator, int operand) {
        switch (operator) {
            case "+" -> result += operand;
            case "-" -> result -= operand;
            case "*" -> result *= operand;
            case "/" -> result /= operand;
        }
        return result;
    }
}
