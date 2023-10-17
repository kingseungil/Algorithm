import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    @Problem     222-풀링 (17829)
    @Url         https://www.acmicpc.net/problem/17829
    @Date        2023-10-17
 */
public class Main {

    static int[][] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        numbers = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                numbers[i][j] = Integer.parseInt(input[j]);
            }
        }

        System.out.println(polling(0, 0, N));
    }

    private static int polling(int row, int col, int n) {
        if (n == 1) {
            return numbers[row][col];
        }

        n /= 2;

        int[] results = {
          polling(row, col, n), // 왼쪽 위
          polling(row + n, col, n), // 오른쪽 위
          polling(row, col + n, n), // 왼쪽 아래
          polling(row + n, col + n, n) // 오른쪽 아래
        };

        Arrays.sort(results);

        return results[2];
    }
}
