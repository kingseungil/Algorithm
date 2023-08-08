import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());
    Stack<String> stack = new Stack<>();

    for (int i = 0; i < T; i++) {
      String[] input = br.readLine().split("");
      boolean checkFlag = true;

      for (String s : input) {
        if (s.equals("(")) {
          stack.push(s);
        } else {
          if (stack.isEmpty()) {
            checkFlag = false;
            break;
          } else {
            stack.pop();
          }
        }
      }
      if (checkFlag && stack.isEmpty()) {
        sb.append("YES\n");
      } else {
        sb.append("NO\n");
      }
      stack.clear();  
    }
    System.out.print(sb.toString());
  }
}