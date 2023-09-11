import java.util.*;

class Solution {
    
    static final int[] FIRST = {1, 2, 3, 4, 5};
    static final int[] SECOND = {2, 1, 2, 3, 2, 4, 2, 5};
    static final int[] THIRD = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    
    public int[] solution(int[] answers) {
        ArrayList<Integer> result = new ArrayList<>();

        // 각 수포자들의 정답 개수
        int firstCount = 0;
        int secondCount = 0;
        int thirdCount = 0;

        // answer 만큼 반복
        for (int i = 0; i < answers.length; i++) {
            // 각 수포자들의 정답 개수 계산
            if (answers[i] == FIRST[i % FIRST.length]) {
                firstCount++;
            }
            if (answers[i] == SECOND[i % SECOND.length]) {
                secondCount++;
            }
            if (answers[i] == THIRD[i % THIRD.length]) {
                thirdCount++;
            }
        }

        // 가장 많이 맞춘 사람 찾기 (value 값이 가장 큰 key 값 찾기)
        // value값이 같은 경우 여러명이므로 모두 찾기
        int max = Math.max(Math.max(firstCount, secondCount), thirdCount);
        if (max == firstCount) {
            result.add(1);
        }
        if (max == secondCount) {
            result.add(2);
        }
        if (max == thirdCount) {
            result.add(3);
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