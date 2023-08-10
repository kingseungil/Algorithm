import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    int a = Integer.parseInt(input[2]);
    int h = Integer.parseInt(br.readLine());
      
    long result = 1L;
    for (int i = 0; i < n - 1; i++) {
      result = (result * m) % 1000000007;
    }
    System.out.println(result);  
  }
}
