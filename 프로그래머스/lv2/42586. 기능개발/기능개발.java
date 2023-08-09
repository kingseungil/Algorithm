import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
    Queue<Integer> queue = new ArrayDeque<>(); // 각 기능의 남은 날짜를 저장하기 위한 큐
    ArrayList<Integer> answerList = new ArrayList<>();

    for (int i = 0; i < progresses.length; i++) {
      int remainingProgress = 100 - progresses[i];
      int remainingDays = (int) Math.ceil((double) remainingProgress / speeds[i]);
      queue.offer(remainingDays); // 남은 날짜를 큐에 추가
    }

    int cnt = 0; // 같은 날에 배포되는 기능 수를 세는 변수
    int prevDays = 0; // 이전 날의 남은 날짜를 저장하는 변수

    while (!queue.isEmpty()) {
      int currentDays = queue.poll(); // 큐에서 남은 날짜를 가져옴

      if (currentDays > prevDays) { // 이전 기능보다 더 많은 날이 필요한 경우
        if (prevDays > 0) {
          answerList.add(cnt); // 지금까지 배포된 기능 수를 추가
        }
        cnt = 1; // 현재 날에 배포된 기능 수를 1로 초기화
        prevDays = currentDays; // 이전 날을 업데이트
      } else {
        cnt++; // 같은 날에 배포된 기능 수를 1 증가
      }
    }

    answerList.add(cnt); // 마지막 날에 배포된 기능 수를 추가

    return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}