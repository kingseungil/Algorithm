import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> answerList = new ArrayList<>();

    int days = 0; // 현재 필요한 최대 작업일 수
    int cnt = 0; // 같은 날에 배포되는 기능의 수를 세는 변수

    for (int i = 0; i < progresses.length; i++) {
      int remainingProgress = 100 - progresses[i];
      int remainingDays = (int) Math.ceil((double) remainingProgress / speeds[i]);

      // 현재 필요한 최대 작업일 수보다 더 많이 걸린다면
      if (remainingDays > days) {
        days = remainingDays;
        // 이전까지의 배포 기능 수를 추가
        if (i > 0) {
          answerList.add(cnt);
        }
        cnt = 1; // 현재 배포 기능 수를 1로 초기화
      } else {
        cnt++; // 현재 배포 기능 수를 1 증가
      }
    }

    answerList.add(cnt); // 마지막 날에 배포된 기능 수를 추가

    return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}