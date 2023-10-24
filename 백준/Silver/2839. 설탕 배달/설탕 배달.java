import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    @Problem    설탕 배달 (2839)
    @Url        https://www.acmicpc.net/problem/2839
    @Date       2023-10-24
 */
public class Main {

    static int[] dp = new int[5001];

    public static void main(String[] args) throws IOException {
        FastReader rd = new FastReader();
        int N = rd.nextInt();

        // 그리디
        System.out.println(greedy(N));
    }

    // 그리디
    private static int greedy(int N) {
        int count = 0;

        while (N > 0) {
            if (N % 5 == 0) {
                count += N / 5;
                N %= 5;
            } else {
                N -= 3;
                count++;
            }
        }

        return N == 0 ? count : -1;
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
