import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/1890 (점프)
 */
public class Main {

    public static int[][] board;
    public static long[][] dp; // dp[i][j] : (i, j)까지 도달할 수 있는 경로의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 게임판의 크기

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp = new long[N][N];
        dp[0][0] = 1; // 시작점
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (dp[i][j] == 0 || (i == N - 1 && j == N - 1)) {
                    continue;
                }

                int value = board[i][j];
                int down = i + value;
                int right = j + value;

                // 아래로 이동 가능한 경우
                if (down < N) {
                    dp[down][j] += dp[i][j];
                }
                // 오른쪽으로 이동 가능한 경우
                if (right < N) {
                    dp[i][right] += dp[i][j];
                }
            }
        }
        System.out.println(dp[N - 1][N - 1]);
    }

}
