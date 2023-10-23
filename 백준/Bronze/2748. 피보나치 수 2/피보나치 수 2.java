import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    @Problem    피보나치 수 2 (2748)
    @Url        https://www.acmicpc.net/problem/2748
    @Date       2023-10-23
 */
public class Main {

    static long[] fibo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getFibo(N));
    }

    private static long getFibo(int n) {
        fibo = new long[n + 1];
        fibo[0] = 0;
        fibo[1] = 1;

        int idx = 2;
        while (idx <= n) {
            fibo[idx] = fibo[idx - 1] + fibo[idx - 2];
            idx++;
        }

        return fibo[n];
    }
}
