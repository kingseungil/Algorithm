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

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[3] = dp[5] = 1;

        for (int i = 6; i <= N; i++) {
            if (dp[i - 3] != Integer.MAX_VALUE || dp[i - 5] != Integer.MAX_VALUE) {
                dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);
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
