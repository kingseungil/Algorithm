import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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

        // Process queries
        int numQueries = Integer.parseInt(br.readLine());
        for (int i = 0; i < numQueries; i++) {
            String[] query = br.readLine().split(" ");
            int startRow = Integer.parseInt(query[0]);
            int startCol = Integer.parseInt(query[1]);
            int endRow = Integer.parseInt(query[2]);
            int endCol = Integer.parseInt(query[3]);

            int result = findSum(arr, startRow, startCol, endRow, endCol);
            System.out.println(result);
        }
    }

    private static int findSum(int[][] arr, int startRow, int startCol, int endRow, int endCol) {
        int sum = 0;
        for (int i = startRow - 1; i < endRow; i++) {
            for (int j = startCol - 1; j < endCol; j++) {
                sum += arr[i][j];
            }
        }
        return sum;
    }
}
