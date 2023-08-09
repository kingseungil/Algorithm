import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10818 (최소, 최대)
// 2023-08-29
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    int[] arr = Arrays.stream(input).map(Integer::parseInt).mapToInt(i -> i).toArray();

    sb.append(Arrays.stream(arr).min().getAsInt()).append(" ")
      .append(Arrays.stream(arr).max().getAsInt());

    System.out.println(sb);
  }
}
