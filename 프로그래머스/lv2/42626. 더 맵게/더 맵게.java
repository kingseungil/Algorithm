import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : scoville) {
          pq.add(num);
        }

        while (pq.peek() < K) {
          // 모든 음식의 스코빌 지수를 K 이상으로 만들 수 없는 경우
          if (pq.size() == 1) {
            return -1;
          }

          // 가장 맵지 않은 음식의 스코빌 지수
          int first = pq.poll();
          // 두 번째로 맵지 않은 음식의 스코빌 지수
          int second = pq.poll();

          // 섞은 음식의 스코빌 지수
          int mix = first + (second * 2);
          pq.add(mix);

          // 섞은 횟수
          answer++;
        }

        return answer;
    }
}