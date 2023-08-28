import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2167 (2차원 배열의 합)

<입력>
첫째 줄에 배열의 크기 N, M(1 ≤ N, M ≤ 300)이 주어진다. 다음 N개의 줄에는 M개의 정수로 배열이 주어진다.
배열에 포함되어 있는 수는 절댓값이 10,000보다 작거나 같은 정수이다.
그 다음 줄에는 합을 구할 부분의 개수 K(1 ≤ K ≤ 10,000)가 주어진다.
다음 K개의 줄에는 네 개의 정수로 i, j, x, y가 주어진다(1 ≤ i ≤ x ≤ N, 1 ≤ j ≤ y ≤ M).

https://www.acmicpc.net/board/view/1315#comment-4205 참고
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int m = Integer.parseInt(input1[1]);

        int[][] arr = new int[n][m];

        // 2차원 배열 입력받기
        for (int i = 0; i < n; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
            }
        }

        int result = 0;
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            String[] input3 = br.readLine().split(" ");
            int _i = Integer.parseInt(input3[0]);
            int _j = Integer.parseInt(input3[1]);
            int _x = Integer.parseInt(input3[2]);
            int _y = Integer.parseInt(input3[3]);

            result = findSum(arr, _i, _j, _x, _y);

            System.out.println(result);
        }

    }

    private static int findSum(int[][] arr, int _i, int _j, int _x, int _y) {
        int sum = 0;
        for (int i = _i - 1; i < _x; i++) {
            for (int j = _j - 1; j < _y; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
