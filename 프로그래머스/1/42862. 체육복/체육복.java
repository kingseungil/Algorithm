import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // 번호 순으로 순회할 수 있도록 오름차순 정렬
        // 빌려줄 수 있는 학생이 여러명일 경우 번호가 작은 학생에게 빌려주기 위함
        Arrays.sort(lost);
        Arrays.sort(reserve);

        // lost, reserve에 둘 다 포함되어있으면, 자신의 여벌 체육복 사용
        Set<Integer> owns = Arrays.stream(lost)
                                  .boxed()
                                  .collect(Collectors.toSet());
        owns.retainAll(Arrays.stream(reserve)
                             .boxed()
                             .collect(Collectors.toSet()));

        // queue에 체육복을 잃어버린 학생들을 넣어줌
        Queue<Integer> queue = new LinkedList<>();
        for (int l : lost) {
            queue.add(l);
        }

        int get = 0; // 체육복을 빌려받은 학생 수
        for (int r : reserve) {
            if (owns.contains(r)) { // 자신이 여벌 체육복을 가지고 있으면, 빌려줄 수 없음
                continue;
            }

            // queue.peek() < r - 1 : 현재 학생의 앞번호 학생이 체육복을 잃어버렸을 경우
            // owns.contains(queue.peek()) : 현재 학생의 앞번호 학생이 여벌 체육복을 가지고 있을 경우
            while (!queue.isEmpty() && (queue.peek() < r - 1 || owns.contains(queue.peek()))) {
                queue.poll(); // 체육복을 빌릴 필요가 없으므로, queue에서 제거
            }
            if (queue.isEmpty()) {
                break;
            }
            // 현재 학생의 뒷번호 학생이 체육복을 잃어버렸을 경우
            if (queue.peek() <= r + 1) {
                queue.poll();
                get++;
            }
        }
        return n - lost.length + owns.size() + get; // 전체 학생 수 - 체육복을 잃어버린 학생 수 + 여벌 체육복을 가지고 있는 학생 수 + 체육복을 빌려받은 학생 수
    }
}