import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
https://www.acmicpc.net/problem/11047 (동전 0)
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int cnt = 0; // 동전 개수
        int sum = 0; // 동전 합

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i = coins.length - 1; i >= 0; i--) {
            if (coins[i] > K) {
                continue;
            }
            cnt += K / coins[i]; // 해당 동전을 몇 개 사용할 수 있는지
            K %= coins[i]; // 해당 동전을 사용하고 남은 금액

            if (sum == K) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
