import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
https://www.acmicpc.net/problem/2003 (수들의 합 2)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[] input2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt)
                             .toArray();

        // 투포인터
        int left = 0;
        int right = 0;
        int sum = 0;
        int answer = 0;

        while (true) {
            if (sum >= M) {
                sum -= input2[left++];
            } else if (right == N) {
                break;
            } else {
                sum += input2[right++];
            }

            if (sum == M) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
