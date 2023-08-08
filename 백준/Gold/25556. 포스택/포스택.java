import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

  static FastReader scan = new FastReader();
  //정답은 sb에 append 를 사용하여 출력
  //만약 개행까지 출력하고 싶으면 append('\n')을 추가
  static StringBuilder sb = new StringBuilder();

  static int n;
  static String[] elements;
  static ArrayList<Stack<Integer>> stackList;

  public static void main(String[] args) {
    input();
    sb.append(getResult(n, elements, stackList));
    System.out.println(sb.toString());
  }

  static void input() {
    n = scan.nextInt();
    elements = scan.nextLine().split(" ");

    stackList = new ArrayList<>();
    // 4개의 stack 초기화
    for (int i = 0; i < 4; i++) {
      stackList.add(new Stack<>());
      stackList.get(i).push(0);
    }
  }

  private static String getResult(int n, String[] elements, ArrayList<Stack<Integer>> stacks) {
    int value;
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < n; i++) {
      value = Integer.parseInt(elements[i]);

      for (int j = 0; j < 4; j++) {
        if (stacks.get(j).peek() < value) {
          stacks.get(j).push(value);
          value = 0;
          break;
        }
      }
      if (value != 0) {
        result.append("NO");
        return result.toString();
      }
    }
    result.append("YES");
    return result.toString();
  }

  static class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
      br = new BufferedReader(new InputStreamReader(System.in));
    }

    public FastReader(String s) throws FileNotFoundException {
      br = new BufferedReader(new FileReader(new File(s)));
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

    double nextDouble() {
      return Double.parseDouble(next());
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