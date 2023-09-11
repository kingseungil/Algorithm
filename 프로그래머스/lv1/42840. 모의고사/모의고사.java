import java.util.*;

class Solution {
    
    private static final int[][] RULES = {
      {1, 2, 3, 4, 5},
      {2, 1, 2, 3, 2, 4, 2, 5},
      {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };
    
    private static int getPicked(int person, int problem) {
        int[] rule = RULES[person];
        int idx = problem % rule.length;
        return rule[idx];
    }
    
    public int[] solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<>();

        // 각 수포자들의 정답 개수
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        // answer 만큼 반복
        for (int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            // 각 수포자들의 정답 개수 계산
            for (int person = 0; person < 3; person++) {
                int picked = getPicked(person, i);
                if (answer == picked) {
                    if (person == 0) {
                        firstCount++;
                    } else if (person == 1) {
                        secondCount++;
                    } else {
                        thirdCount++;
                    }
                }
            }
        }
        
        // 가장 많이 맞춘 사람 찾기 (value 값이 가장 큰 key 값 찾기)
        // value값이 같은 경우 여러명이므로 모두 찾기
        int[] counts = {firstCount, secondCount, thirdCount};
        int max = Arrays.stream(counts).max().getAsInt();

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] == max) {
                result.add(i + 1);
            }
        }

        // 가장 많이 맞춘 사람이 여럿일 경우 오름차순 정렬
        result.sort((o1, o2) -> o1 - o2);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}