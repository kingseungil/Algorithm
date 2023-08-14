import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/*
https://www.acmicpc.net/problem/2830 행성 X3 - 골드3

<입력>
N: 거주민의 수
N개의 줄에 걸쳐 거주민의 이름(자연수)

<출력>
행성 X3의 가치
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int[] bitCount = new int[21]; // 입력이 10^6까지 가능하므로 2^20까지의 비트를 저장할 수 있어야 함

    int N = Integer.parseInt(br.readLine());

    for (int i = 0; i < N; i++) {
      int num = Integer.parseInt(br.readLine());
      for (int j = 0; j < 21; j++) {
        // num의 j번째 비트가 1이면 bitCount의 j번째 인덱스에 1을 더함
        if ((num & (1 << j)) != 0) {
          bitCount[j]++;
        }
      }
    }

    long answer = 0;
    for (int i = 0; i < 21; i++) {
      // 1의 개수가 i인 비트의 개수 * 0의 개수가 i인 비트의 개수
      long pair = (long) bitCount[i] * (N - bitCount[i]);
      // i번째 비트의 가치는 2^i
      answer += pair << i;
    }

    bw.write(answer + "\n");
    bw.flush();
    bw.close();
  }
}
