import java.util.*;

class Main {
    public static void main(String[] args){
        int[] result = {1, 1, 2, 2, 2, 8};
        int[] input = new int[6];
        int[] output = new int[6];
        // 입력부분
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < input.length; i++) {
            input[i] = sc.nextInt();
            if (input[i] != result[i]) {
                output[i] = result[i] - input[i];
            } else {
                output[i] = 0;
            }
        }
        sc.close();
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
    }
}