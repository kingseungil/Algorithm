import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] square;

    public static void main(String[] args) throws IOException {
        FastReader rd = new FastReader();
        int N = rd.nextInt();
        square = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] row = rd.nextLine().split("");
            for (int j = 0; j < N; j++) {
                square[i][j] = row[j].equals(".") ? 0 : 1;
            }
        }

        int row = 0;
        int col = 0;

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (square[i][j] == 0) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        row++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) {
                row++;
            }
        }
        
        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (square[j][i] == 0) {
                    cnt++;
                } else {
                    if (cnt >= 2) {
                        col++;
                    }
                    cnt = 0;
                }
            }
            if (cnt >= 2) {
                col++;
            }
        }
        
        System.out.println(row + " " + col);
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
