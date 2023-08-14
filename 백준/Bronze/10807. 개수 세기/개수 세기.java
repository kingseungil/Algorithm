import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

/*
https://www.acmicpc.net/problem/10807 개수 세기 - 브론즈2

<입력>
N: 정수의 개수, 1 <= N <= 100
N개의 정수(공백으로 구분) (-100 <= 정수 <= 100)
v: 찾으려는 정수 (-100 <= 정수 <= 100)

<출력>
N개의 정수 중 v의 개수
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int result = 0;

    int N = Integer.parseInt(br.readLine());
    int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    int v = Integer.parseInt(br.readLine());

    for (int num : nums) {
      if (num == v) {
        result++;
      }
    }

    bw.write(result + "\n");

    bw.flush();
    bw.close();
    br.close();
  }
}
