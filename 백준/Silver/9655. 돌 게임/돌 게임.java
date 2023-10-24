import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    @Problem    돌 게임 (9655)
    @Url        https://www.acmicpc.net/problem/9655
    @Date       2023-10-24
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(getResult(N));
    }

    private static String getResult(int n) {
        return n % 2 == 0 ? "CY" : "SK";
    }
}
