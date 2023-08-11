// https://www.acmicpc.net/problem/1158 (요세푸스 문제) - 실버5

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

/*
입력 N, K (1 ≤ K ≤ N ≤ 5,000)
  N: 사람의 수
  K: 순열의 크기

출력 요세푸스 순열
 */
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    StringBuilder result = new StringBuilder();
    result.append("<");

    Queue<Integer> queue = new LinkedList<>();
    LinkedList<Integer> list = new LinkedList<>();
    IntStream.rangeClosed(1, N).forEach(list::add);

    int index = 0;
    while (!list.isEmpty()) {
      index = (index + K - 1) % list.size();
      queue.add(list.remove(index));
    }

    while (!queue.isEmpty()) {
      result.append(queue.poll());
      if (!queue.isEmpty()) {
        result.append(", ");
      }
    }

    result.append(">");
    System.out.println(result);
  }
}
