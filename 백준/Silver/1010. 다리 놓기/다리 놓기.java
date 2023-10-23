import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    @Problem    다리 놓기 (1010)
    @Url        https://www.acmicpc.net/problem/1010
    @Date       2023-10-23
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] split = br.readLine().split(" ");
            System.out.println(getResult(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
        }
    }

    private static long getResult(int west, int east) {
        long[][] dp = new long[east + 1][east + 1];

        for (int i = 0; i <= east; i++) {
            dp[i][0] = 1;
            if (i <= west) {
                dp[i][i] = 1;
            }
        }
        for (int i = 2; i <= east; i++) {
            for (int j = 1; j < i && j <= west; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }

        return dp[east][west];
    }
}
