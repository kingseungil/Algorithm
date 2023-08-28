import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
https://www.acmicpc.net/problem/2167 (2차원 배열의 합)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Input
        String[] input1 = br.readLine().split(" ");
        int numRows = Integer.parseInt(input1[0]);
        int numCols = Integer.parseInt(input1[1]);
        int[][] arr = new int[numRows][numCols];

        for (int i = 0; i < numRows; i++) {
            String[] input2 = br.readLine().split(" ");
            for (int j = 0; j < numCols; j++) {
                arr[i][j] = Integer.parseInt(input2[j]);
            }
        }

        // 누적합 배열 생성
        int[][] cumulativeSum = new int[numRows + 1][numCols + 1];
        for (int i = 1; i <= numRows; i++) {
            for (int j = 1; j <= numCols; j++) {
                /*
                arr[i - 1][j - 1] : 현재 위치의 값
                cumulativeSum[i - 1][j] : 위쪽의 누적합
                cumulativeSum[i][j - 1] : 왼쪽의 누적합
                cumulativeSum[i - 1][j - 1] : 대각선의 누적합
                 */
                cumulativeSum[i][j] =
                  arr[i - 1][j - 1] + cumulativeSum[i - 1][j] + cumulativeSum[i][j - 1]
                    - cumulativeSum[i - 1][j - 1];
            }
        }

        int numQueries = Integer.parseInt(br.readLine());
        for (int i = 0; i < numQueries; i++) {
            String[] query = br.readLine().split(" ");
            int startRow = Integer.parseInt(query[0]);
            int startCol = Integer.parseInt(query[1]);
            int endRow = Integer.parseInt(query[2]);
            int endCol = Integer.parseInt(query[3]);

            int result = findSum(cumulativeSum, startRow, startCol, endRow, endCol);
            System.out.println(result);
        }
    }

    private static int findSum(int[][] cumulativeSum, int startRow, int startCol, int endRow,
      int endCol) {
        return cumulativeSum[endRow][endCol] - cumulativeSum[startRow - 1][endCol]
          - cumulativeSum[endRow][startCol - 1] + cumulativeSum[startRow - 1][startCol - 1];
    }
}
