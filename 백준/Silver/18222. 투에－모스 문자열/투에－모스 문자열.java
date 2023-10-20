import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    @Problem    투에-모스 문자열(18222)
    @Url        https://www.acmicpc.net/problem/18222
    @Date       2023-10-20
 */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long k = Long.parseLong(br.readLine());

        System.out.println(solution(k - 1));
    }

    private static int solution(long k) {
        if (k == 0) {
            return 0;
        }

        if ((k & 1) == 0) {
            return solution(k / 2);
        } else {
            return 1 - solution(k / 2);
        }
    }
}
