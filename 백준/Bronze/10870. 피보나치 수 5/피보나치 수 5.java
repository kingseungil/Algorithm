import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
    @Problem    피보나치 수 5 (10870)
    @Url        https://www.acmicpc.net/problem/10870
    @Date       2023-10-23
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getFibo(N));
    }

    private static int getFibo(int n) {
        List<Integer> fibo = new ArrayList<>();
        fibo.add(0);
        fibo.add(1);

        int idx = 2;
        while (idx <= n) {
            fibo.add(fibo.get(idx - 1) + fibo.get(idx - 2));
            idx++;
        }

        return fibo.get(n);
    }
}
