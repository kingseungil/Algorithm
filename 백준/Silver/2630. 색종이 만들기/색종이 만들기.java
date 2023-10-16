import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    @Problem     색종이 만들기(2630)
    @Url         https://www.acmicpc.net/problem/2630
    @Date        2023-10-16
 */
public class Main {

    static int[][] paper;
    static int white;
    static int blue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < input.length; j++) {
                paper[i][j] = Integer.parseInt(input[j]);
            }
        }

        if (!isSameColor(0, 0, N)) {
            divide(0, 0, N);
        }

        System.out.println(white);
        System.out.println(blue);
    }

    private static void divide(int row, int col, int n) {
        int newSize = n / 2;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (!isSameColor(row + newSize * i, col + newSize * j, newSize)) {
                    divide(row + newSize * i, col + newSize * j, newSize);
                }
            }
        }
    }

    private static boolean isSameColor(int row, int col, int n) {
        int color = paper[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }

        if (color == 1) {
            blue++;
        } else {
            white++;
        }

        return true;
    }
}
