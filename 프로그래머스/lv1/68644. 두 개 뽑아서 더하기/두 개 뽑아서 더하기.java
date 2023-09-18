import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new TreeSet<>();

        // 두 수를 뽑아서 더한 값들을 set에 저장한다.
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                set.add(sum);
            }
        }

        return set.stream()
                  .mapToInt(Integer::intValue)
                  .toArray();
    }
}