import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            // n번째 문자가 같을 경우에 원본 스트링을 사전순으로
            if (o1.charAt(n) == o2.charAt(n)) {
                return o1.compareTo(o2);
            }
            // n번째 문자가 다를 경우에는 n번째 문자를 기준으로 사전순으로
            return o1.charAt(n) - o2.charAt(n);
        });
        return strings;
    }
}