import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.IntStream;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.close();

        Queue queue = new LinkedList();

        // N번까지 queue에 추가
        IntStream.range(1, N + 1).forEach(x -> queue.add(x));

        // String을 계속 추가,수정해야하므로 StringBuilder선언
        StringBuilder sb = new StringBuilder();
        sb.append("<");

        while (queue.size()>1) {
            for (int i = 1; i < K ; i++) {
                // K번째 수 전까지 뺏다가 다시 넣기
                int value = (int)queue.poll();
                queue.offer(value);
            }
            // K번째수 poll하여 sb에 넣기
            sb.append(queue.poll()).append(", ");
        }
        // 마지막엔 ,대신 > 넣기
        sb.append(queue.poll()).append(">");
        System.out.println(sb);
    }
}