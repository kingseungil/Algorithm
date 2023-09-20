import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        for (int h = citations.length; h >= 1; h--) {
            if (isValid(citations, h)) {
                return h;
            }
        }
        return 0; // h-index가 0인 경우
    }

    private static boolean isValid(int[] citations, int h) {
        int idx = citations.length - h; // h번 이상 인용된 논문의 개수
        return citations[idx] >= h; // h번 이상 인용된 논문의 개수가 h편 이상이면 true
    }
}